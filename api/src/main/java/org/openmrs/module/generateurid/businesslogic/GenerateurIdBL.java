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

		return (int) Math.log10(num) + 1;
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

	
	private static void incrementFromNum(String prefix, int num, int incrementNum){
		
		for(int i = 0; i < incrementNum; i++){
			num += 1;
			String patientIdentifiant = prefix.concat(getZeroPrefix(getNumOfDigit(num))) + num;
			
			getService().saveGeneratedId(
					new GeneratedId(patientIdentifiant, false,
							new Date(), false, Context.getAuthenticatedUser()));
		}
	
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

				incrementFromNum(prefix, 0, numberToGenerate);
			}else{
				/** Here comes the code when it already exists */
				String latestId = getLatestGeneratedId().getPatientIdentifiant();
				String[] splitIds = latestId.split("/");
				String locCode = splitIds[0]+"/"+splitIds[1];
				String currYear = splitIds[2];
				Integer latestPatientCode = Integer.parseInt(splitIds[3]);
				
				if(getCurrentYear().equals(currYear) && locationCode.equals(locCode)){
					prefix = locCode + "/" + currYear + "/";
					incrementFromNum(prefix, latestPatientCode, numberToGenerate);
				}else{ // We start from 0 for the current year...
					prefix = locCode + "/" + getCurrentYear() + "/";
					incrementFromNum(prefix, 0, numberToGenerate);	
				}
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
		DateFormat date = new SimpleDateFormat("yy");
		String year = date.format(now);

		return year;
	}
}
