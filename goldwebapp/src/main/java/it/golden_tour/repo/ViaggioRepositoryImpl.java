package it.golden_tour.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.golden_tour.entities.PacchettoVo;
import it.golden_tour.entities.ViaggioVo;
import it.golden_tour.services.JDBCService;

@Repository(value = "viaggiRepository")
public class ViaggioRepositoryImpl implements ViaggioRepository{

	@Autowired(required=true)
	private JDBCService jdbcService;

	@Override
	public void insertViaggio(ViaggioVo viaggio) throws Exception {
		
		Connection connection = null;
		String query = "INSERT INTO sys.viaggio(ID_VIAGGIO,TIPOLOGIA_MEZZO,DATA_INIZIO,DATA_FINE,NOME_VIAGGIATORE,COGNOME_VIAGGIATORE,N_POSTI,COSTO_VIAGGIO) VALUES (?,?,?,?,?,?,?,?) ";
		
		try {
			
			connection = jdbcService.getDatabaseConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, viaggio.getId());
			ps.setString(2, viaggio.getTipologiaMezzo());
			ps.setString(3, viaggio.getDataInizio());
			ps.setString(4, viaggio.getDataFine());
			ps.setString(5, viaggio.getNomeViaggiatore());
			ps.setString(6, viaggio.getCognomeViaggiatore());
			ps.setInt(7, viaggio.getNumeroPosti());
			ps.setFloat(8, viaggio.getCostoViaggio());
			ps.executeUpdate();			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception("Errore durante l'inserimento del viaggio.");
			
		} finally {
			
			if(connection != null) 
				connection.close();
			
		}
		
	}

	@Override
	public void deleteViaggio(ViaggioVo viaggio) throws Exception {

		Connection connection = null;
		String query = " DELETE FROM sys.VIAGGIO WHERE ID_VIAGGIO = ?";
		
		try {
			
			connection = jdbcService.getDatabaseConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, viaggio.getId());
			ps.executeUpdate();			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception("Errore durante l'eliminazione del viaggio.");
			
		} finally {
			
			if(connection != null) 
				connection.close();
			
		}
		
	}

	@Override
	public void updateViaggio(ViaggioVo viaggio) throws Exception {
		
		Connection connection = null;
		String query = " UPDATE sys.VIAGGIO SET ID_VIAGGIO = ?, TIPOLOGIA_MEZZO = ?, DATA_INIZIO = ?, DATA_FINE = ?, NOME_VIAGGIATORE = ?, COGNOME_VIAGGIATORE = ?, N_POSTI = ?, COSTO_VIAGGIO = ?  " 
				+ "WHERE ID_VIAGGIO = ?";
		
		try {
			
			connection = jdbcService.getDatabaseConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, viaggio.getId());
			ps.setString(2, viaggio.getTipologiaMezzo());
			ps.setString(3, viaggio.getDataInizio());
			ps.setString(4, viaggio.getDataFine());
			ps.setString(5, viaggio.getNomeViaggiatore());
			ps.setString(6, viaggio.getCognomeViaggiatore());
			ps.setInt(7, viaggio.getNumeroPosti());
			ps.setFloat(8, viaggio.getCostoViaggio());
			ps.executeUpdate();			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception("Errore durante l'aggiornamento del viaggio.");
			
		} finally {
			
			if(connection != null) 
				connection.close();
			
		}
	}

	@Override
	public List<ViaggioVo> getAllViaggi(Long id) throws Exception {
		
		List<ViaggioVo> listaViaggi = new ArrayList<ViaggioVo>();
		Connection connection = null;
		String query = "select * from sys.viaggio";
		
		try {
			
			connection = jdbcService.getDatabaseConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				ViaggioVo p = new ViaggioVo();
				p.setId(rs.getLong("ID_VIAGGIO"));
				p.setTipologiaMezzo(rs.getString("TIPOLOGIA_MEZZO"));
				p.setDataInizio(rs.getString("DATA_INIZIO"));
				p.setDataFine(rs.getString("DATA_FINE"));
				p.setNomeViaggiatore(rs.getString("NOME_VIAGGIATORE"));
				p.setCognomeViaggiatore(rs.getString("COGNOME_VIAGGIAOTORE"));
				p.setNumeroPosti(rs.getInt("N_POSTI"));
				p.setCostoViaggio(rs.getFloat("COSTO_VIAGGIO"));
				listaViaggi.add(p);
			}			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception("Errore durante la richiesta della lista dei viaggi.");
			
		} finally {
			
			if(connection != null) 
				connection.close();
			
		}
		return listaViaggi;
	}
	
}
