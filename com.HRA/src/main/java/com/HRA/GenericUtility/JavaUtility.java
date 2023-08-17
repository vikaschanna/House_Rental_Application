package com.HRA.GenericUtility;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class is used to fetch the data from System
 * @author Vikas S
 *
 */
public class JavaUtility {
	
	/**
	 * This method is used to genarate the random number
	 * @author Vikas S
	 * @return
	 */
	public int generateRandomNo() {
		Random ran = new Random();
		int randomNo = ran.nextInt(500)+100;
		return randomNo;
	}
	
	/**
	 * This method is used to get the date from system 
	 * @author Vikas S
	 * @return
	 */
	public String getSystemDate () {
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	
	/**
	 * This method is used to get the date from System in format
	 * @author Vikas S
	 * @return
	 */
	public String getSystemDateInFormat() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy HH-MM-SS");
		Date d =new Date();
		String systemDateInFormat = dateFormat.format(d);
		return systemDateInFormat;
	}
}
