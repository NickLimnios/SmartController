package com.jcs.smc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jcs.smc.service.RoomsService;

@Controller
public class RoomsController {

	@Autowired
	private RoomsService roomsSrv;
	
	@RequestMapping(value = "rooms", method = RequestMethod.GET)
	public String rooms(Model model) {
		model.addAttribute("content","rooms");
		model.addAttribute("tables", roomsSrv.findAll());
		return "layout";
	}
	
	@RequestMapping("/rooms/{id}")
	public String view(@PathVariable("id") int id, Model model)
	{
		model.addAttribute("content","single");
		model.addAttribute("single",roomsSrv.findById(id));
		return "layout";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String handleDelete(@RequestParam(name="id")int id) {
	    roomsSrv.delete(id);
	    return "redirect:/rooms";
	}
	
}
