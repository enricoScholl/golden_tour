package it.golden_tour.services;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import it.golden_tour.config.ConfigBean;
import oracle.jdbc.pool.OracleDataSource;

@Service("jdbcService")
@Scope(value = "singleton")
public class JDBCService implements DatabaseService {

	@Autowired(required = true)
	private ConfigBean configBean;

	private OracleDataSource dataSource;

	@PostConstruct
	public void initService() throws Exception {

		try {

			dataSource.setURL(configBean.getDatabaseUrl());
			dataSource.setDatabaseName(configBean.getDatabaseName());
			dataSource.setUser(configBean.getDatabaseUsername());
			dataSource.setPassword(configBean.getDatabasePassword());

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
		return dataSource.getConnection();
	}

}
