package it.golden_tour.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.golden_tour.entities.UtenteVo;
import it.golden_tour.services.JDBCService;

@Repository(value="utenteRepository")
public class UtenteRepositoryImpl implements UtenteRepository{
	
		@Autowired
		public JDBCService databaseService;

		@Override
		public void newUser(UtenteVo utente) throws Exception {
			
			Connection connection = null;
			String query = "insert into sys.utente (ID_UTENTE, ID_TIPOLOGIA, NOME_UTENTE, COGNOME_UTENTE, USERNAME, PASSWORD) VALUES (?, ?, ?, ?, ?, ?) ";
			
			try {
				
				connection = databaseService.getDatabaseConnection();
				connection.setAutoCommit(false);
				
				PreparedStatement ps = connection.prepareStatement(query);				
				
				ps.setLong(1, utente.getId());
				ps.setLong(2, utente.getTipologia());
				ps.setString(3, utente.getNome());
				ps.setString(4, utente.getCognome());
				ps.setString(5, utente.getUsername());
				ps.setString(6, utente.getPassword());
				
				ps.executeUpdate();
				connection.commit();
				
			} catch (SQLException e) {
				connection.rollback();
				e.printStackTrace();
			} finally {
				if(connection!=null)
					connection.close();
			}
		}

		@Override
		public UtenteVo login(String username, String password) throws Exception{
			
			Connection connection = null;
			UtenteVo user = null;
			String query = "select * from sys.utente where username_utente = ? and password_utente = ?";
			
			try {
				
				connection = databaseService.getDatabaseConnection();
				
				
				PreparedStatement ps = connection.prepareStatement(query);
				
				
				ps.setString(1, username);
				ps.setString(2, password);
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					user.setId(rs.getLong("id_utente"));
					user.setTipologia(rs.getLong("id_tipologia"));
					user.setNome(rs.getString("nome_utente"));
					user.setCognome(rs.getString("cognome_utente"));
					user.setUsername(rs.getString("username_utente"));
					user.setPassword(rs.getString("password_utente"));
				}
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
				if(connection!=null)
					connection.close();
			}
			
			return user;
		}
}
