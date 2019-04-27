/**
 * 
 */
package nl.nextend.r2dbc.reactive.eventstore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author veltman
 *
 */
@Component
public class MSSQLConfigData {

	@Value("${db.eventstore.url:localhost}")
	private String ipaddress;
	
	@Value("${db.eventstore.port:40133}")
	private int port;
	
	@Value("${db.eventstore.databasename:dbevents}")
	private String databaseName;
	
	@Value("${db.eventstore.username:dbuser}")
	private String username;
	
	@Value("${db.eventstore.password:password}")
	private String password;
	
	public String getIpAddress() {
		return ipaddress;
	}

	public int getPort() {
		return port;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}	
	
}