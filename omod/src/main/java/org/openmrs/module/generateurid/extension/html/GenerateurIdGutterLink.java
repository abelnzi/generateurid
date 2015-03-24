/**
 * 
 */
package org.openmrs.module.generateurid.extension.html;

import org.openmrs.module.web.extension.LinkExt;

/**
 * @author Abel
 *
 */
public class GenerateurIdGutterLink extends LinkExt {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openmrs.module.web.extension.LinkExt#getLabel()
	 */
	@Override
	public String getLabel() {

		return "generateurid.generate.gutterlink";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openmrs.module.web.extension.LinkExt#getRequiredPrivilege()
	 */
	@Override
	public String getRequiredPrivilege() {

		return "Manage Generateur ID";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openmrs.module.web.extension.LinkExt#getUrl()
	 */
	@Override
	public String getUrl() {
		return "module/generateurid/manage.form";
	}

}
