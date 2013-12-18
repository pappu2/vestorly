package com.vestorly.pages.index;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.vestorly.init.Common;
import com.vestorly.pages.AbstractPage;

public class AdvisorsPage extends AbstractPage {

	Common common = new Common(driver);

	@FindBy(xpath = "//input[@name='commit'][@type='submit'][@value='Apply Now']")
	private WebElement applybutton;

	@FindBy(xpath = "//input[@class='largeerror']")
	private WebElement advisornamefielderror;

	/**
	 * Constructor
	 * 
	 * @param Advisor
	 * driver
	 */
	public AdvisorsPage(WebDriver driver) {
		super(driver);

	}

	/**
	 * Verify Advisor Apply Feature
	 * 
	 */
	public void verifyAdvisorApplyFeature() {

		common.log("Verify Advisor Feature");
		
		common.waitForElement(By
				.xpath("//input[@name='commit'][@type='submit'][@value='Apply Now']"));
		common.jsClick(applybutton);
		common.waitForAjax("0");
		common.assertElementPresent("//input[@placeholder='Your Name'][@class='largeerror']");
		common.assertElementPresent("//input[@placeholder='Your Email Address'][@class='largeerror']");
		common.assertElementPresent("//input[@class='littleerror'][@placeholder='Phone Number']");
		common.assertElementPresent("//input[@class='littleerror'][@id='advisor_company']");

	}
}
