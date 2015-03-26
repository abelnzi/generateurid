/**
 * 
 */
package org.openmrs.module.generateurid.metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.openmrs.api.context.Context;
import org.openmrs.module.generateurid.api.GeneratedIdService;

/**
 * @author Abel
 *
 */
public class ProviderId {
	String identifiant;

	public ArrayList<String> provideIdList(int locationId, int nbreId,
			int lastGeneratedId) {
		GeneratedIdService service=Context.getService(GeneratedIdService.class);
		// recupérer la date courante
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		int annee = calendar.get(Calendar.YEAR);
		// la dernière valeur de la sequence
		lastGeneratedId += lastGeneratedId;
		ArrayList<String> listLocationId = new ArrayList<String>();

		StringBuffer buf = new StringBuffer();
		for (int i = 1; i <= nbreId; i++) {
			buf.append(locationId);
			buf.append("/" + annee);
			buf.append("/" + lastGeneratedId);
			listLocationId.add(toString());
			lastGeneratedId += lastGeneratedId;
		}

		return listLocationId;
	}

}
