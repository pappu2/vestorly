package com.vestorly.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import com.vestorly.init.Common;
import com.vestorly.init.SeleniumInit;

public abstract class AbstractPage extends SeleniumInit {

	Common common = new Common(driver);

	public int DRIVER_WAIT = 5;

	/**
	 * Initialize UserAbstractPage.
	 * 
	 * @param Driver
	 *            .
	 */
	public AbstractPage(WebDriver driver) {

		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
	}

}
