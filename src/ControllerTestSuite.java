import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ControllerTestSuite {

	Tester test = new Tester();
	
	@Test
	public void EmptysurveyCreationTest()
	{
		Survey s = test.createSurveyEmpty();
		
		assertTrue("Should be an object of type survey", s instanceof Survey);
	}
	
}
