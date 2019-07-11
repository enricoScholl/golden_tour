package it.golden_tour.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.golden_tour.entities.ProdottoVo;
import it.golden_tour.entities.ViaggioVo;
import it.golden_tour.services.JDBCService;

@Repository(value = "prodottiRepository")
public class ProdottoRepositoryImpl implements ProdottoRepository {

	@Autowired(required=true)
	private JDBCService jdbcService;

	@Override
	public void insertProdotto(ProdottoVo prodotto) throws Exception {
		
		Connection connection = null;
		String query = "INSERT INTO sys.prodotto(ID_PRODOTTO,DS_PRODOTTO) VALUES (?,?) ";
		
		try {
			
			connection = jdbcService.getDatabaseConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, prodotto.getId());
			ps.setString(2, prodotto.getDescrizione());
			
			ps.executeUpdate();			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception("Errore durante l'inserimento del prodotto.");
			
		} finally {
			
			if(connection != null) 
				connection.close();
			
		}
		
	}

	@Override
	public void deleteProdotto(ProdottoVo prodotto) throws Exception {

		Connection connection = null;
		String query = " DELETE FROM sys.PRODOTTO WHERE ID_PRODOTTO = ?";
		
		try {
			
			connection = jdbcService.getDatabaseConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, prodotto.getId());
			ps.executeUpdate();			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception("Errore durante l'eliminazione del pacchetto.");
			
		} finally {
			
			if(connection != null) 
				connection.close();
			
		}
		
	}

	@Override
	public void updateProdotto(ProdottoVo prodotto) throws Exception {
		
		Connection connection = null;
		String query = " UPDATE sys.PACCHETTO SET ID_PRODOTTO = ?, DS_PRODOTTO = ? " 
				+ "WHERE ID_PRODOTTO = ?";
		
		try {
			
			connection = jdbcService.getDatabaseConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, prodotto.getId());
			ps.setString(2, prodotto.getDescrizione());
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
	public List<ProdottoVo> getAllProdotti(Long id) throws Exception {
		
		List<ProdottoVo> listaProdotti = new ArrayList<ProdottoVo>();
		Connection connection = null;
		String query = "select * from sys.prodotto";
		
		try {
			
			connection = jdbcService.getDatabaseConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				ProdottoVo p = new ProdottoVo();
				p.setId(rs.getLong("ID_PRODOTTO"));
				p.setDescrizione(rs.getString("DS_PRODOTTO"));;
				listaProdotti.add(p);
			}			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception("Errore durante la richiesta della lista dei prodotti.");
			
		} finally {
			
			if(connection != null) 
				connection.close();
			
		}
		return listaProdotti;
	}
	
}
