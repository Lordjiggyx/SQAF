import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class Tester {

	//Test to create an empty survey
	@Test
	public void createSurveyEmpty()
	{		
		Survey s = new Survey();
		assertTrue("Should be an object of type survey",s instanceof Survey);
	}

	//Test to create a survey with a name and questions
	@Test
	public void createSurvey()
	{		
		//Creation of question object
		Question one = new Question("Customer Service");
		//Collection to represent questions
		ArrayList<Question> questions = new ArrayList<Question>();
		//adding question to list
		questions.add(one);

		Survey s = new Survey("My Questions" ,questions);
		assertTrue("Should be an object of type survey",s instanceof Survey);
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

	//Test to check that questions are being added to the survey
	@Test
	public void addQuestion()
	{
		//Creation of question objectS
		Question one = new Question("Customer Service");
		Question two = new Question("Food Quality");

		//Creation of survey class with just name
		Survey s = new Survey("My Questions");
		//adding questions to the surevy
		s.add(one);
		s.add(two);

		assertEquals("Length of questions array should be 2",2 ,s.getQuestions().size());
	}

	//Test to check that survey response class is created
	@Test
	public void createSurveyResponse()
	{		
		//Creation of question objectS
		Question one = new Question("Customer Service");
		Question two = new Question("Food Quality");

		//Creation of survey class with just name
		Survey s = new Survey("My Questions");
		//adding questions to the surevy
		s.add(one);
		s.add(two);
		
		//Creation of a new survey response object
		surveyResponse sr = new surveyResponse(s.getQuestions());
		assertTrue("Should be an object of type survey Response",sr instanceof surveyResponse);
	}
	
	//Test for a question answer
	@Test
	public void questionAnswer()
	{
		//Creation of question objwct
		Question one = new Question("Food Quality");
		//Set the answer value of the question
		one.setAnswer(1);
		assertEquals("method should return a value thus proving that the answer attribute is not 0" ,1, one.getAnswer());
	}
	
	//Test to see if thw question answer value is between 1-5
	@Test(expected = IllegalArgumentException.class)
	public void questionAnswerValue()
	{
		//Creation of question objwct
		Question one = new Question("Food Quality");
		//Set the answer value of the question
		//Exception returned meaning the test passed
		one.setAnswer(7);
		//A failure occurs when value is within 1-5 meaning an exception was not given
		one.setAnswer(2);
	}
	
	//Test to see if survey responses can be obtained from survey 
	@Test
	public void surveyResponse()
		{
			//Creation of a survey
			Survey s = new Survey();

			//Creation of question objectS
			Question one = new Question("Customer Service");
			Question two = new Question("Food Quality");

			//adding answer to question response
			one.setAnswer(2);
			two.setAnswer(3);
			//Questions being added to survey
			s.add(one);
			s.add(two);
			
			//Creating survey response
			surveyResponse sr = new surveyResponse(s.getQuestions());
			
			//adding survey response to survey
			s.addResponse(sr);

			//exepected arralyist being returned
			ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(2,3));
			
			//Get the first survey response and the corresponding answers in the object
			ArrayList<Integer> actual = s.getResponses().get(0).getResponses();
			
			//Test to see if the response lists match
			assertEquals("ArrayList should equal [2,3]", expected , actual);

		}

	//Test to get average deviation of a survey
	@Test
	public void aveDev()
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
		assertEquals("average Deviation should be 1.04", 1.04 , s.getAverageDeviation() ,1e-15);

	}
	
	//Test for the standard deviation
	@Test
	public void standardDeviation()
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
				assertEquals("standard Deviation should be 1.33", 1.33 , s.getStandardDeviation() ,1e-15);
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
	
}
