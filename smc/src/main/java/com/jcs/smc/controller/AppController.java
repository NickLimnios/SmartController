package com.jcs.smc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcs.smc.entity.Users;
import com.jcs.smc.service.UsersService;
//import com.jcs.smc.validator.UserValidator;

@Controller
public class AppController {
	
   /* @Autowired
    private UserValidator userValidator;*/

    @Autowired
    private UsersService userService;
    
	@RequestMapping(path= {"/","index"})
	public String index(Model model) {
		model.addAttribute("content", "index");
		return "layout";
	}
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login(Model model, String error, String logout) {
	        if (error != null)
	            model.addAttribute("error", "Your username and password is invalid.");

	        if (logout != null) {
	            model.addAttribute("message", "You have been logged out successfully.");
	        }
	        return "login";
	    }
	    @RequestMapping(value = "/register", method = RequestMethod.GET)
	    public String registration(Model model) {
	        model.addAttribute("user", new Users());
	        return "register";
	    }
	    @RequestMapping(value = "/register", method = RequestMethod.POST)
	    public String registration(@ModelAttribute("users") Users user, BindingResult bindingResult, Model model) {
	        /*userValidator.validate(user, bindingResult);
	        if (bindingResult.hasErrors()) {
	            return "register";
	        }*/
	        userService.save(user);
	        return "redirect:/layout";
	    }
	    
	    @RequestMapping(value = "/index", method = RequestMethod.GET)
	    public String introduceYourself(ModelMap model) {
	    	String name="ANONYMOUS";
	    	//Get the name of the logged-in user to pass it to a view. If there is no logged in user
	    	//the name will be "ANONYMOUS"
	        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        if (userDetails instanceof UserDetails) {
	            name = ((UserDetails)userDetails).getUsername();
	        }
	    	model.addAttribute("hellomsg", "Logged in user:  "+name);
	        return "index";
	    }

}
