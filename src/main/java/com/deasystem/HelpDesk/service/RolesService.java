package com.deasystem.HelpDesk.service;

import java.util.List;

import com.deasystem.HelpDesk.model.Role;

public interface RolesService {

	public List<Role> findAll();
	public Role create(Role role);
	public Boolean delete(Long id);
	
}
