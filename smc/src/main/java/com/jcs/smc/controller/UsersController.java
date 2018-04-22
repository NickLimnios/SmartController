package com.jcs.smc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jcs.smc.entity.Users;
import com.jcs.smc.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService usersSrv;
	
	@RequestMapping(value="users",method=RequestMethod.GET)
	public String users(Model model)
	{
		model.addAttribute("content","users");
		model.addAttribute("users",usersSrv.findAll());
		return "layout";
	}

	@RequestMapping("/users/new")
	public String create(Model model)
	{
		Users user = new Users();
		model.addAttribute("content", "singleUsers");
		model.addAttribute("singleUsers", user);
		return "layout";
	}

	@RequestMapping("/users/{id}")
	public String view(@PathVariable("id") int id, Model model)
	{
		model.addAttribute("content", "singleUsers");
		model.addAttribute("singleUsers", usersSrv.findById(id));
		return "layout";
	}

	@RequestMapping(value = "/deleteUsers", method = RequestMethod.GET)
	public String handleDelete(@RequestParam(name="id")int id) {
	    usersSrv.delete(id);
	    return "redirect:/users";
	}
	
	@RequestMapping(value="/submitUsers", method = RequestMethod.POST)
    public String submit(Users singleUsers) {
		usersSrv.save(singleUsers);
	        return "redirect:/users";
	 }

}
