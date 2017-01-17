package com.lab.waa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab.waa.model.Users;


@Controller
public class LoginController {
	

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage()
	{
		return "index";
	}
	
	
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("username") String username,@RequestParam("password") String password, Model model)
	{
		
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		
		com.lab.waa.service.UserService userService = new com.lab.waa.service.UserService();
		
		if(userService.validate(user))
		{
			model.addAttribute("message", username);
			return "welcome";
		}
		model.addAttribute("error", "Invalid username or password!");

		return "index";
		
	}



}
