import java.util.ArrayList;

public class Survey {
	
	//Name of survey
	private String name;
	//Collection to represent questions
	private ArrayList<Question> questions = new ArrayList<Question>();

	//Empty Constructor just to show that class can be created
	public Survey() 
	{
		
	}
	
	//Constructor taking in a name and list of questions
	public Survey(String name, ArrayList<Question> questions) {
		this.name = name;
		this.questions = questions;
	}
	
	//Constructor taking in a name
	public Survey(String name) {
		this.name = name;

	}
	
	//method to add questions
	public void add(Question q)
	{
		this.questions.add(q);
	}
	
	//Getters and setter for survey
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<Question> questions) {
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
			int value = q.getResponse().getAnswer();
			responses.add(value);
		}
		
		//return the repsonse values
		return responses;
	}

}
