package automationTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import controller.sysdata;

class ManageQuestionsTests {

	@Test
	void Illigal_Question_Number() {
		ArrayList<String> answers = new ArrayList<String>(); 
		answers.add("abc"); answers.add("mns"); answers.add("kdl"); answers.add("jdj");
		boolean a = sysdata.getInstance().AddQuestion("W2",answers, 2, 2);
		
		assertEquals(false, a);
	}
	
	@Test
	void Duplicate_Answers() {
		ArrayList<String> answers = new ArrayList<String>(); 
		answers.add("abc"); answers.add("abc"); answers.add("kdl"); answers.add("jdj");
		boolean a = sysdata.getInstance().AddQuestion("Q2",answers, 2, 2);
		
		assertEquals(false, a);
	}
	
	@Test
	void Empty_Answers() {
		ArrayList<String> answers = new ArrayList<String>(); 
		answers.add(""); answers.add("abc"); answers.add("kdl"); answers.add("jdj");
		boolean a = sysdata.getInstance().AddQuestion("Q2",answers, 2, 2);
		
		assertEquals(false, a);
	}

	
	@Test
	void Illigal_correct_Answer_Index() { // 1,2,3,4
		ArrayList<String> answers = new ArrayList<String>(); 
		answers.add("rrr"); answers.add("abc"); answers.add("kdl"); answers.add("jdj");
		boolean a = sysdata.getInstance().AddQuestion("Q5",answers, 5, 1);
		
		assertEquals(false, a);
	}
	
	@Test
	void Illigal_Level_integer() { // 1,2,3
		ArrayList<String> answers = new ArrayList<String>(); 
		answers.add("rrr"); answers.add("abc"); answers.add("kdl"); answers.add("jdj");
		boolean a = sysdata.getInstance().AddQuestion("Q5",answers,3, 4);
		
		assertEquals(false, a);
	}
	
	@Test
	void Correctly_added_Questions() { 
		ArrayList<String> answers = new ArrayList<String>(); 
		answers.add("rrr"); answers.add("abc"); answers.add("kdl"); answers.add("jdj");
		boolean a = sysdata.getInstance().AddQuestion("Q5",answers,2, 3);
		
		assertEquals(true, a);
	}
	@Test
	void Duplicate_Questions() { 
		ArrayList<String> answers = new ArrayList<String>(); 
		answers.add("rrr"); answers.add("abc"); answers.add("kdl"); answers.add("jdj");
		boolean a = sysdata.getInstance().AddQuestion("Q5",answers,2, 3);
		
		assertEquals(false, a);
	}
	
	
	
}
