/**
 * 
 */
package org.openmrs.module.generateurid.web.controller;

import org.openmrs.api.context.Context;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
