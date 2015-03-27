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
package org.openmrs.module.generateurid;

import java.io.Serializable;
import java.util.Date;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.BaseOpenmrsMetadata;
import org.openmrs.User;

/**
 * It is a model class. It should extend either {@link BaseOpenmrsObject} or
 * {@link BaseOpenmrsMetadata}.
 */
public class GeneratedId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer generatedidId;
	private String patientIdentifiant;
	private Boolean attributed;
	private Date dateCreated;
	private Date dateChanged;
	private Date dateRetired;
	private Boolean retired;
	private String retireReason;
	private User creator;
	private User retiredBy;
	private User changedBy;

	public GeneratedId(){};
	
	/* Constructor to instantiate this object */
	public GeneratedId(String patientIdentifiant, Boolean attributed,
			Date dateCreated, Boolean retired, User creator) {
		super();
		this.patientIdentifiant = patientIdentifiant;
		this.attributed = attributed;
		this.dateCreated = dateCreated;
		this.retired = retired;
		this.creator = creator;
	}

	public Integer getGeneratedidId() {
		return generatedidId;
	}

	public void setGeneratedidId(Integer generatedidId) {
		this.generatedidId = generatedidId;
	}

	public String getPatientIdentifiant() {
		return patientIdentifiant;
	}

	public void setPatientIdentifiant(String patientIdentifiant) {
		this.patientIdentifiant = patientIdentifiant;
	}

	public Boolean getAttributed() {
		return attributed;
	}

	public void setAttributed(Boolean attributed) {
		this.attributed = attributed;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateChanged() {
		return dateChanged;
	}

	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}

	public Date getDateRetired() {
		return dateRetired;
	}

	public void setDateRetired(Date dateRetired) {
		this.dateRetired = dateRetired;
	}

	public Boolean getRetired() {
		return retired;
	}

	public void setRetired(Boolean retired) {
		this.retired = retired;
	}

	public String getRetireReason() {
		return retireReason;
	}

	public void setRetireReason(String retireReason) {
		this.retireReason = retireReason;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public User getRetiredBy() {
		return retiredBy;
	}

	public void setRetiredBy(User retiredBy) {
		this.retiredBy = retiredBy;
	}

	public User getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(User changedBy) {
		this.changedBy = changedBy;
	}

}