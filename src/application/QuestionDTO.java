package application;

public class QuestionDTO {
	public String question;
	public String choice1;
	public String choice2;
	public String choice3;
	public String choice4;
	public String answer;

	public QuestionDTO(String question, String choice1, String choice2, String choice3, String choice4, String answer) {
		super();
		this.question = question;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
		this.answer = answer;
	}
	
	@Override
	public String toString() {
		return "QuestionDTO [question=" + question + ", choice1=" + choice1 + ", choice2=" + choice2 + ", choice3="
				+ choice3 + ", choice4=" + choice4 + ", answer=" + answer + "]";
	}
}
