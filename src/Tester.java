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

	//Test to see if collection of questions exists within survey object
	@Test
	public void surveyQuestions()
	{		
		//Creation of question object
		Question one = new Question("Customer Service");
		//Collection to represent questions
		ArrayList<Question> questions = new ArrayList<Question>();
		//adding question to list
		questions.add(one);

		Survey s = new Survey("My Questions" ,questions);
		assertTrue("Should be an object of type arralylist",s.getQuestions() instanceof ArrayList);
	}

	//check to see that item has been added and survey has a list returns length of the arraylist
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

	public surveyResponse createSurveyResponse(Survey surv)
	{		
		//Creation of a new survey response object
		surveyResponse sr = new surveyResponse(surv.getQuestions());
		return sr;
	}
	

	public int questionAnswer(Question q)
	{
		//Creation of question objwct
		Question one = q;
		//Set the answer value of the question
		one.setAnswer(1);
		return one.getAnswer();
	}
	

	
	
	public ArrayList<Integer> surveyResponse(Survey s)
		{
			//Get the first survey response and the corresponding answers in the object
			ArrayList<Integer> actual = s.getResponses().get(0).getResponses();
			return actual;

		}

	//Test to get average deviation of a survey
	@Test
	public double aveDev(Survey s)
	{		
		return s.getAverageDeviation();
	}
	
	//Test for the standard deviation
	@Test
	public double standardDeviation(Survey s)
	{
		return s.getStandardDeviation();
	}
	
	//Test for the max score in a survey
	@Test
	public void maxSurvey()
	{
		//Creation of question objectS
				Question one = new Question("Customer Service");
				one.setAnswer(3);
				Question two = new Question("Food Quality");
				two.setAnswer(1);
				Question three = new Question("Food Quality");
				three.setAnswer(3);
				Question four = new Question("Food Quality");
				four.setAnswer(4);
				Question five = new Question("Food Quality");
				five.setAnswer(5);
			
				

				//Creation of survey class with just name
				Survey s = new Survey("My Questions");
				//adding questions to the surevy
				s.add(one);
				s.add(two);
				s.add(three);
				s.add(four);
				s.add(five);

				//Have to pass in delta which is the maximum delta between expected and actual for which both numbers are still considered equal.
				assertEquals("maximum value should be 5", 5 , s.getMaxium());
	}
	
	//Test for the min score in a survey
	@Test
	public void minSurvey()
	{
		//Creation of question objectS
				Question one = new Question("Customer Service");
				one.setAnswer(3);
				Question two = new Question("Food Quality");
				two.setAnswer(3);
				Question three = new Question("Food Quality");
				three.setAnswer(3);
				Question four = new Question("Food Quality");
				four.setAnswer(4);
				Question five = new Question("Food Quality");
				five.setAnswer(5);
			
				

				//Creation of survey class with just name
				Survey s = new Survey("My Questions");
				//adding questions to the surevy
				s.add(one);
				s.add(two);
				s.add(three);
				s.add(four);
				s.add(five);

				assertEquals("maximum value should be 3", 3 , s.getMinimum());
	}
	
	@Test
	public void aveDevQuestion()
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
		//Use this link to check if the calculation is correct https://miniwebtool.com/average-deviation-calculator/
//		System.out.println(s.getResponses().get(0).getResponses());
//		System.out.println(s.getResponses().get(1).getResponses());
//		System.out.println(s.getResponses().get(2).getResponses());

		assertEquals("average Deviation should be 0.89", 0.89 , s.averageDeviationQuestion(0) ,1e-15);
		
	}
	
	@Test
	public void stanDevQuestion()
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
		//Use this link to check if the calculation is correct https://www.mathsisfun.com/data/standard-deviation-calculator.html
//		System.out.println(s.getResponses().get(0).getResponses());
//		System.out.println(s.getResponses().get(1).getResponses());
//		System.out.println(s.getResponses().get(2).getResponses());

		
		assertEquals("standard Deviation should be 0.82", 0.82 , s.StandardDeviationQuestion(1) ,1e-15);
		
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
