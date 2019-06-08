package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	
	public Boolean isLogin(String user, String password) throws Exception {
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "SELECT * FROM Employee WHERE username=? AND password=?";
		
		try {
			
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, user);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				return true;
			} else {
				return false;
			}
			
			
		} catch (Exception e) {
			
			return false;
		} finally {
			pstmt.close();
			rs.close();
		}
		
	}
	
}
