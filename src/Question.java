
public class Question {

	//question
	private String question;

	//int value for survey response answer cast so null can be returned
	private int answer;
	

	//Question constructor
	public Question(String question) {
		this.question = question;

	}
	
	//Getter and setter for question
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		
		//if the answer value passed in is less than 1 0r greater then 5 then an exception is given
		if(answer < 1 || answer > 5)
		{
			 throw new IllegalArgumentException("Value must be between 1 and 5" + answer );
		}
		//if answer value passed in is between 1-5 the answer is set to the passed in value
		else
		{
			this.answer = answer;
		}
	}


	
}
