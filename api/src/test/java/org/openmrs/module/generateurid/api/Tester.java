package org.openmrs.module.generateurid.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tester {

	public static void main(String[] args) {
		/**
		 * Testing how to get the length of int value
		 * 
		 * http://stackoverflow.com/questions/15587818/fastest-way-to-get-number-of-digits-on-a-number
		 */
		int number = 56234;
		int length = (int) Math.log10(number) + 1;
		System.out.println(length);
		
		Date now = new Date();
		DateFormat date = new SimpleDateFormat("yyyy");
		String year = date.format(now);
		System.out.println(year);
	}

}
