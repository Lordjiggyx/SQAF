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
}
