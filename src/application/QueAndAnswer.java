package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class QueAndAnswer {

    @FXML
    private Label Questions;

    @FXML
    private RadioButton option1;

    @FXML
    private RadioButton option2;

    @FXML
    private RadioButton option3;

    @FXML
    private RadioButton option4;
    
    int current =0,count=0;
    String q,a,b,c,d;
    public static String print(int lineNumber) throws IOException 
     {
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Junaid\\eclipse-workspace\\QuizAppFx\\src\\application\\QuizQuestionFile.txt"));
        String line = null;
        int currentLineNumber = 0;
        while((line = in.readLine()) != null){
            currentLineNumber++;
            if (currentLineNumber == lineNumber) {
                in.close();
                return line;
            }
        }
        in.close();
        return null;
     }
    
    
}
