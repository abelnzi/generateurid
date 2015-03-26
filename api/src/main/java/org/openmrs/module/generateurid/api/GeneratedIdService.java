/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.generateurid.api;

import java.util.Collection;

import org.openmrs.module.generateurid.GeneratedId;
import org.springframework.transaction.annotation.Transactional;

/**
 * This service exposes module's core functionality. It is a Spring managed bean
 * which is configured in moduleApplicationContext.xml.
 * <p>
 * It can be accessed only via Context:<br>
 * <code>
 * Context.getService(GeneratedIdService.class).someMethod();
 * </code>
 * 
 * @see org.openmrs.api.context.Context
 */
@Transactional
public interface GeneratedIdService {

	/**
	 * Saves the GeneratedId to the DB for persistence
	 * 
	 * @param generatedId
	 *            the generatedId to save
	 */
	public void saveGeneratedId(GeneratedId generatedId);

	/**
	 * Deletes (retires) a given GeneratedId
	 * 
	 * @param generatedId
	 *            the object to delete
	 */
	public void deleteGeneratedId(GeneratedId generatedId, String reason);

	/**
	 * Gets a GeneratedId from the DB by matching a given ID
	 * 
	 * @return GeneratedId that matches the conditions
	 */
	public GeneratedId getGeneratedIdById(Integer generatedidId);

	/**
	 * Gets a GeneratedId from the DB by matching a given Identifier
	 * 
	 * @return GeneratedId that matches the conditions
	 */
	public GeneratedId getGeneratedIdByIdentifier(String patientIdentifiant);

	/**
	 * Gets all existing or generated IDs (not retired)
	 * 
	 * @return collection of all GeneratedIds
	 */
	public Collection<GeneratedId> getAllGeneratedIds();

	/**
	 * Updates or Edits a given GeneratedId
	 * 
	 * @param generatedId
	 *            the object to edit
	 */
	public void updateGeneratedId(GeneratedId generatedId);

	/**
	 * Returns the very latest GeneratedId
	 * 
	 * @return latest GeneratedId in DB
	 */
	public GeneratedId getLatestGeneratedId();

}