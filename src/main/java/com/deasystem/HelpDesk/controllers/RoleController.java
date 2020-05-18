package com.deasystem.HelpDesk.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.deasystem.HelpDesk.model.Role;
import com.deasystem.HelpDesk.service.RolesService;

@Controller
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	private RolesService roleService;
	
	public RoleController(RolesService roleService) {
		super();
		this.roleService = roleService;
	}

	@GetMapping
	public String index(Model model) {
		model.addAttribute("lista",this.roleService.findAll());
		return "roles/index";
	}
	
	@GetMapping("/new")
	public String create(Model model) {
		model.addAttribute("role", new Role());
		return "roles/create";
	}
	
	@PostMapping
	public String save(@Valid @ModelAttribute("role")Role role, BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "-/roles/new";
		}else {
			Role roleCreated = this.roleService.create(role);
			return "redirect:/roles";
		}
	}
	
	@RequestMapping(value = "/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") Long id, Model model) {
		this.roleService.delete(id);
		return "redirect:/roles";
	}
	
	
}
