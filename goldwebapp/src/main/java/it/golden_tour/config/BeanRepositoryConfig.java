package it.golden_tour.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
	 * File di configuazione dei bean delle risorse.
	 *
	 */

	@Configuration
	@PropertySources({ @PropertySource("classpath:application.properties") })
	public class BeanRepositoryConfig {

		/** Parametri connessione database. */
		@Value("${datasource.url}")
		private String databaseUrl;
		@Value("${datasource.username}")
		private String databaseUsername;
		@Value("${datasource.password}")
		private String databasePassword;
		@Value("${datasource.databaseName}")
		private String databaseName;
		

		@Bean
		public ConfigBean getConfigBean() {
			ConfigBean cb = new ConfigBean();
			cb.setDatabasePassword(databasePassword);
			cb.setDatabaseUsername(databaseUsername);
			cb.setDatabaseUrl(databaseUrl);
			cb.setDatabaseName(databaseName);
			return cb;
		}

	}
