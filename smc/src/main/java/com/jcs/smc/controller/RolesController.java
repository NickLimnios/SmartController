package com.jcs.smc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcs.smc.service.RolesService;

@Controller
public class RolesController {
	
	@Autowired
	private RolesService rolesSrv;
	
	@RequestMapping(value="roles",method=RequestMethod.GET)
	public String roles(Model model)
	{
		model.addAttribute("content","roles");
		model.addAttribute("roles",rolesSrv.findAll());
		return "layout";
	}

}
