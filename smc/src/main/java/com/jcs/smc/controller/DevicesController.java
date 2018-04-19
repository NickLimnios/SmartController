package com.jcs.smc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcs.smc.entity.Devices;
import com.jcs.smc.service.DevicesService;

@Controller
public class DevicesController {

	@Autowired
	private DevicesService devicesSrv;

	@RequestMapping(value = "devices", method = RequestMethod.GET)
	public String devices(Model model) {
		model.addAttribute("content", "devices");
		model.addAttribute("devices", devicesSrv.findAll());
		return "layout";
	}

	@RequestMapping(path = "/addDevice", method = RequestMethod.GET)
	public String createProduct(Model model) {
		model.addAttribute("devices", new Devices());
		return "edit";
	}

	@RequestMapping(path = "devices", method = RequestMethod.POST)
	public String saveProduct(Devices device) {
		devicesSrv.save(device);
		return "redirect:/";
	}
	
    @RequestMapping(path = "/devices/edit/{id}", method = RequestMethod.GET)
    public String editDevice(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("product", devicesSrv.findById(id));
        return "edit";
    }

    @RequestMapping(path = "/products/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable(name = "id") int id) {
    	devicesSrv.delete(id);
        return "redirect:/devices";
    }

}
