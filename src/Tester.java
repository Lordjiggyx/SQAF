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
		//Creation of a new survey response object
		surveyResponse sr = new surveyResponse();
		assertTrue("Should be an object of type survey Response",sr instanceof surveyResponse);
	}

	//Test to see that an answer to a surevy response is being added
	@Test
	public void responseAnswer()
	{
		//Creation of a new survey response object
		surveyResponse sr = new surveyResponse();
		//set an answer to the surevy response
		sr.setAnswer(1);
		assertEquals("method should return a value thus proving that the answer attribute is not 0" ,1, sr.getAnswer());
	}

	//Test to see that the value is between 1-5
	@Test
	public void repsoneValue()
	{
		//Creation of a new survey response object
		surveyResponse sr = new surveyResponse();
		//set an answer to the surevy response
		sr.setAnswer(1);
		assertEquals("should pass value is between 1-5 meaing that 0 is not being returned",1, sr.getAnswer());

		sr.setAnswer(6);
		assertEquals("should pass value is greater than 1-5 meaning that 0 is returned", 0, sr.getAnswer());

		sr.setAnswer(-1);
		assertEquals("should pass value is less than 1-5 meaning that 0 is returned", 0,sr.getAnswer());

	}

	//Test to see if response can be obtained from question
	@Test
	public void questionResponse()
	{

		//Creation of question objectS
		Question one = new Question("Customer Service");
		

		//adding answer to question response
		one.getResponse().setAnswer(2);
		

		//test by getting the first questions response answer attribute
		assertEquals("value should be 2",2,one.getResponse().getAnswer());

	}


//	//Test to see if survey responses can be obtained from survey 
//	public void surveyResponse()
//	{
//		//Creation of a survey
//		Survey s = new Survey();
//
//		//Creation of question objectS
//		Question one = new Question("Customer Service");
//		Question two = new Question("Food Quality");
//
//		//adding answer to question response
//		one.getResponse().setAnswer(2);
//		two.getResponse().setAnswer(3);
//		//Questions being added to survey
//		s.add(one);
//		s.add(two);
//
//		//exepected arralyist being returned
//		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(2,3));
//		
//		//Test to see if the response lists match
//		assertArrayEquals("ArrayList should equal [2,3]", expected,s.getResponses());
//
//	}

}
