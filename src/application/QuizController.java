package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class QuizController {

    @FXML
    private TextArea textArea;
    
    public void chooseFile(ActionEvent Event) throws IOException {
    	Path path = Paths.get("C:\\Users\\Junaid\\eclipse-workspace\\QuizAppFx\\src\\application\\QuizQuestionFile.txt");
    	byte[] d = Files.readAllBytes(path);
    	String text = new String(d);
    	textArea.setText(text);
    }
    
    public void writeInFile(ActionEvent Event) throws FileNotFoundException {
    	String text = textArea.getText();
    	System.out.println(text);
    	try (PrintWriter writer = new PrintWriter("C:\\Users\\Junaid\\eclipse-workspace\\QuizAppFx\\src\\application\\QuizQuestionFile.txt")) {
			writer.println(text);
    	}
    }

}