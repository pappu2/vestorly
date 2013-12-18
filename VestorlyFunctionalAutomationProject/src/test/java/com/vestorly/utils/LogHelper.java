package com.vestorly.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * Return logAsString
 */
public class LogHelper {
	
	private final static String EXTENSION = ".log";
	private final static String PATH_TO_FAILSAFE = "target" + File.separator + "failsafe-reports" + File.separator;
	private final static String PATH_TO_LOG_FOLDER = PATH_TO_FAILSAFE + "logs" + File.separator;
	 	 
	public static String getLogFromFile(String filename){
		String logfile, logAsString = null;
		int index = 1;
		
		logfile = PATH_TO_LOG_FOLDER + filename + EXTENSION; //get log file to read
		
		File file = new File(logfile).getAbsoluteFile();
		try {
			FileReader fileReader; fileReader = new FileReader(file);
		
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
		
			while ((line = bufferedReader.readLine()) != null) {
				if(line.contains("The following ERROR occurred")){
					stringBuffer.append("-->" + line);
				}
				else{
					stringBuffer.append(Integer.toString(index) + "." + line);
					index++;
				}
				stringBuffer.append("<br>");
				//stringBuffer.append("\n");
			}
			fileReader.close();
			logAsString = stringBuffer.toString();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return logAsString;
	}

}
