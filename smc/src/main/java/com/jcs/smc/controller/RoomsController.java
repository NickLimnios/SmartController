package com.jcs.smc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcs.smc.service.RoomsService;

@Controller
public class RoomsController {

	@Autowired
	private RoomsService roomsSrv;
	
	@RequestMapping(value = "/rooms", method = RequestMethod.GET)
	public String rooms(Model model) {
		model.addAttribute("rooms", roomsSrv.findAll());
		return "rooms";
	}
	
}
