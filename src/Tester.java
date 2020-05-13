import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

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

	
}
