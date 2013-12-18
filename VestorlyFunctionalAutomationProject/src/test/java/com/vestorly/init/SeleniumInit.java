package com.vestorly.init;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;
import org.apache.bcel.generic.ILOAD;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlSuite;
import com.vestorly.pages.AbstractPage;
import com.vestorly.pages.index.AdvisorsPage;
import com.vestorly.pages.index.IndexPage;
import com.vestorly.pages.index.LoginPage;


/**
 * Selenium class Initialization
 * 
 * @author Sagar
 */
public class SeleniumInit implements ILoggerStatus {

	/* Minimum requirement for test configuration */
	protected String testUrl; // Test url
	protected String seleniumHub; // Selenium hub IP
	protected String seleniumHubPort; // Selenium hub port
	protected String targetBrowser; // Target browser
	protected static String test_data_folder_path = null;

	// screen-shot folder
	protected static String screenshot_folder_path = null;
	public static String currentTest; // current running test

	protected static Logger logger = Logger.getLogger("testing");
	protected WebDriver driver;
	Common common = new Common(driver);

	/* Page's declaration */
	protected IndexPage indexPage;
	protected AbstractPage abstractpage;
	protected AdvisorsPage AdvisorPage;
	protected LoginPage loginpage;
	
	// And many more ...

	/**
	 * Fetches suite-configuration from XML suite file.
	 * 
	 * @param testContext
	 */
	@BeforeTest(alwaysRun = true)
	public void fetchSuiteConfiguration(ITestContext testContext) {

		testUrl = testContext.getCurrentXmlTest().getParameter("selenium.url");
		seleniumHub = testContext.getCurrentXmlTest().getParameter(
				"selenium.host");
		seleniumHubPort = testContext.getCurrentXmlTest().getParameter(
				"selenium.port");
		targetBrowser = testContext.getCurrentXmlTest().getParameter(
				"selenium.browser");

	}

	/**
	 * WebDriver initialization
	 * 
	 * @return WebDriver object
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method) throws MalformedURLException {

		currentTest = method.getName(); // get Name of current test.

		URL remote_grid = new URL("http://" + seleniumHub + ":"
				+ seleniumHubPort + "/wd/hub");

		String SCREENSHOT_FOLDER_NAME = "screenshots";
		String TESTDATA_FOLDER_NAME = "test_data";

		test_data_folder_path = new File(TESTDATA_FOLDER_NAME)
				.getAbsolutePath();
		screenshot_folder_path = new File(SCREENSHOT_FOLDER_NAME)
				.getAbsolutePath();

		DesiredCapabilities capability = null;
		if (targetBrowser == null || targetBrowser.contains("firefox")) {

			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("dom.max_chrome_script_run_time", "999");
			profile.setPreference("dom.max_script_run_time", "999");
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.useDownloadDir", true);
			profile.setPreference("browser.download.manager.showWhenStarting",
					false);
			profile.setEnableNativeEvents(true);
			profile.setPreference("network.http.use-cache", false);

			capability = DesiredCapabilities.firefox();
			capability.setJavascriptEnabled(true);
			capability.setCapability(FirefoxDriver.PROFILE, profile);
		} else if (targetBrowser.contains("ie8")) {

			capability = DesiredCapabilities.internetExplorer();
			capability.setPlatform(Platform.ANY);
			capability.setBrowserName("internet explorer");
			// capability.setVersion("8.0");
			capability
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			capability.setCapability(
					CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION,
					true);
			capability.setJavascriptEnabled(true);
		} else if (targetBrowser.contains("chrome")) {

			capability = DesiredCapabilities.chrome();
			System.setProperty("webdriver.chrome.driver",
					"C:\\chromedriver.exe");
			// driver = new RemoteWebDriver(new
			// URL("http://localhost:4444/wd/hub"), capability);
			capability.setBrowserName("chrome");
			capability.setJavascriptEnabled(true);
		} else if (targetBrowser.contains("ie9")) {
			capability = DesiredCapabilities.internetExplorer();
			capability.setBrowserName("internet explorer");
			capability
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			capability.setCapability(
					CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION,
					true);
			capability.setJavascriptEnabled(true);
		}

		driver = new RemoteWebDriver(remote_grid, capability);
		driver.get(testUrl);
		driver.manage().window().maximize();
		indexPage = new IndexPage(driver);

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) {
		try {

			String testName = testResult.getName();

			if (!testResult.isSuccess()) {

				/* Print test result to Jenkins Console */
				System.out.println();
				System.out.println("TEST FAILED - " + testName);
				System.out.println();
				System.out.println("ERROR MESSAGE: "
						+ testResult.getThrowable());
				System.out.println("\n");
				Reporter.setCurrentTestResult(testResult);

				/* Make a screenshot for test that failed */
				String screenshotName = common.getCurrentTimeStampString()
						+ testName;
				Reporter.log("<br> <b>Please look to the screenshot - </b>");
				common.makeScreenshot(driver, screenshotName);
			} else {
				System.out.println("TEST PASSED - " + testName + "\n"); // Print
																		// test
																		// result
																		// to
																		// Jenkins
																		// Console
			}

			driver.manage().deleteAllCookies();
			driver.quit();

		} catch (Throwable throwable) {

		}
	}

	/**
	 * Log given message to Reporter output.
	 * 
	 * @param msg
	 *            Message/Log to be reported.
	 */
	public static void logMessage(String msg) {
		Reporter.log("<br>" + msg + "</br>");
	}

	public static void log(String msg, final int logger_status) {

		switch (logger_status) {

		case ILoggerStatus.NORMAL:
			Reporter.log("<br>" + msg + "</br>");
			break;

		case ILoggerStatus.ITALIC:
			log("<i>" + msg + "</i>");
			break;

		case ILoggerStatus.STRONG:
			Reporter.log("<strong>" + msg + "</br>");
			break;
		}
	}

	public static void logStatus(final int test_status) {

		switch (test_status) {

		case ITestStatus.PASSED:
			log("<font color=238E23>--Passed</font>");
			break;

		case ITestStatus.FAILED:
			log("<font color=#FF0000>--Failed</font>");
			break;

		case ITestStatus.SKIPPED:
			log("<font color=#FFFF00>--Skipped</font>");
			break;
			
		default:
			break;
		}

	}

	/**
	 * Log given message to Reporter output.
	 * 
	 * @param msg
	 *            Message/Log to be reported.
	 */
	public static void log(String msg) {
		Reporter.log(msg);
	}

}
