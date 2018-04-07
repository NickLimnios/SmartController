package com.jcs.smc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcs.smc.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService usersSrv;
	
	@RequestMapping(value="users",method=RequestMethod.GET)
	public String users(Model model)
	{
		model.addAttribute("users",usersSrv.findAll());
		return "users";
	}

}
