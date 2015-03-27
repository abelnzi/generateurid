/**
 * 
 */
package org.openmrs.module.generateurid.metier;

import org.openmrs.Location;

/**
 * @author Abel
 *
 */
public class FormulaireGenerateId {
	private int idLocation;
	private Location location;

	public int getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
