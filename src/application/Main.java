package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;



 
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Populate users database.
			UsersDatabase.addUser(new User("junaid", "12345", User.ROLE_STUDENT));
			UsersDatabase.addUser(new User("admin", "123456", User.ROLE_ADMIN));
			UsersDatabase.addUser(new User("faculty", "1234567", User.ROLE_FACULTY));

			Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml")); 
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
