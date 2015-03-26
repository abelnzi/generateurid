/**
 * 
 */
package org.openmrs.module.generateurid.businesslogic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openmrs.Location;
import org.openmrs.api.context.Context;
import org.openmrs.module.generateurid.GeneratedId;
import org.openmrs.module.generateurid.api.GeneratedIdService;

/**
 * @author Kamonyo
 *
 */
public class GenerateurIdBL {

	/**
	 * Offers the module service to use
	 * 
	 * @return GeneratedIdService interface...
	 */
	private static GeneratedIdService getService() {
		return Context.getService(GeneratedIdService.class);
	}

	/**
	 * Gets the number of digit composing a given int
	 * 
	 * @param num
	 *            the given number
	 * @return number of digits
	 */
	private static int getNumOfDigit(int num) {

		int length = (int) Math.log10(num) + 1;
		System.out.println(length);

		return num;
	}
	
	/**
	 * @param numDigit
	 * @return
	 */
	private static String getZeroPrefix(int numDigit) {

		String prefix = "";
		
		for (int i = 1; i <= 5-numDigit; i++) {
			prefix += "0";
		}
		return prefix;
	}

	/**
	 * Generates automatically the IDs
	 * 
	 * @param location
	 *            the location to set the prefix
	 * @param numberToGenerate
	 *            the number of IDs to generate
	 */
	public static void autoGenerateIds(Location location, int numberToGenerate) {

		String locationCode = location.getPostalCode();
		String[] splitCodes = locationCode.split("/");

		/*
		 * Checking if the location is a Site (SIGDEP):
		 * '4alphanumeric/2alphanumeric'
		 */
		if (splitCodes.length >= 2) {
			String year = getCurrentYear() + "";
			String prefix = splitCodes[0] + "/" + splitCodes[1] + "/" + year
					+ "/";

			if (getLatestGeneratedId() == null) {

				for (int i = 1; i >= numberToGenerate; i++) {
					if (getNumOfDigit(i) == 1) {
						String patientIdentifiant = prefix + getZeroPrefix(getNumOfDigit(i)) + i;
						getService().saveGeneratedId(
								new GeneratedId(patientIdentifiant, false,
										new Date(), false, Context.getAuthenticatedUser()));
					}
				}
			}else{
				/** Here comes the code for when it exists */
			}
		}
	}

	/**
	 * Gets the Latest Generated ID of our DB
	 * 
	 * @return generatedId
	 */
	public static GeneratedId getLatestGeneratedId() {
		return getService().getLatestGeneratedId();
	}

	/**
	 * Gets the current YEAR as a String from the Calendar (System Date)
	 * 
	 * @return
	 */
	public static String getCurrentYear() {

		Date now = new Date();
		DateFormat date = new SimpleDateFormat("yyyy");
		String year = date.format(now);

		return year;
	}
}
