
import java.util.ArrayList;

public class Survey {
	
	//Name of survey
	private String name;
	//Collection to represent questions
	private ArrayList<Question> questions = new ArrayList<Question>();
	//Collection to represent survey responses
	private ArrayList<surveyResponse> responses = new ArrayList<surveyResponse>();

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
	
	//Method to return each surevy response
	public ArrayList<surveyResponse> getResponses()
	{
		return this.responses;
	}

	//Method to add a survey repsonse object to a surevy
	public void addResponse(surveyResponse sr)
	{
		this.responses.add(sr);
	}
	
	public double getAverageDeviation()
	{
		//sum of question values
		int total = 0;
		
		//Looping through the values to get sum
		for(Question q:this.questions)
		{
			total+= q.getAnswer();
		}
		
		//mean calculation
		double mean = (float)total/this.questions.size();

		//Gathering of absoulute deviations
		ArrayList<Double> absoultedev = new ArrayList<Double>();
		for(Question q:this.questions)
		{
			double abs = Math.abs(q.getAnswer() - mean);
			absoultedev.add(abs);
		}
		
		//absoulute devaiation
		double totalabs = 0;
		for(double d:absoultedev)
		{
			totalabs+=d;
		}
		
		//average deviation
		double aveDev = Math.round((float)totalabs/this.questions.size() * 100.0)/100.0;
		
		return Double.valueOf(aveDev);
		
		
		
	}
}
