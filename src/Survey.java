
import java.util.ArrayList;
import java.util.Collections;

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
		//sum of each sum from a surevy response
		int total = 0;
		
		//iterates through each survey response in survey
		for(surveyResponse sr : this.getResponses())
		{
			total+=sr.getResponsesSum();
		}
		
		
		
		//mean calculation
		double mean = (float)total/this.responses.size();
		
		//Gathering of absoulute deviations
		ArrayList<Double> absoultedev = new ArrayList<Double>();
		for(surveyResponse sr : this.getResponses())
		{
			//must be absolute value
			double abs = Math.abs(sr.getResponsesSum() - mean);
			absoultedev.add(abs);
		}
		
		//absoulute devaiation
		double totalabs = 0;
		for(double d:absoultedev)
		{
			totalabs+=d;
		}
		
		double aveDev = Math.round((float)totalabs/this.responses.size() * 100.0)/100.0;

		
		return aveDev;
		
	}
	
	public double getStandardDeviation()
	{
		//sum of each sum from a surevy response
		int total = 0;

		//iterates through each survey response in survey
		for(surveyResponse sr : this.getResponses())
		{
			total+=sr.getResponsesSum();
		}

		//mean calculation
		double mean = (float)total/this.responses.size();

		//Gathering of the square of each value 
		ArrayList<Double> squares = new ArrayList<Double>();
		for(surveyResponse sr : this.getResponses())
		{
			//square the result of each sum minus the sum
			double square = (sr.getResponsesSum()-mean) *(sr.getResponsesSum()-mean);
			squares.add(square);
		}

		//Total of squares
		double totalsquaress = 0;
		for(double d:squares)
		{
			totalsquaress+=d;
		}
		totalsquaress = totalsquaress/this.responses.size(); 

		//Standard deviation by getting square root of the sum of  squares
		double stanDev = Math.sqrt(totalsquaress);
		//rounded and returned 
		return Math.round(stanDev* 100.0)/100.0;
	}
	
	public int getMaxium()
	{
		
		//value to represent max
		int max = 0;
		//list for all the values from each question
		ArrayList<Integer> values = new ArrayList<Integer>();

		//adding question answer to list
		for(surveyResponse sr : this.getResponses())
		{
			values.add(sr.getResponsesSum());
		}
		//getting the max value and retunring it
		max = Collections.max(values);
		return max;
	}
	
	public int getMinimum()
	{
		//value to represent max
		int max = 0;
		//list for all the values from each question
		ArrayList<Integer> values = new ArrayList<Integer>();

		//adding question answer to list
		for(surveyResponse sr : this.getResponses())
		{
			values.add(sr.getResponsesSum());
		}
		//getting the max value and retunring it
		max = Collections.min(values);
		return max;
	}
	
	public double averageDeviationQuestion(int index)
	{
		//sum of question values
		int total = 0;
		
		for(surveyResponse sr: this.responses)
		{
			//adds the values of the questions that have been selected
			total+= sr.questions.get(index).getAnswer();
		}

		//mean calculation
		double mean = (float)total/this.responses.size();
	
		//Gathering of absoulute deviations
		ArrayList<Double> absoultedev = new ArrayList<Double>();
		for(surveyResponse sr: this.responses)
		{
			double abs = Math.abs(sr.questions.get(index).getAnswer() - mean);
			absoultedev.add(abs);
		}

		//absoulute devaiation
		double totalabs = 0;
		for(double d:absoultedev)
		{
			totalabs+=d;
		}

		//average deviation
		double aveDev = Math.round((float)totalabs/this.responses.size() * 100.0)/100.0;

		return Double.valueOf(aveDev);
		
	}
	
	public double StandardDeviationQuestion(int index)
	{
		//sum of question values
		int total = 0;

		//Looping through the values to get sum
		for(surveyResponse sr: this.responses)
		{
			//adds the values of the questions that have been selected
			total+= sr.questions.get(index).getAnswer();
		}

		//mean calculation
		double mean = (float)total/this.responses.size();
		
		//Gathering of the square of each value 
		ArrayList<Double> squares = new ArrayList<Double>();
		for(surveyResponse sr: this.responses)
		{
			double square = (sr.questions.get(index).getAnswer()-mean) *(sr.questions.get(index).getAnswer()-mean);
			squares.add(square);
		}
		
		//Total of squares
		double totalsquaress = 0;
		for(double d:squares)
		{
			totalsquaress+=d;
		}
		totalsquaress = totalsquaress/this.responses.size(); 
		
		//Standard deviation by getting square root of the sum of  squares
		double stanDev = Math.sqrt(totalsquaress);
		//rounded and returned 
		return Math.round(stanDev* 100.0)/100.0;
	}
	
	
	public int getMaxiumQuestion(int index)
	{
		
		//value to represent max
		int max = 0;
		//list for all the values from each question
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		//adding question answer to list
		for(surveyResponse sr: this.responses)
		{
			values.add(sr.questions.get(index).getAnswer());
		}
		//getting the max value and retunring it
		max = Collections.max(values);
		return max;
	}
	
	public int getMinimumQuestion(int index)
	{
		int min = 0;
		//value to represent 
		ArrayList<Integer> values = new ArrayList<Integer>();
		//list for all the values from each question

		//adding question answer to list

		for(surveyResponse sr: this.responses)
		{
			values.add(sr.questions.get(index).getAnswer());
		}
		//getting the min value and retunring it
		min = Collections.min(values);
		return min;
	}
	
	

}
