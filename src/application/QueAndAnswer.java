package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class QueAndAnswer extends Stage {
	/**
	 * Holds the list of question objects read from the file.
	 */
    private ArrayList<QuestionDTO> questions = new ArrayList<QuestionDTO>();
    
    /**
     * List of answers.
     */
    private ArrayList<String> answers = new ArrayList<String>();
    
    private static int currentQuestionIndex = 0;

    @FXML
    private Label questionLabel;

    @FXML
    private Label counterLabel;

    @FXML
    private RadioButton option1;

    @FXML
    private RadioButton option2;

    @FXML
    private RadioButton option3;

    @FXML
    private RadioButton option4;
    
    @FXML
    private Button previousButton;

    @FXML
    private Button nextButton;
    
    private ToggleGroup optionGroup;

	public QueAndAnswer() throws IOException {
		// Read all the questions from the file.
		if (questions.isEmpty()) {
    		readQuestions();    		
    	}
		currentQuestionIndex = 0;
		optionGroup = new ToggleGroup();

    	for (int i = 0; i < questions.size(); i++) {
    		System.out.println(questions.get(i));
    	}
	}
	
	@FXML
    public void initialize(){
		// Load first question.
		showQuestion(currentQuestionIndex);
		RadioButton selectedOption = (RadioButton) optionGroup.getSelectedToggle();
		answers.set(currentQuestionIndex, selectedOption.getText());
		previousButton.setDisable(true);
    }
	
	private void showQuestion(int index) {
		QuestionDTO q = questions.get(index);

		counterLabel.setText("" + (index + 1));
		questionLabel.setText(q.question);
		option1.setText(q.choice1);
		option2.setText(q.choice2);
		option3.setText(q.choice3);
		option4.setText(q.choice4);

		option1.setToggleGroup(optionGroup);
		option2.setToggleGroup(optionGroup);
		option3.setToggleGroup(optionGroup);
		option4.setToggleGroup(optionGroup);
		
		// Select the first option as the initial choice of answer.
		String selectedAnswer = answers.get(index);
		for (int i = 0; i < 4; i++) {
			RadioButton tg = (RadioButton) optionGroup.getToggles().get(i);
			if (tg.getText().equals(selectedAnswer)) {
				optionGroup.selectToggle(tg);
			}
		}
	}
	
	@FXML
	public void onSubmit(ActionEvent event) {
		RadioButton selectedOption = (RadioButton) optionGroup.getSelectedToggle();
		answers.set(currentQuestionIndex, selectedOption.getText());

		int correctAnswers = 0;
		for (int i = 0; i < answers.size(); i++) {
			QuestionDTO q = questions.get(i);
			String curAnswer = answers.get(i);
			if (q.answer.equals(curAnswer)) {
				correctAnswers++;
			}
		}
		
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Evaluation result");
		alert.setHeaderText("Correct answers out of " + answers.size());
		alert.setContentText("" + correctAnswers);
		alert.show();
	}
	
	@FXML
	public void onNext(ActionEvent event) {
		RadioButton selectedOption = (RadioButton) optionGroup.getSelectedToggle();
		answers.set(currentQuestionIndex, selectedOption.getText());

		currentQuestionIndex++;
		if (currentQuestionIndex >= questions.size()) {
			currentQuestionIndex = questions.size() - 1;
		}
		showQuestion(currentQuestionIndex);
		
		nextButton.setDisable(currentQuestionIndex + 1 >= questions.size());
		previousButton.setDisable(currentQuestionIndex <= 0);
	}
	
	@FXML
	public void onPrevious(ActionEvent event) {
		RadioButton selectedOption = (RadioButton) optionGroup.getSelectedToggle();
		answers.set(currentQuestionIndex, selectedOption.getText());

		currentQuestionIndex--;
		if (currentQuestionIndex < 0) {
			currentQuestionIndex = 0;
		}
		showQuestion(currentQuestionIndex);
		
		nextButton.setDisable(currentQuestionIndex + 1 >= questions.size());
		previousButton.setDisable(currentQuestionIndex <= 0);
	}
    
    private void readQuestions() throws IOException {
    	try (BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Junaid\\eclipse-workspace\\QuizAppFx\\src\\application\\QuizQuestionFile.txt"))) {
			ArrayList<String> allLines = new ArrayList<String>();

			String line = null;
			while ((line = in.readLine()) != null) {
				allLines.add(line);
				System.out.println(line);
			}
			
			for (int i = 0; i < allLines.size(); i += 7) {
				String question = allLines.get(i);
				String choice1 = allLines.get(i+1);
				String choice2 = allLines.get(i+2);
				String choice3 = allLines.get(i+3);
				String choice4 = allLines.get(i+4);
				String answer = allLines.get(i+5);
				QuestionDTO quesObj = new QuestionDTO(question, choice1, choice2, choice3, choice4, answer);
				
				questions.add(quesObj);
				answers.add(choice1);
			}
		}
    }
}
