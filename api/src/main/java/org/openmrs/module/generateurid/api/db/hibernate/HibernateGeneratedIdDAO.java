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
package org.openmrs.module.generateurid.api.db.hibernate;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.generateurid.GeneratedId;
import org.openmrs.module.generateurid.api.db.GeneratedIdDAO;

/**
 * It is a default implementation of {@link GeneratedIdDAO}.
 */
public class HibernateGeneratedIdDAO implements GeneratedIdDAO {
	protected final Log log = LogFactory.getLog(this.getClass());

	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.openmrs.module.generateurid.api.db.GeneratedIdDAO#saveGeneratedId(org.openmrs.module.generateurid.GeneratedId)
	 */
	@Override
	public void saveGeneratedId(GeneratedId generatedId) {

		getSessionFactory().getCurrentSession().save(generatedId);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.openmrs.module.generateurid.api.db.GeneratedIdDAO#retireGeneratedId(org.openmrs.module.generateurid.GeneratedId,
	 *      java.lang.String)
	 */
	@Override
	public void retireGeneratedId(GeneratedId generatedId, String reason) {

		generatedId.setRetireReason(reason);
		getSessionFactory().getCurrentSession().update(generatedId);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.openmrs.module.generateurid.api.db.GeneratedIdDAO#getGeneratedIdById(java.lang.Integer)
	 */
	@Override
	public GeneratedId getGeneratedIdById(Integer generatedidId) {

		return (GeneratedId) getSessionFactory().getCurrentSession().get(
				GeneratedId.class, generatedidId);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.openmrs.module.generateurid.api.db.GeneratedIdDAO#getGeneratedIdByIdentifier(java.lang.String)
	 */
	@Override
	public GeneratedId getGeneratedIdByIdentifier(String patientIdentifiant) {

		return (GeneratedId) getSessionFactory().getCurrentSession()
				.createCriteria(GeneratedId.class)
				.add(Restrictions.eq("patientIdentifiant", patientIdentifiant))
				.uniqueResult();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.openmrs.module.generateurid.api.db.GeneratedIdDAO#getAllGeneratedIds()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<GeneratedId> getAllGeneratedIds() {
		return (Collection<GeneratedId>) getSessionFactory()
				.getCurrentSession().createCriteria(GeneratedId.class)
				.add(Restrictions.eq("retired", false)).list();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.openmrs.module.generateurid.api.db.GeneratedIdDAO#updateGeneratedId(org.openmrs.module.generateurid.GeneratedId)
	 */
	@Override
	public void updateGeneratedId(GeneratedId generatedId) {

		getSessionFactory().getCurrentSession().update(generatedId);
	}
}