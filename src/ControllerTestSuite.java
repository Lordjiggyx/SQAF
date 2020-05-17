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
	
	@Test
	public void MaximumScoreSurvey()
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

		
		assertEquals("maximum value should be 5", 5 , test.maxSurvey(s));
	}
	
	@Test
	public void MinimumScoreSurvey()
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

		
		assertEquals("minimum value should be 1", 1 , s.getMinimum());
	}

	@Test
	public void averageDeviationQuestion()
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
		
		assertEquals("average Deviation should be 0.89", 0.89 , test.aveDevQuestion(s, 0) ,1e-15);

	}
	
	@Test
	public void StandardDeviationQuestion()
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
//				System.out.println(s.getResponses().get(0).getResponses());
//				System.out.println(s.getResponses().get(1).getResponses());
//				System.out.println(s.getResponses().get(2).getResponses());

				
				assertEquals("standard Deviation should be 0.82", 0.82 , test.stanDevQuestion(s, 1) ,1e-15);
	}
	
	@Test 
	public void maximumScoreQuestion()
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
//				System.out.println(s.getResponses().get(0).getResponses());
//				System.out.println(s.getResponses().get(1).getResponses());
//				System.out.println(s.getResponses().get(2).getResponses());

				
				assertEquals("max repsonse for question 1 should be 3", 3 , test.maxQuestion(s, 0));
	}
	
	@Test
	public void minimumScoreQuestion()

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

		
		assertEquals("min repsonse for question 1 should be 1", 1 , test.minQuestion(s , 0));
		
	}
	
	@Test
	public void SurveyByName()
	{
		Survey s1 = new Survey("Survey 1");
		Survey s2 = new Survey("Survey 2");
		Survey s3 = new Survey("Survey 3");
		Survey s4 = new Survey("Survey 4");
		
		ArrayList<Survey> surveys = new ArrayList<Survey>();
		surveys.add(s1);
		surveys.add(s2);
		surveys.add(s3);
		surveys.add(s4);
		
		Survey tester = test.getSurvey(surveys, "Survey 2");
		
		assertEquals("Name of survey returned should be survey 2", "Survey 2" , tester.getName());
	}
	
	@Test
	public void surveyResponseBySurveyName()
	{
		Survey s1 = new Survey("Survey 1");
		
		Question one = new Question("Customer Service");
		one.setAnswer(1);
		Question two = new Question("Food Quality");
		two.setAnswer(2);
		
		s1.add(one);
		s1.add(two);
		
		
		//Simiulating a different set of answers for the same questions in the survey
		ArrayList<Question> questions1 = new ArrayList<Question>();
		//Keeps the names of the questions in the survey 
		for(Question q :s1.getQuestions() )
		{
			//new question with name of questions from the survey
			Question nq = new Question(q.getQuestion());
			//mimics a change in answer value
			nq.setAnswer(5);
			//added to a list to represent the questions with different value answers
			questions1.add(nq);
		}
		
		surveyResponse sr = new surveyResponse(s1.getQuestions());
		surveyResponse sr1 = new surveyResponse(questions1);
		
		s1.addResponse(sr);
		s1.addResponse(sr1);
		
		
		Survey s2 = new Survey("Survey 2");
		
		Question three = new Question("Friednliness");
		three.setAnswer(3);
		Question four = new Question("Aniaml Quality");
		four.setAnswer(1);
		
		s2.add(three);
		s2.add(four);
		
		
		
		
		surveyResponse sr3 = new surveyResponse(s2.getQuestions());

		s2.addResponse(sr3);
		
		ArrayList<Survey> surveys = new ArrayList<Survey>();
		surveys.add(s1);
		surveys.add(s2);
		
		ArrayList<Integer> expected1 = new ArrayList<Integer>(Arrays.asList(1,2));
		ArrayList<Integer> expected2 = new ArrayList<Integer>(Arrays.asList(5,5));
		ArrayList<Integer> expected3 = new ArrayList<Integer>(Arrays.asList(3,1));

		
		assertEquals("Survey 1 Response 1 should be [1,2]",expected1 , test.ResponsebySurveyName(surveys, "Survey 1").get(0).getResponses());
		assertEquals("Survey 1 Response 2 should be [5,5]",expected2 ,  test.ResponsebySurveyName(surveys, "Survey 1").get(1).getResponses());
		
		assertEquals("Survey 1 Response 1 should be [3,1]",expected3 ,  test.ResponsebySurveyName(surveys, "Survey 2").get(0).getResponses());

		
		
		
		
	}
		
	@Test
	public void SurveyResponseSum()
	{
		//make survey and questions
		Survey s = new Survey();
		Question one = new Question("Customer Service"); 
		one.setAnswer(4);
		Question two = new Question("Food Quality");
		two.setAnswer(5);
		Question three = new Question("Food Quality");
		three.setAnswer(2);
		Question four = new Question("Food Quality");
		four.setAnswer(2);
		//Questions added to survey
		s.add(one);
		s.add(two);
		s.add(three);
		s.add(four);

		//survey response created with questions from survey
		surveyResponse sr = new surveyResponse(s.getQuestions());
		//Test to see that 4+5+2+2 = 13 PASS
		assertEquals("Sum of survet repsonse should be 13" ,13 , test.sumOfResponses(sr));
	}

}
