package automationTests;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses( {ManageQuestionsTests.class, SignupLoginTests.class } )
	public class AllTests {
		;
	}
