package it.golden_tour.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository(value= "adminRepository")
public class AdminRepositoryImpl implements AdminRepository {
	
	@Override
	public boolean isAdmin(Long id) {
		
		Connection connection = null;
		boolean isAdmin = false;
		
		try {
			
			connection = databaseService.getDatabaseConnection();
			
			PreparedStatement ps = connection.prepareStatement();
			
			ps.executeQuery("select u.* from sys.utente u join sys.tipologia_utente t on u.id_tipologia = t.id_tipologia_utente where id_utente = ? and id_tipologia = 1");
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				isAdmin = true;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isAdmin;
	}
}
