package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.sysdata;

class logingTests {

	@Test
	void SignUp_duplicate_user() {
		boolean b = sysdata.getInstance().AddPlayer("Jumana", "JJ"); 
		boolean a = sysdata.getInstance().AddPlayer("Jumana", "DD");
		assertEquals(true, b);
		assertEquals(false, a);
	}
	
	

}
