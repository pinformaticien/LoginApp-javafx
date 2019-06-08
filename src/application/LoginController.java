package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class LoginController implements Initializable {

	public LoginModel loginModel = new LoginModel();
	
	@FXML
	private Label isConnected;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		if (loginModel.isDbbConnected()) {
			
			isConnected.setText("Connected");
		}else {
			isConnected.setText("Not connected");
		}
	}

}