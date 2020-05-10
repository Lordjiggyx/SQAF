import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

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
}
