package com.vestorly.pages.index;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.vestorly.init.Common;
import com.vestorly.pages.AbstractPage;

public class LoginPage extends AbstractPage {

	Common common = new Common(driver);

	@FindBy(xpath = "//a[@id='username']")
	private WebElement yoursettings;

	@FindBy(xpath = "//a[@class='logout_button']")
	private WebElement logout;

	/**
	 * Constructor
	 * 
	 * @param Advisor
	 *            driver
	 */
	public LoginPage(WebDriver driver) {
		super(driver);

	}

	/**
	 * Verify Advisor Apply Feature
	 * 
	 */
	public void verifyLogoutFeature() {

		common.log("Verify Logout Feature");

		common.waitForAjax("0");
		common.jsClick(yoursettings);
		common.assertElementPresent("//a[@class='logout_button']");
		common.pause(6);
		common.jsClick(logout);

	}
}
