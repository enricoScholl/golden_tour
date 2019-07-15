package it.golden_tour.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.golden_tour.entities.PacchettoVo;
import it.golden_tour.entities.PrenotazioneVo;
import it.golden_tour.services.JDBCService;

@Repository(value = "pacchettoRepository")
public class PacchettoRepositoryImpl implements PacchettoRepository{

		@Autowired(required=true)
		private JDBCService jdbcService;

		@Override
		public void insertPacchetto(PacchettoVo pacchetto) throws Exception {
			
			Connection connection = null;
			String query = "INSERT INTO sys.pacchetto(ID_PACCHETTO,ID_PRODOTTO_PACCHETTO,DESTINAZIONE,PREZZO_PACCHETTO) VALUES (?,?,?,?) ";
			
			try {
				
				connection = jdbcService.getDatabaseConnection();
				connection.setAutoCommit(false);
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setLong(1, pacchetto.getId());
				ps.setLong(2, pacchetto.getIdProdotto());
				ps.setString(3, pacchetto.getDestinazione());
				ps.setFloat(4, pacchetto.getPrezzoPacchetto());
				ps.executeUpdate();	
				connection.commit();
				
			} catch (Exception e) {
				
				connection.rollback();
				e.printStackTrace();
				throw new Exception("Errore durante l'inserimento del pacchetto.");
				
			} finally {
				
				if(connection != null) 
					connection.close();				
			}
			
		}

		@Override
		public void deletePacchetto(PacchettoVo pacchetto) throws Exception {

			Connection connection = null;
			String query = " DELETE FROM sys.PACCHETTO WHERE ID_PACCHETTO = ?";
			
			try {
				
				connection = jdbcService.getDatabaseConnection();
				connection.setAutoCommit(false);
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setLong(1, pacchetto.getId());
				ps.executeUpdate();
				connection.commit();
				
			} catch (Exception e) {
				
				connection.rollback();
				e.printStackTrace();
				throw new Exception("Errore durante l'eliminazione del pacchetto.");
				
			} finally {
				
				if(connection != null) 
					connection.close();
				
			}
			
		}

		@Override
		public void updatePacchetto(PacchettoVo pacchetto) throws Exception {
			
			Connection connection = null;
			String query = " UPDATE sys.PACCHETTO SET ID_PACCHETTO = ?, ID_PRODOTTO_PACCHETTO = ?, DESTINAZIONE = ?, PREZZO_PACCHETTO = ? " + 
									"WHERE ID_PACHETTO = ?";
			
			try {
				
				connection = jdbcService.getDatabaseConnection();
				connection.setAutoCommit(false);
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setLong(1, pacchetto.getId());
				ps.setLong(2, pacchetto.getIdProdotto());
				ps.setString(3, pacchetto.getDestinazione());
				ps.setFloat(4, pacchetto.getPrezzoPacchetto());
				ps.executeUpdate();	
				connection.commit();
				
			} catch (Exception e) {
				
				connection.rollback();
				e.printStackTrace();
				throw new Exception("Errore durante l'aggiornamento del pacchetto.");
				
			} finally {
				
				if(connection != null) 
					connection.close();
				
			}
		}

		@Override
		public List<PacchettoVo> getAllPacchetti() throws Exception {
			
			List<PacchettoVo> listaPacchetti = new ArrayList<PacchettoVo>();
			Connection connection = null;
			String query = "select * from sys.pacchetto";
			
			try {
				
				connection = jdbcService.getDatabaseConnection();
				
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					PacchettoVo p = new PacchettoVo();
					p.setId(rs.getLong("ID_PACCHETTO"));
					p.setIdProdotto(rs.getLong("ID_PRODOTTO_PACCHETTO"));
					p.setDestinazione(rs.getString("DESTINAZIONE"));
					p.setPrezzoPacchetto(rs.getFloat("PREZZO_PACCHETTO"));
					
					listaPacchetti.add(p);
				}	
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				throw new Exception("Errore durante la richiesta della lista dei pacchetti.");
				
			} finally {
				
				if(connection != null) 
					connection.close();
				
			}
			return listaPacchetti;
		}

	}