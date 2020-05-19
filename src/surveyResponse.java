import java.util.ArrayList;

public class surveyResponse {
	
	ArrayList<Question> questions = new ArrayList<Question>();
	
	//When a survey response is created the list of questions from the survey will be passed into the response
	public surveyResponse(ArrayList<Question> questions)
	{
		this.questions = questions;
	}
	
	//Method to create a list of the repsonses for each question in the surevy
	public ArrayList<Integer> getResponses()
	{
		//List to represent the values of each question response
		ArrayList<Integer> responses = new ArrayList<Integer>();

		//Loop to go through ecah question in the survey object
		for(Question q : this.questions)
		{
			int value = q.getAnswer();
			responses.add(value);
		}

		//return the repsonse values
		return responses;
	}

	//Method used to get the sum of answers to questions in a response
	public int getResponsesSum()
	{
		int sum = 0;
		for(int x : this.getResponses())
		{
			sum+= x;
		}
		return sum;
		
	}



	
		
	
	
	
}
