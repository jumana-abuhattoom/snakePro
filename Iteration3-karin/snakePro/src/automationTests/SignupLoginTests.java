package automationTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.sysdata;

class SignupLoginTests {

	@Test
	void SignUp_duplicate_username() {
		boolean b = sysdata.getInstance().AddPlayer("Jumana", "JJ"); 
		boolean a = sysdata.getInstance().AddPlayer("Jumana", "DD");
		
		assertEquals(true, b);
		assertEquals(false, a);
	}
	
	@Test
	void Signin_wrongPassword() { 
		sysdata.getInstance().AddPlayer("Jumana", "juju"); 
		boolean b = sysdata.getInstance().CheckUsernameAndPassword("Jumana", "haha");
		
		assertEquals(false, b);
	}
	
	@Test
	void Signin_correctly() { 
		boolean a = sysdata.getInstance().AddPlayer("Jumana1", "juju"); 
		boolean b = sysdata.getInstance().CheckUsernameAndPassword("Jumana1", "juju");
		
		assertEquals(true, b);
		
	}
	
	@Test
	void SigninAsAdmin() { 
		boolean b = sysdata.getInstance().CheckUsernameAndPassword("Admin", "Admin");
		boolean a = sysdata.getInstance().CheckUsernameAndPassword("Admin", "admin11");
		
		assertEquals(false, b);
		assertEquals(true, a);
	}
	
	@Test
	void Signup_as_admin() { 
		boolean b = sysdata.getInstance().AddPlayer("Admin", "aaa");
		boolean a = sysdata.getInstance().AddPlayer("admin", "aaa");
		
		assertEquals(false, b);
		assertEquals(false, a);
	}
	
	@Test 
	void Update_user_correctly() { 
		boolean b = sysdata.getInstance().AddPlayer("Aaa", "Bbb"); 
		boolean a = sysdata.getInstance().UpdatePlayerDetails("Aaa", "Bbb","Bbb", "Aaa"); 
		boolean c = sysdata.getInstance().CheckUsernameAndPassword("Bbb", "Aaa"); 
		
		assertEquals(true, b ," player added");
		assertEquals(true, a, "updated");
		assertEquals(c, a, "updated successfully");
	}
	@Test 
	void Update_user_failed() { 
		boolean b = sysdata.getInstance().AddPlayer("Aaa1", "Bbb1"); 
		boolean a = sysdata.getInstance().UpdatePlayerDetails("Aaa1", "Bbb1","Admin", "Aaa"); 
		boolean c = sysdata.getInstance().CheckUsernameAndPassword("Admin", "Aaa"); 
		
		assertEquals(true, b ," player added");
		assertEquals(false, a, "not updated");
		assertEquals(c, a, "update failed");
	}
	
	@Test 
	
	
	
	

	
	
	
	//-----------------------
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

		@AfterEach
		void tearDown() throws Exception {
	}

	

}
