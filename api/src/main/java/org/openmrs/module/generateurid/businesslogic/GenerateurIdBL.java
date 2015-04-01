/**
 * 
 */
package org.openmrs.module.generateurid.businesslogic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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

	private static List<List<String>> incrementFromNumInCol(String prefix, int num, int incrementNum){

		int col1 = 0, col2 =0, col3 = 0, col4 = 0;
		int mod = (incrementNum > 4)?incrementNum%4:0;
		col1 = ((incrementNum - mod) / 4);
		col2 = col1;
		col3 = col2;
		col4 = col3;
		col1 += (mod > 0)?1:0;
		col2 += (mod > 1)?1:0;
		col3 += (mod > 2)?1:0;
		
		List<List<String>> generatedIds= new ArrayList<List<String>>();
		List<String> col1List = new ArrayList<String>();
		List<String> col2List = new ArrayList<String>();
		List<String> col3List = new ArrayList<String>();
		List<String> col4List = new ArrayList<String>();
		
		for(int i = 0; i < col1; i++){
			num += 1;
			String patientIdentifiant = prefix.concat(getZeroPrefix(getNumOfDigit(num))) + num;
			
			getService().saveGeneratedId(
					new GeneratedId(patientIdentifiant, false,
							new Date(), false, Context.getAuthenticatedUser()));
			col1List.add(patientIdentifiant);
		}
		
		for(int i = 0; i < col2; i++){
			num += 1;
			String patientIdentifiant = prefix.concat(getZeroPrefix(getNumOfDigit(num))) + num;
			
			getService().saveGeneratedId(
					new GeneratedId(patientIdentifiant, false,
							new Date(), false, Context.getAuthenticatedUser()));
			col2List.add(patientIdentifiant);
		}
		
		for(int i = 0; i < col3; i++){
			num += 1;
			String patientIdentifiant = prefix.concat(getZeroPrefix(getNumOfDigit(num))) + num;
			
			getService().saveGeneratedId(
					new GeneratedId(patientIdentifiant, false,
							new Date(), false, Context.getAuthenticatedUser()));
			col3List.add(patientIdentifiant);
		}
		
		for(int i = 0; i < col4; i++){
			num += 1;
			String patientIdentifiant = prefix.concat(getZeroPrefix(getNumOfDigit(num))) + num;
			
			getService().saveGeneratedId(
					new GeneratedId(patientIdentifiant, false,
							new Date(), false, Context.getAuthenticatedUser()));
			col4List.add(patientIdentifiant);
		}
		
		generatedIds.add(col1List);
		generatedIds.add(col2List);
		generatedIds.add(col3List);
		generatedIds.add(col4List);
		
		return generatedIds;
	
	}
	
	private static List<String> incrementFromNum(String prefix, int num, int incrementNum){
		
		List<String> generatedIds= new ArrayList<String>();
		
		for(int i = 0; i < incrementNum; i++){
			num += 1;
			String patientIdentifiant = prefix.concat(getZeroPrefix(getNumOfDigit(num))) + num;
			
			getService().saveGeneratedId(
					new GeneratedId(patientIdentifiant, false,
							new Date(), false, Context.getAuthenticatedUser()));
			generatedIds.add(patientIdentifiant);
		}
		
		return generatedIds;
	
	}

	/**
	 * Generates automatically the IDs
	 * 
	 * @param location
	 *            the location to set the prefix
	 * @param numberToGenerate
	 *            the number of IDs to generate
	 */
	public static List<String> autoGenerateIds(Location location, int numberToGenerate) {

		String locationCode = location.getPostalCode();
		String[] splitCodes = locationCode.split("/");
		List<String> generatedIds= new ArrayList<String>();

		/*
		 * Checking if the location is a Site (SIGDEP):
		 * '4alphanumeric/2alphanumeric'
		 */
		if (splitCodes.length >= 2) {
			String year = getCurrentYear(null) + "";
			String prefix = splitCodes[0] + "/" + splitCodes[1] + "/" + year
					+ "/";

			if (getLatestGeneratedId() == null) {

				generatedIds = incrementFromNum(prefix, 0, numberToGenerate);
			}else{
				
				/** Here comes the code when it already exists */
				String latestId = getLatestGeneratedId().getPatientIdentifiant();
				String[] splitIds = latestId.split("/");
				String locCode = splitIds[0]+"/"+splitIds[1];
				String currYear = splitIds[2];
				Integer latestPatientCode = Integer.parseInt(splitIds[3]);
				
				if(getCurrentYear(null).equals(currYear) && locationCode.equals(locCode)){
					prefix = locCode + "/" + currYear + "/";
					generatedIds = incrementFromNum(prefix, latestPatientCode, numberToGenerate);
				}else{ // We start from 0 for the current year...
					prefix = locCode + "/" + getCurrentYear(null) + "/";
					generatedIds = incrementFromNum(prefix, 0, numberToGenerate);	
				}
			}
		}
		
		return generatedIds;
	}
	
	public static List<List<String>> autoGenerateIdsInCol(Location location, int numberToGenerate) {

		String locationCode = location.getPostalCode();
		String[] splitCodes = locationCode.split("/");
		List<List<String>> generatedIds= new ArrayList<List<String>>();

		/*
		 * Checking if the location is a Site (SIGDEP):
		 * '4alphanumeric/2alphanumeric'
		 */
		if (splitCodes.length >= 2) {
			String year = getCurrentYear(null) + "";
			String prefix = splitCodes[0] + "/" + splitCodes[1] + "/" + year
					+ "/";

			if (getLatestGeneratedId() == null) {

				generatedIds = incrementFromNumInCol(prefix, 0, numberToGenerate);
			}else{
				
				/** Here comes the code when it already exists */
				String latestId = getLatestGeneratedId().getPatientIdentifiant();
				String[] splitIds = latestId.split("/");
				String locCode = splitIds[0]+"/"+splitIds[1];
				String currYear = splitIds[2];
				Integer latestPatientCode = Integer.parseInt(splitIds[3]);
				
				if(getCurrentYear(null).equals(currYear) && locationCode.equals(locCode)){
					prefix = locCode + "/" + currYear + "/";
					generatedIds = incrementFromNumInCol(prefix, latestPatientCode, numberToGenerate);
				}else{ // We start from 0 for the current year...
					prefix = locCode + "/" + getCurrentYear(null) + "/";
					generatedIds = incrementFromNumInCol(prefix, 0, numberToGenerate);	
				}
			}
		}
		
		return generatedIds;
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
	public static String getCurrentYear(String format) {

		Date now = new Date();
		DateFormat date = null;
		date = (format == null)?new SimpleDateFormat("yy"):new SimpleDateFormat(format);
		String year = date.format(now);

		return year;
	}

	public static Collection<GeneratedId> getGeneratedIdsByPeriod(Date startDate, Date endDate){
		
		//TODO: Must do this...
		Collection<GeneratedId> listIds = getService().getAllGeneratedIds();
		
		return listIds;
	}
	
}
