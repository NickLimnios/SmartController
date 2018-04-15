package com.jcs.smc.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jcs.smc.entity.Users;
import com.jcs.smc.service.UsersService;

public class UserValidator implements Validator{
	 @Autowired
	    private UsersService usersService;
	    @Override
	    public boolean supports(Class<?> aClass) {
	        return Users.class.equals(aClass);
	    }
	    @Override
	    public void validate(Object o, Errors errors) {
	        Users user = (Users) o;

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
	        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
	            errors.rejectValue("username", "Size");
	        }
	        if (usersService.findByUsername(user.getUsername()) != null) {
	            errors.rejectValue("username", "Duplicate");
	        }

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
	        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
	            errors.rejectValue("password", "Size");
	        }
	    }
}
