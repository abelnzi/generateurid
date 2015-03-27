/**
 * 
 */
package org.openmrs.module.generateurid.web.controller;

import org.openmrs.api.context.Context;
import org.openmrs.module.generateurid.businesslogic.GenerateurIdBL;
import org.openmrs.module.generateurid.metier.FormulaireGenerateId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Kamonyo
 *
 */
@Controller
public class PrintOutIdsController {

	@RequestMapping(value = "/module/generateurid/manage")
	public void manage(ModelMap model) {
		
		model.addAttribute("location", Context.getLocationService().getDefaultLocation());
		model.addAttribute("user", Context.getAuthenticatedUser());
		model.addAttribute("locations", Context.getLocationService().getAllLocations());
	}
	
	@RequestMapping(value = "/module/generateurid/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") FormulaireGenerateId formGenerate,
			BindingResult result) {

		return "redirect:/module/generateurid/manage";
	}
	
	@RequestMapping(value = "/module/generateurid/printOutIds")
	public ModelAndView printOutIds(ModelMap model) throws Exception {

		ModelAndView mav = new ModelAndView("allGeneratedIdsInPDF");

		mav.addObject("generatedIds", GenerateurIdBL.getLatestGeneratedId());

		return mav;
	}
	
}
