package com.vestorly.utils;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.internal.TestNGMethod;
import org.testng.xml.XmlSuite;

public class CustomListnerTestNG  implements IReporter{

	static Map<String, List<String>> failedTestsMap = new HashMap<String, List<String>>();

	static Map<String, List<String>> skippedTestsMap = new HashMap<String, List<String>>();
	
	static Map<String, List<String>> passedTestsMap = new HashMap<String, List<String>>();
	
	static int passedNb = 0 ;
	static int failedNb = 0 ;
	static int skippedNb =0 ;
	
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) {
			
		String xml_init_suite = null;
		
		for(XmlSuite xs:xmlSuites){
			xml_init_suite = xs.getName(); // Top Most Suite file name.
		}
		
		for(ISuite suite:suites){ // Iterate through every suite.
			
			// if(suite.getName().equals(xml_init_suite)) continue; // Dont' do anything if current suite is [TOp Most Parent Suite]
			
			Map<String,ISuiteResult> suiteResultsMap = suite.getResults(); // Get Map of results.
			
			calculateTestMeasures(suiteResultsMap); // Calculate test measures.
				
			int total = passedNb + failedNb + skippedNb; // Total tests.
			System.out.println("T:" + total + " P:" + passedNb + " F:" + failedNb + " S:" + skippedNb );
			
		}
		
		try {
			printTestsInfo(); // Generate text report and HTML report.
		} catch (IOException e) {
			String msg = "Problem with writing information about tests to files "
					+ e;
			System.out.println(msg);
		}
		
	}

	/**
	 * Calculates test measures.
	 * 
	 * Passed Test Count, Failed Test Count, Skipped Test Count.
	 * 
	 * @param suiteResultsMap
	 */
	private void calculateTestMeasures(Map<String,ISuiteResult> suiteResultsMap){
		
		String testClassName = null ;
		Set<ITestResult> testResults = null ;
		Collection<ISuiteResult> suiteResults;
		
		suiteResults = suiteResultsMap.values();
		for(ISuiteResult sr:suiteResults){ // Iterate all suite results.
					
			testResults = sr.getTestContext().getFailedTests().getAllResults(); // Get all failed tests.
			failedNb = failedNb + testResults.size();
			for(ITestResult res:testResults){  // Iterate through each failed test.
				testClassName = res.getTestClass().getName();
				System.out.println("TestClass:" + testClassName );
				if (!failedTestsMap.containsKey(testClassName)) {
					System.out.println("===>>>Inside with " + testClassName );
					failedTestsMap.put(testClassName, new ArrayList<String>());
				}
				failedTestsMap.get(testClassName).add(res.getName());
			}
			
			
			testResults = sr.getTestContext().getPassedTests().getAllResults(); // Get all passed tests.
			passedNb = passedNb + testResults.size();
			for(ITestResult res:testResults){ // Iterate through each passed test.
				testClassName = res.getTestClass().getName();
				if (!passedTestsMap.containsKey(testClassName)) {
					passedTestsMap.put(testClassName, new ArrayList<String>());
				}
				passedTestsMap.get(testClassName).add(res.getName());
			}
			
			
			testResults = sr.getTestContext().getSkippedTests().getAllResults(); // Get all skipped tests.
			skippedNb = skippedNb + testResults.size();
			for(ITestResult res:testResults){ // Iterate through each skipped test.
				testClassName = res.getTestClass().getName();
				if (!skippedTestsMap.containsKey(testClassName)) {
					skippedTestsMap.put(testClassName, new ArrayList<String>());
				}
				skippedTestsMap.get(testClassName).add(res.getName());
			}
			
		}
		
	}
	
	/**
	 * Generate test reports
	 * 
	 * Text and HTML.
	 * 
	 * @throws IOException
	 */
	private void printTestsInfo() throws IOException {
		
		Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
 
        String todayDate = null ;
        
        try {
            
           todayDate =  dateFormat.format(calendar.getTime());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		VelocityContext context = new VelocityContext();
		int total = passedNb + skippedNb + failedNb ;
		context.put("totalNb", total);
		context.put("passedNb", passedNb);
		context.put("failedNb", failedNb);
		context.put("skippedNb", skippedNb);
		context.put("failedTests", failedTestsMap);
		context.put("skippedTests", skippedTestsMap);
		context.put("passedTests", passedTestsMap);
		context.put("passedRate", (passedNb/((float)total)*100));
		context.put("todayDate", todayDate);
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty("file.resource.loader.class",
				ClasspathResourceLoader.class.getName());

		try {
			ve.init();
			writeFile(ve, context, "templates/summary_txt.vm",
					"test_summary.txt");
			writeFile(ve, context, "templates/summary_html.vm",
					"test_summary.html");
		} catch (Exception e) {
			// do something more interesting here
			e.printStackTrace();
		}
	}
	
	/**
	 * Generates output files.
	 * 
	 * @param ve
	 * @param context
	 * @param vmPath
	 * @param fileName
	 * @throws ResourceNotFoundException
	 * @throws ParseErrorException
	 * @throws Exception
	 */
	private void writeFile(VelocityEngine ve, VelocityContext context,
			String vmPath, String fileName) throws ResourceNotFoundException,
			ParseErrorException, Exception {
		Template t = ve.getTemplate(vmPath);
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		FileWriter fileWriter = new FileWriter(fileName, true);
		fileWriter.append(writer.toString());
		fileWriter.flush();
		fileWriter.close();
	}
	
			  
}
