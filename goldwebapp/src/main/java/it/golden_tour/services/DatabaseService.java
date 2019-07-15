package it.golden_tour.services;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseService {
	

	public  Connection getDatabaseConnection() throws SQLException;
	
}
