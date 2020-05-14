import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class ControllerTestSuite {

	Tester test = new Tester();
	
	@Test
	public void EmptysurveyCreationTest()
	{
		Survey s = test.createSurveyEmpty();
		
		assertTrue("Should be an object of type survey", s instanceof Survey);
	}
	
	@Test
	public void surveyCreationTest()
	{
		//Creation of question object
		Question one = new Question("Customer Service");
		//Collection to represent questions
		ArrayList<Question> questions = new ArrayList<Question>();
		questions.add(one);
		
		Survey s = test.createSurvey(questions);
		assertTrue("Should be an object of type survey", s instanceof Survey);

	}
	
	@Test 
	public void addQuestion()
	{
		
		Survey s = test.createSurveyEmpty();
		Question one = new Question("Customer Service");
		assertEquals("Length of questions array should be 1",1 ,test.addQuestion(one, s));
	}
	
	@Test 
	public void surveyResponseCreationTest()
	{
		Survey s = test.createSurveyEmpty();
		Question one = new Question("Customer Service");
		Question two = new Question("Food Quality");
		s.add(one);
		s.add(two);
		
		surveyResponse sr = test.createSurveyResponse(s);
		assertTrue("Should be an object of type survey Response",sr instanceof surveyResponse);

	}
	
	@Test 
	public void questionAnswer()
	{
		Question one = new Question("Food Quality");
		test.questionAnswer(one);
		assertEquals("method should return a value thus proving that the answer attribute is not 0" ,1, one.getAnswer());

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void questionAnswerValue()
	{
		Question one = new Question("Food Quality");
		one.setAnswer(-1);
		
	}
	
	
}
