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

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Location;
import org.openmrs.api.context.Context;
import org.openmrs.module.generateurid.businesslogic.GenerateurIdBL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * The main controller.
 */
@Controller
@RequestMapping(value = "/module/generateurid/generateIds.form")
public class GenerateuridManageController {

	protected final Log log = LogFactory.getLog(getClass());

	@RequestMapping(method=RequestMethod.GET)
	public void viewGenerateId(ModelMap model) {
		
		Integer locId = Integer.parseInt(Context.getAdministrationService().getGlobalProperty("generateurid.defaultLocation"));
		model.addAttribute("location", Context.getLocationService().getLocation(locId));
		model.addAttribute("currentYear", GenerateurIdBL.getCurrentYear("yyyy"));
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void generateId(
            @RequestParam(required=true, value="numToGenerate") Integer numToGenerate,
            HttpSession session, ModelMap model) {
		
		Integer locId = Integer.parseInt(Context.getAdministrationService().getGlobalProperty("generateurid.defaultLocation"));
		Location location = Context.getLocationService().getLocation(locId);
		
		model.addAttribute("listIds", GenerateurIdBL.autoGenerateIds(location, numToGenerate));
		model.addAttribute("location", Context.getLocationService().getLocation(locId));
		model.addAttribute("currentYear", GenerateurIdBL.getCurrentYear("yyyy"));
		model.addAttribute("currentDate", new Date());
		
	}
	
	public ModelAndView printOutIds(
            @RequestParam(required=true, value="printIds") String printIds,
            HttpSession session, ModelMap model) throws Exception {

		ModelAndView mav = new ModelAndView("allGeneratedIdsInPDF");
		
		if(printIds != null)
			mav.addObject("generatedIds", GenerateurIdBL.getLatestGeneratedId());

		return mav;
	}
	
}
