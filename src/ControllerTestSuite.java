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
	
}
