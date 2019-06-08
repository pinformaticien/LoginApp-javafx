package application;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginModel {

	Connection connection;
	
	public LoginModel() {
		connection = SqliteConnection.Connector();
		if (connection == null) {
			System.exit(0);
		}
	}
	
	public Boolean isDbbConnected() {
		
		try {
			return !connection.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
}
