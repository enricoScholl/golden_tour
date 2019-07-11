package it.golden_tour.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.golden_tour.entities.PrenotazioneVo;
import it.golden_tour.services.JDBCService;

@Repository(value = "prenotazioneRepository")
public class PrenotazioneRepositoryImpl implements PrenotazioneRepository{
	
	@Autowired(required=true)
	private JDBCService jdbcService;

	@Override
	public void insertPrenotazione(PrenotazioneVo prenotazione) throws Exception {
		
		Connection connection = null;
		String query = " INSERT INTO sys.prenotazione(ID_PRENOTAZIONE,ID_PACCHETTO_PRENOTAZIONE,ID_VIAGGIO_PRENOTAZIONE,ID_UTENTE_PRENOTAZIONE,COSTO_TOTALE) VALUES (?,?,?,?,?) ";
		
		try {
			
			connection = jdbcService.getDatabaseConnection();
			connection.setAutoCommit(false);
			
			PreparedStatement ps = connection.prepareStatement(query);
			
			
			ps.setString(1, prenotazione.getId());
			ps.setLong(2, prenotazione.getIdPacchetto());
			ps.setLong(3, prenotazione.getIdViaggio());
			ps.setLong(4, prenotazione.getIdUtente());
			ps.setDouble(5, prenotazione.getCostoTotale());
			ps.executeUpdate();	
			connection.commit();
			
		} catch (Exception e) {
			
			connection.rollback();
			e.printStackTrace();
			throw new Exception("Errore durante l'inserimento della prenotazione.");
			
		} finally {
			if(connection != null) 
				connection.close();
		}
		
	}

	@Override
	public void deletePrenotazione(PrenotazioneVo prenotazione) throws Exception {

		Connection connection = null;
		String query = " DELETE FROM sys.PRENOTAZIONE WHERE ID_PRENOTAZIONE = ?";
		try {
			
			connection = jdbcService.getDatabaseConnection();
			connection.setAutoCommit(false);
			
			PreparedStatement ps = connection.prepareStatement(query);
			
			
			ps.setString(1, prenotazione.getId());
			ps.executeUpdate();	
			connection.commit();
			
		} catch (Exception e) {
			
			connection.rollback();
			e.printStackTrace();
			throw new Exception("Errore durante l'eliminazione della prenotazione.");
			
		} finally {
			if(connection != null) 
				connection.close();
		}
		
	}

	@Override
	public void updatePrenotazione(PrenotazioneVo prenotazione) throws Exception {
		
		Connection connection = null;
		String query = " UPDATE sys.PRENOTAZIONE SET ID_PACCHETTO_PRENOTAZIONE = ?, ID_VIAGGIO_PRENOTAZIONE = ?, ID_UTENTE_PRENOTAZIONE = ?, COSTO_TOTALE = ? "
				+ "WHERE ID_PRENOTAZIONE = ?";
		try {
			
			connection = jdbcService.getDatabaseConnection();
			connection.setAutoCommit(false);
			
			PreparedStatement ps = connection.prepareStatement(query);
			
			
			ps.setLong(1, prenotazione.getIdPacchetto());
			ps.setLong(2, prenotazione.getIdViaggio());
			ps.setLong(3, prenotazione.getIdUtente());
			ps.setDouble(4, prenotazione.getCostoTotale());
			ps.setString(5, prenotazione.getId());
			ps.executeUpdate();			
			connection.commit();
			
		} catch (Exception e) {
			
			connection.rollback();
			e.printStackTrace();
			throw new Exception("Errore durante l'aggiornamento della prenotazione.");
			
		} finally {
			if(connection != null) 
				connection.close();
		}
	}

	@Override
	public List<PrenotazioneVo> getAllPrenotazioniByUser(Long id) throws Exception {
		
		List<PrenotazioneVo> listPrenotazioni = new ArrayList<PrenotazioneVo>();
		
		Connection connection = null;
		String query = "SELECT p.* FROM sys.PRENOTAZIONE p INNER JOIN sys.UTENTE u ON p.ID_UTENTE_PRENOTAZIONE = u.ID_UTENTE WHERE p.ID_UTENTE_PRENOTAZIONE = ? ";
		try {
			
			connection = jdbcService.getDatabaseConnection();
			
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				PrenotazioneVo p = new PrenotazioneVo();
				p.setId(rs.getString("ID_PRENOTAZIONE"));
				p.setIdPacchetto(rs.getLong("ID_PACCHETTO_PRENOTAZIONE"));
				p.setIdViaggio(rs.getLong("ID_VIAGGIO_PRENOTAZIONE"));
				p.setIdUtente(rs.getLong("ID_UTENTE_PRENOTAZIONE"));
				p.setCostoTotale(rs.getFloat("COSTO_TOTALE"));
				 
				listPrenotazioni.add(p);
			}	
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception("Errore durante la richiesta della lista di prenotazioni.");
			
		} finally {
			if(connection != null) 
				connection.close();
		}
		return listPrenotazioni;
	}
	
	

}
