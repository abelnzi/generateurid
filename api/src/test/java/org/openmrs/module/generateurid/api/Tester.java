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
		
		System.out.println("2334/34/".concat(getZeroPrefix(getNumOfDigit(234))) + 234);
		
		/** Testing the digit prefix of ZEROs */
		System.out.println(getNumOfDigit(234));
		
		System.out.println(getZeroPrefix(3));
		
	}
	
	static String getZeroPrefix(int numDigit) {

		String prefix = "";
		
		for (int i = 1; i <= 5-numDigit; i++) {
			prefix = prefix.concat("0");
//			System.out.println(prefix + " My Prefix");
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
	
	private static int getNumOfDigit(int num) {

		return (int) Math.log10(num) + 1;

	}

	public static String getCurrentYear() {

		Date now = new Date();
		DateFormat date = new SimpleDateFormat("yy");
		String year = date.format(now);

		return year;
	}

}
