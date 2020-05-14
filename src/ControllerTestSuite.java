import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

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
	
	@Test
	public void obtainingSurveyResponse()
	{
		Survey s = test.createSurveyEmpty();
		Question one = new Question("Customer Service");
		Question two = new Question("Food Quality");

		one.setAnswer(2);
		two.setAnswer(3);
		
		s.add(one);
		s.add(two);
		
		//Creating survey response
		surveyResponse sr = new surveyResponse(s.getQuestions());
		
		//adding survey response to survey
		s.addResponse(sr);
		
		//exepected arralyist being returned
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(2,3));
		
		assertEquals("ArrayList should equal [2,3]", expected , test.surveyResponse(s));
		
	}
	
	@Test
	public void averageDeviationSurvey()
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
				
				assertEquals("average Deviation should be 1.04", 1.04 , test.aveDev(s) ,1e-15);
	}
	
	@Test
	public void standardDeviationSurvey()
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
		assertEquals("standard Deviation should be 1.33", 1.33 , test.standardDeviation(s),1e-15);
		
	}
	
	
}
