package application;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminStage extends Stage {

	public AdminStage() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AdminView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        setTitle("Admin!");
        setScene(scene);
        show();
	}
	
}
