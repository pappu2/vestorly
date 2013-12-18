package com.vestorly.pages.index;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.vestorly.init.Common;
import com.vestorly.pages.AbstractPage;

public class IndexPage extends AbstractPage {

	Common common = new Common(driver);

	@FindBy(xpath = "//a[text()='Apply']")
	private WebElement applybutton;
	
	@FindBy(xpath = "//input[@type='submit'][@value='Log in to Your Account']")
	private WebElement loginbutton;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public IndexPage(WebDriver driver) {
		super(driver);

	}

	/**
	 * Click on Apply Button
	 * 
	 * @return
	 * 
	 */
	public AdvisorsPage clickOnApply() {

		common.waitForElement(By.xpath("//a[text()='Apply']"));
		common.log("Click on Apply button.");
		common.jsClick(applybutton);

		return new AdvisorsPage(driver);
	}
	
	public LoginPage loginwithEmail(){
		
		log("Login with valid credentials.");
		common.open("https://vestorly-dev.herokuapp.com/sagar");
		common.type("//input[@id='username']", "pappusagar@gmail.com");
		common.type("//input[@id='password']", "sagar@perfect");
		common.jsClick(loginbutton);
		common.waitForAjax("0");
		
		return new LoginPage(driver);
	}
}
