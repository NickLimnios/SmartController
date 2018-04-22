package com.jcs.smc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jcs.smc.entity.Devices;
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

	@RequestMapping("/devices/new")
	public String create(Model model)
	{
		Devices device = new Devices();
		model.addAttribute("content", "singleDevices");
		model.addAttribute("singleDevices", device);
		return "layout";
	}

	@RequestMapping("/devices/{id}")
	public String view(@PathVariable("id") int id, Model model)
	{
		model.addAttribute("content", "singleDevices");
		model.addAttribute("singleDevices", devicesSrv.findById(id));
		return "layout";
	}

	@RequestMapping(value = "/deleteDevices", method = RequestMethod.GET)
	public String handleDelete(@RequestParam(name="id")int id) {
	    devicesSrv.delete(id);
	    return "redirect:/devices";
	}
	
	@RequestMapping(value="/submitDevices", method = RequestMethod.POST)
    public String submit(Devices singleDevices) {
		devicesSrv.save(singleDevices);
	        return "redirect:/devices";
	 }

}
