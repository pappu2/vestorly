package com.vestorly.verifications;

import org.testng.annotations.Test;
import com.vestorly.init.Common;
import com.vestorly.init.SeleniumInit;

public class Index extends SeleniumInit {

	Common common = new Common(driver);

	/**
	 * Verify Advisor Apply Feature
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void advisorApply() throws InterruptedException {
		log("Feature" + "-" + "UAT"
				+ "\"Advisor Apply,TestCase Name: 1.1 Advisor Apply Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");
		AdvisorPage = indexPage.clickOnApply();
		AdvisorPage.verifyAdvisorApplyFeature();

	}


	/**
	 * Verify Login features with valid credentials
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void signUpViaEmail() throws InterruptedException {
		log("Feature" + "-" + "UAT"
				+ "\"Advisor Signup,TestCase Name: 1.2 Advisor Signup Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");
		loginpage = indexPage.loginwithEmail();
		loginpage.verifyLogoutFeature();
		
	}
	
	
	
	
	
	@Test
	public void advisorSignup() throws InterruptedException {
		log("Feature" + "-" + "UAT"
				+ "\"Advisor Signup,TestCase Name: 1.2 Advisor Signup Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");
		
	}
	
	
	
}
