package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StudentStage extends Stage {
	public StudentStage() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("StartView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        setTitle("Start the quiz");
        setScene(scene);
        show();
	}
}
