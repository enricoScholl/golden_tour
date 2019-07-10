package it.golden_tour.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.golden_tour.entities.FeedbackVo;
import it.golden_tour.services.JDBCService;

@Repository(value = "feedbackRepository")
public class FeedbackRepositoryImpl implements FeedbackRepository {

	@Autowired(required=true)
	private JDBCService jdbcService;

	@Override
	public void insertFeedback(FeedbackVo feedback) throws Exception {
		
		Connection connection = null;
		String query = " INSERT INTO sys.feedback (ID_FEEDBACK,ID_PRENOTAZIONE_FEEDBACK,ORGANIZZAZIONE_VIAGGIO,SUPPORTO_CLIENTE,QUALITA_SERVIZIO) VALUES (?,?,?,?,?) ";
		
		try {
			
			connection = jdbcService.getDatabaseConnection();
			
			PreparedStatement ps = connection.prepareStatement(query);
			
			
			ps.setLong(1, feedback.getId());
			ps.setString(2, feedback.getIdPrenotazione());
			ps.setInt(3, feedback.getOrganizzazioneViaggio());
			ps.setInt(4, feedback.getSupportoCliente());
			ps.setInt(5, feedback.getQualitaServizio());
			ps.executeUpdate();			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception("Errore durante l'inserimento.");
			
		} finally {
			if(connection != null) 
				connection.close();
		}
		
	}
	
	public Long idFeedback() throws Exception {
		int a = 0; 
		Long l = null;
		Connection connection = null; 
		String query = " SELECT seq_feedback.NEXTVAL FROM dual"; 
		try {
			connection=jdbcService.getDatabaseConnection();
			PreparedStatement ps = connection.prepareStatement(query); 
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
			 a =rs.getInt("nextval");
			 l = new Long(a);
			}
			
		}catch (SQLException e) {
				
				e.printStackTrace();
				throw new Exception("Errore sequence.");
				
			} finally {
				if(connection != null) 
					connection.close(); 
		} 
		return l ;
	}
	
	@Override
	public void deleteFeedback(FeedbackVo feedback) throws Exception {

		Connection connection = null;
		String query = " DELETE FROM sys.feedback WHERE ID_FEEDBACK = ?";
		try {
			
			connection = jdbcService.getDatabaseConnection();
			
			PreparedStatement ps = connection.prepareStatement(query);
			
			
			ps.setLong(1, feedback.getId());
			ps.executeUpdate();			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception("Errore durante l'eliminazione.");
			
		} finally {
			if(connection != null) 
				connection.close();
		}
		
	}
	
	@Override
	public void updateFeedback(FeedbackVo feedback) throws Exception {
			
		Connection connection = null;
		String query = " UPDATE sys.feedback SET ID_PRENOTAZIONE_FEEDBACK = ?, ORGANIZZAZIONE_VIAGGIO = ?, SUPPORTO_CLIENTE = ?, QUALITA_SERVIZIO = ? "
				+ "WHERE ID_FEEDBACK = ?";
		try {
			
			connection = jdbcService.getDatabaseConnection();
			
			PreparedStatement ps = connection.prepareStatement(query);
			
			
			ps.setString(1, feedback.getIdPrenotazione());
			ps.setInt(2, feedback.getOrganizzazioneViaggio());
			ps.setInt(3, feedback.getSupportoCliente());
			ps.setInt(4, feedback.getQualitaServizio());
			ps.setLong(5, feedback.getId());
			ps.executeUpdate();			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception("Errore durante l'aggiornamento.");
			
		} finally {
			if(connection != null) 
				connection.close();
		}
	}
	
	@Override
	public List<FeedbackVo> getAllFeedback() throws Exception {
		
		List<FeedbackVo> listFeedback = new ArrayList<FeedbackVo>();
		
		Connection connection = null;
		String query = "SELECT f.* FROM sys.feedback f ";
		try {
			
			connection = jdbcService.getDatabaseConnection();
			
			PreparedStatement ps = connection.prepareStatement(query);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				FeedbackVo f = new FeedbackVo();
				f.setId(rs.getLong("ID"));
				f.setIdPrenotazione(rs.getString("ID_PRENOTAZIONE"));
				f.setOrganizzazioneViaggio(rs.getInt("ORGANIZZAZIONE_VIAGGIO"));
				f.setQualitaServizio(rs.getInt("QUALITA_SERVIZIO"));
				 
				listFeedback.add(f);
			}			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception("Errore durante la richiesta della lista di prenotazioni.");
			
		} finally {
			if(connection != null) 
				connection.close();
		}
		return listFeedback;
	}

}
