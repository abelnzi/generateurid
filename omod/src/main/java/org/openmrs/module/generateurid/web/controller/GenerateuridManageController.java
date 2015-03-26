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
package org.openmrs.module.generateurid.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Location;
import org.openmrs.api.context.Context;
import org.openmrs.module.generateurid.businesslogic.GenerateurIdBL;
import org.openmrs.module.generateurid.metier.FormulaireGenerateId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The main controller.
 */
@Controller
public class GenerateuridManageController {

	protected final Log log = LogFactory.getLog(getClass());

	FormulaireGenerateId formlocation = new FormulaireGenerateId();

	@RequestMapping(value = "/module/generateurid/manage")
	public void manage(ModelMap model) {

		model.addAttribute("location", Context.getLocationService()
				.getDefaultLocation());
		model.addAttribute("user", Context.getAuthenticatedUser());

		model.addAttribute("locationparam", formlocation);
		model.addAttribute("locations", Context.getLocationService()
				.getAllLocations());
	}

	// @RequestMapping(value = "/module/generateurid/add", method =
	// RequestMethod.POST)
	// public String addContact(@ModelAttribute("contact") FormulaireGenerateId
	// formGenerate,
	// BindingResult result) {
	//
	// return "redirect:/module/generateurid/manage";
	// }

	@RequestMapping(value = "/module/generateurid/generateId")
	public void viewGenerateId(ModelMap model) {

		Integer locId = 1; // Integer.parseInt(Context.getAdministrationService().getGlobalProperty("generateurid.defaultLocation"));
		model.addAttribute("location", Context.getLocationService()
				.getLocation(locId));
		model.addAttribute("currentYear", GenerateurIdBL.getCurrentYear());

	}

	@RequestMapping(value = "/module/generateurid/generateIdForm")
	public String generateId(
			@RequestParam(required = false, value = "locationId") Integer locationId,
			@RequestParam(required = false, value = "currentYear") String currentYear,
			@RequestParam(required = true, value = "numToGenerate") Integer numToGenerate,
			HttpSession session) {

		Integer locId = 1;
		Location location = Context.getLocationService().getLocation(locId);

		GenerateurIdBL.autoGenerateIds(location, numToGenerate);

		return "/module/generateurid/generateIdForm";
	}
}
