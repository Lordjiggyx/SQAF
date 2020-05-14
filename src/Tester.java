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

	//create a survey with populated questions
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
	
	@Test
	public void maxQuestion()
	{
		
		//Creation od questions and setting answer values
		Question one = new Question("Customer Service");
		one.setAnswer(3);
		Question two = new Question("Food Quality");
		two.setAnswer(2);
		
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
			nq.setAnswer(2);
			//added to a list to represent the questions with different value answers
			questions1.add(nq);
		}
		
		//Same process
		ArrayList<Question> questions2 = new ArrayList<Question>();
		for(Question q :s.getQuestions() )
		{
			Question nq = new Question(q.getQuestion());
			nq.setAnswer(1);
			questions2.add(nq);
		}


		//creating a survey response object that takes in the surveys questions and questions with different answers
		surveyResponse sr = new surveyResponse(s.getQuestions());
		surveyResponse sr1 = new surveyResponse(questions1);
		surveyResponse sr2 = new surveyResponse(questions2);

		//adding the survey response to the objects
		s.addResponse(sr);
		s.addResponse(sr1);
		s.addResponse(sr2);
		
		//Feel free to uncomment and check the responses for different surevy responses
//		System.out.println(s.getResponses().get(0).getResponses());
//		System.out.println(s.getResponses().get(1).getResponses());
//		System.out.println(s.getResponses().get(2).getResponses());

		
		assertEquals("max repsonse for question 1 should be 3", 3 , s.getMaxiumQuestion(0));
		
	}
	
	@Test
	public void minQuestion()
	{
		
		//Creation od questions and setting answer values
		Question one = new Question("Customer Service");
		one.setAnswer(1);
		Question two = new Question("Food Quality");
		two.setAnswer(2);
		
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
		
		//Same process
		ArrayList<Question> questions2 = new ArrayList<Question>();
		for(Question q :s.getQuestions() )
		{
			Question nq = new Question(q.getQuestion());
			nq.setAnswer(3);
			questions2.add(nq);
		}


		//creating a survey response object that takes in the surveys questions and questions with different answers
		surveyResponse sr = new surveyResponse(s.getQuestions());
		surveyResponse sr1 = new surveyResponse(questions1);
		surveyResponse sr2 = new surveyResponse(questions2);

		//adding the survey response to the objects
		s.addResponse(sr);
		s.addResponse(sr1);
		s.addResponse(sr2);
		
		//Feel free to uncomment and check the responses for different surevy responses
//		System.out.println(s.getResponses().get(0).getResponses());
//		System.out.println(s.getResponses().get(1).getResponses());
//		System.out.println(s.getResponses().get(2).getResponses());

		
		assertEquals("min repsonse for question 1 should be 1", 1 , s.getMinimumQuestion(0));
		
	}
}
