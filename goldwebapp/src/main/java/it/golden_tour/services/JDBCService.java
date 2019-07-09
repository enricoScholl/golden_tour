package it.golden_tour.services;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import it.golden_tour.config.ConfigBean;

@Service("jdbcService")
@Scope(value = "singleton")
public class JDBCService implements DatabaseService {

	@Autowired(required = true)
	private ConfigBean configBean;

	//private OracleDataSource dataSource;

	@PostConstruct
	public void initService() throws Exception {

		try {
/*
			dataSource.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			dataSource.setDatabaseName("XE");
			dataSource.setUser("SYSTEM");
			dataSource.setPassword("goldenTour");*/

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Errore apertura connessione.");
			System.err.println(e);
			throw e;
		}
		System.out.println("Connessione OK.");
	}

	@Override
	public Connection getDatabaseConnection() throws SQLException {
		return null;//SdataSource.getConnection();
	}

}
