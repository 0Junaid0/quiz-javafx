package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.event.ActionEvent;

public class LoginController{
	@FXML
	private TextField username;

	@FXML
	private TextField password;

	@FXML
	private Button login;

	private void validateUser(String username, String password , ActionEvent event) throws IOException {
		username = username.toLowerCase();
		User user = UsersDatabase.validateLogin(username, password);
		if (user == null) {
			System.out.println("Authentication failed.");
			return;
		}
		
		switch (user.role) {
		case "admin":
			new AdminStage();
			break;
		case "student":
			new StudentStage();
			break;
		default:
			throw new RuntimeException("Invalid role found");
		}
		
		
	}

	@FXML
	public void loginButton(ActionEvent event) throws IOException {
		 validateUser(username.getText(),password.getText(),event);
	}
}
