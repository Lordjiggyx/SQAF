
public class Question {

	//question
	private String question;
	private surveyResponse response;

	//Question constructor
	public Question(String question) {
		this.question = question;
		this.response = new surveyResponse();
	}
	
	//Getter and setter for question
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public surveyResponse getResponse() {
		return response;
	}

	public void setResponse(surveyResponse response) {
		this.response = response;
	}

	
}
