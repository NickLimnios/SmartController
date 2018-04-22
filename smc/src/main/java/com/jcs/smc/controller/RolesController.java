package com.jcs.smc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jcs.smc.entity.Roles;
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

	@RequestMapping("/roles/new")
	public String create(Model model)
	{
		Roles role = new Roles();
		model.addAttribute("content", "singleRoles");
		model.addAttribute("singleRoles", role);
		return "layout";
	}

	@RequestMapping("/roles/{id}")
	public String view(@PathVariable("id") int id, Model model)
	{
		model.addAttribute("content", "singleRoles");
		model.addAttribute("singleRoles", rolesSrv.findById(id));
		return "layout";
	}

	@RequestMapping(value = "/deleteRole", method = RequestMethod.GET)
	public String handleDelete(@RequestParam(name="id")int id) {
	    rolesSrv.delete(id);
	    return "redirect:/roles";
	}
	
	@RequestMapping(value="/submitRoles", method = RequestMethod.POST)
    public String submit(Roles singleRoles) {
		rolesSrv.save(singleRoles);
	        return "redirect:/roles";
	 }

}
