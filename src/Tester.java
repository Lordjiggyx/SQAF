import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class Tester {

	
	//Create an empty survey
	public Survey createSurveyEmpty()
	{		
		Survey s = new Survey();
		return s;
	}

	//create a survey with questions
	public Survey createSurvey(ArrayList<Question> inputQuestions)
	{		

		ArrayList<Question> questions = inputQuestions;
		Survey s = new Survey("My Questions" ,questions);
		return s;
	}


	//add question to survey
	public int addQuestion(Question q , Survey surv)
	{
		//Creation of question objectS
		Question one = q;
		//Creation of survey class with just name
		Survey s = surv;
		//adding questions to the surevy
		s.add(one);
		
		return s.getQuestions().size();

	}

	//create survey response
	public surveyResponse createSurveyResponse(Survey surv)
	{		
		//Creation of a new survey response object
		surveyResponse sr = new surveyResponse(surv.getQuestions());
		return sr;
	}
	
	//set question answer
	public int questionAnswer(Question q)
	{
		//Creation of question objwct
		Question one = q;
		//Set the answer value of the question
		one.setAnswer(1);
		return one.getAnswer();
	}
	
	//getting the responses of a survey response
	public ArrayList<Integer> surveyResponse(Survey s)
		{
			//Get the first survey response and the corresponding answers in the object
			ArrayList<Integer> actual = s.getResponses().get(0).getResponses();
			return actual;

		}

	//get average deviation of survey
	public double aveDev(Survey s)
	{		
		return s.getAverageDeviation();
	}
	
	//get standard deviation of survey
	public double standardDeviation(Survey s)
	{
		return s.getStandardDeviation();
	}
	
	//get maximum value of survey
	public int maxSurvey(Survey s)
	{
		return s.getMaxium();
	}
	
	//get minimum value of a survey
	public int minSurvey(Survey s)
	{
		return s.getMinimum();
	}
	
	//get average deviation of a certain question in the survey
	public double aveDevQuestion(Survey s , int index)
	{
			return s.averageDeviationQuestion(index);
	}
	
	//get standard deviation of a certain question in the survey
	public double stanDevQuestion(Survey s , int index)
	{
		return s.StandardDeviationQuestion(index);
	}
	
	//max score of a question
	public int maxQuestion(Survey s , int index)
	{
		return s.getMaxiumQuestion(index);
		
	}
	//min score of a question
	public int minQuestion(Survey s , int index)
	{
		return s.getMinimumQuestion(index);
	}
	
	//get survey by name
	public Survey getSurvey(ArrayList<Survey> surveys , String name)
	{
		Survey returning = new Survey("WRONG SURVEY");
		for(Survey s: surveys)
		{
			if(s.getName().equals(name))
			{
				returning= s;
			}

		}
		return returning;
	}
	
	//get responses of a specific survey
	public ArrayList<surveyResponse> ResponsebySurveyName(ArrayList<Survey> surveys , String name)
	{
		ArrayList<surveyResponse> responses = null;
		for(Survey s: surveys)
		{
			if(s.getName().equals(name))
			{
				responses= s.getResponses();
			}

		}
		return responses;
	}
	
	@Test
	public void sumOfResponses()
	{
		//make survey and questions
		Survey s = new Survey();
		Question one = new Question("Customer Service"); 
		one.setAnswer(4);
		Question two = new Question("Food Quality");
		two.setAnswer(5);
		Question three = new Question("Food Quality");
		three.setAnswer(2);
		Question four = new Question("Food Quality");
		four.setAnswer(2);
		//Questions added to survey
		s.add(one);
		s.add(two);
		s.add(three);
		s.add(four);
		
		//survey response created with questions from survey
		surveyResponse sr = new surveyResponse(s.getQuestions());
		//Test to see that 4+5+2+2 = 13 PASS
		assertEquals("Sum of survet repsonse should be 13" ,13 , sr.getResponsesSum());
	}

	@Test
	public void adsr()
	{
		//Creation od questions and setting answer values
		Question one = new Question("Customer Service");
		one.setAnswer(3);
		Question two = new Question("Food Quality");
		two.setAnswer(4);
		
		//creation of a survey object and adding the questions to this survey
		Survey s = new Survey();
		s.add(one);
		s.add(two);
		
		//Simiulating a different set of answers for the same questions in the survey
		ArrayList<Question> questions1 = new ArrayList<Question>();
		//Keeps the names of the questions in the survey 
		for(Question q :s.getQuestions() )
		{
			//new question with name of questions from the survey
			Question nq = new Question(q.getQuestion());
			//mimics a change in answer value
			nq.setAnswer(5);
			//added to a list to represent the questions with different value answers
			questions1.add(nq);
		}
		


		//creating a survey response object that takes in the surveys questions and questions with different answers
		surveyResponse sr = new surveyResponse(s.getQuestions());
		surveyResponse sr1 = new surveyResponse(questions1);

		//adding the survey response to the objects
		s.addResponse(sr);
		s.addResponse(sr1);
		
		//Feel free to uncomment and check the responses sum for different surevy responses
		//Sum = 7
		System.out.println(s.getResponses().get(0).getResponsesSum());
		
		//Sum = 10
		System.out.println(s.getResponses().get(1).getResponsesSum());
		
		//Use this link to check if the calculation is correct https://miniwebtool.com/average-deviation-calculator/	
		System.out.println(s.getADSurveyResponses());
		
		//Test to get average Deviation
		assertEquals("Average Deviation of Survey should be 1.5" ,1.5 , s.getADSurveyResponses()  ,1e-15);

	}
	
	
}
