package com.vestorly.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
/**
 * Define Custom Listener
 * 
 *
 */
public class CustomListener implements ITestListener{
		
	public static final String TEST_NAME = "seleniumTest";
	protected static Logger logger = LoggerFactory.getLogger("customListener");
	public static int passedTestsCount=0;
	public static int failedTestsCount=0;
	public static int skippedTestsCount=0;
	
	public static void startTestLogging(String name){
		
		//log.debug("LOGGING IS WORKING");
	}
	
	public static void stopTestLogging(){
		//MDC.get(TEST_NAME);
		
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult testResult) {
		
		logger.debug(getFormattedError(testResult)); //Write exception to console 
		Reporter.setCurrentTestResult(testResult);
		
		String testName = testResult.getName();
		Reporter.log(LogHelper.getLogFromFile(testName)); //Sends all logs to TestNG report.

		MDC.remove(TEST_NAME);
	}

	public void onTestSkipped(ITestResult arg0) {
		MDC.remove(TEST_NAME);		
	}

	public void onTestStart(ITestResult result) {
		MDC.put(TEST_NAME, result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult arg0) {
		MDC.remove(TEST_NAME);
	}
	
	/**
	 * Gets Formatted Error Test Result
	 * 
	 * @param testResult
	 * @return
	 */
	public String getFormattedError(ITestResult testResult){
		
		String exception = null, stackTraceAsString;
		
		// Convert Stack Trace to String  
		StringWriter sw = new StringWriter();
		testResult.getThrowable().printStackTrace(new PrintWriter(sw));
		stackTraceAsString = sw.toString();
		
		if(stackTraceAsString.contains("org.openqa.selenium.NoSuchElementException")){	
			Pattern p = Pattern.compile("\\sUnable to locate element:\\s\\{\\S*\\}");
			Matcher m = p.matcher(stackTraceAsString);
			if (m.find())
			{
				exception = m.group(0);
			}
		}
		else if(stackTraceAsString.contains("java.lang.AssertionError")){
			exception = testResult.getThrowable().toString().replaceAll("[<>]", "'");		
		}	
		
		return "The following ERROR occurred: " + exception;
	
	}
	
	
}
