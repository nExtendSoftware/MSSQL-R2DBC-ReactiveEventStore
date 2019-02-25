package nl.nextend.r2dbc.reactive.eventstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import io.r2dbc.mssql.MssqlConnectionConfiguration;
import io.r2dbc.mssql.MssqlConnectionFactory;

@Configuration
@EnableR2dbcRepositories
class MSSQLConfiguration extends AbstractR2dbcConfiguration {
	
	@Autowired
	private MSSQLConfigData mssql;
	
	@Bean
	@Override
	public MssqlConnectionFactory connectionFactory() {
		
		MssqlConnectionConfiguration config = MssqlConnectionConfiguration.builder() 
				.host(mssql.getIpAddress()) 
				.port(mssql.getPort()) 
				.database(mssql.getDatabaseName()) 
				.username(mssql.getUsername()) 
				.password(mssql.getPassword()) 
				.build();

		return new MssqlConnectionFactory(config);
	}

	
}