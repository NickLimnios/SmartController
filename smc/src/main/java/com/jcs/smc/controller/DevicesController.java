package com.jcs.smc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcs.smc.service.DevicesService;

@Controller
public class DevicesController {
	
	@Autowired
	private DevicesService devicesSrv;
	
	@RequestMapping(value="devices",method=RequestMethod.GET)
	public String devices(Model model)
	{
		model.addAttribute("content","devices");
		model.addAttribute("devices",devicesSrv.findAll());
		return "layout";
	}

}
