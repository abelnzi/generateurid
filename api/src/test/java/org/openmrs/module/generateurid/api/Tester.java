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
		int number = 00056234;
		int length = (int) Math.log10(number) + 1;
		System.out.println(length);
		
		Date now = new Date();
		DateFormat date = new SimpleDateFormat("yyyy");
		String year = date.format(now);
		System.out.println(year);
		
		/** Testing the digit prefix of ZEROs */
		System.out.println(getZeroPrefix(1));
		
		System.out.println(incrementFromNum(1234, 10));
		
	}
	
	static String getZeroPrefix(int numDigit) {

		String prefix = "";
		
		for (int i = 1; i <= 5-numDigit; i++) {
			prefix += "0";
		}
		return prefix;
	}
	
	static int incrementFromNum(int num, int incrementNum){
		
		for(int i = 0; i < incrementNum; i++){
			num += 1;
			System.out.println(num);// Save in DB
		}
		
		return num;
	}

}
