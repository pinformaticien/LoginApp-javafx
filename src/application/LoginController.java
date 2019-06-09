package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	public LoginModel loginModel = new LoginModel();
	
	@FXML
	private Label isConnected;
	@FXML
	private TextField usernameTfd;
	@FXML
	private TextField passwordPfd;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		if (loginModel.isDbbConnected()) {
			
			isConnected.setText("Connected");
		}else {
			isConnected.setText("Not connected");
		}
	}
	
	public void Login(ActionEvent event) {
		try {
			if(loginModel.isLogin(usernameTfd.getText(), passwordPfd.getText())) {
				isConnected.setText("Username and Password correct");
				
				((Node)event.getSource()).getScene().getWindow().hide();
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("/application/User.fxml").openStream());
				UserController userController = (UserController)loader.getController();
				userController.GetUser(usernameTfd.getText());
				
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				
			} else {
				isConnected.setText("Username or Password is not correct");
			}
		} catch (Exception e) {
			isConnected.setText("Username or Password is not correct");
			e.printStackTrace();
		}
	}

}
