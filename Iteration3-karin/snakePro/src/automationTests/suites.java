package automationTests;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * this function run suits class
 */
	public class suites {
	   public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(AllTests.class);
	      System.out.println("All tests are Passed? ");
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println("answer : " + result.wasSuccessful());
	   }
	}  
	
