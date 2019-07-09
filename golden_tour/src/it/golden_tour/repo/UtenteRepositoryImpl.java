package it.golden_tour.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import it.golden_tour.entities.UtenteVo;

@Repository(value= "utenteRepository")

public class UtenteRepositoryImpl implements UtenteRepository {
	
	//TODO database dependency

	@Override
	public void newUser(UtenteVo utente) {
		
		Connection connection = null;
		
		try {
			
			connection = databaseService.getDatabaseConnection();
			
			PreparedStatement ps = connection.prepareStatement();
			
			ps.executeUpdate("insert into sys.utente (ID_UTENTE, ID_TIPOLOGIA, NOME_UTENTE, COGNOME_UTENTE, USERNAME, PASSWORD) VALUES ?, ?, ?, ?, ?, ? ");
			
			ps.setLong(1, utente.getId());
			ps.setLong(2, utente.getTipologia());
			ps.setString(3, utente.getNome());
			ps.setString(4, utente.getCognome());
			ps.setString(5, utente.getUsername());
			ps.setString(6, utente.getPassword());
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public UtenteVo login(String username, String password) {
		
		Connection connection = null;
		UtenteVo user = null;
		
		try {
			
			connection = databaseService.getDatabaseConnection();
			
			PreparedStatement ps = connection.prepareStatement();
			
			ps.executeQuery("select * from sys.utente where username_utente = ? and password_utente = ?");
			ps.setString(1, username);
			ps.setString(1, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				rs.getLong("id_utente");
				rs.getLong("id_tipologia");
				rs.getString("nome_utente");
				rs.getString("cognome_utente");
				rs.getString("username_utente");
				rs.getString("password_utente");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
