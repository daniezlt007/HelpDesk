package com.deasystem.HelpDesk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deasystem.HelpDesk.model.User;

@Controller
@RequestMapping("/")
public class UserController {
	
	@GetMapping("/users")
	public String index(Model model) {
		return "users/index"; 
	}
	
	@GetMapping("/new")
	public String createModel(Model model) {
		model.addAttribute("user", new User());
		return "users/create";
	}
	
	@GetMapping("/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		return "users/edit";
	}
	
}