package com.deasystem.HelpDesk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deasystem.HelpDesk.model.Role;
import com.deasystem.HelpDesk.repository.RolesRepository;

@Service
public class RolesServiceImpl implements RolesService {

	@Autowired
	private RolesRepository roleRepository;
	
	public RolesServiceImpl(RolesRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}

	@Override
	public List<Role> findAll() {
		return this.roleRepository.findAll();
	}

	@Override
	public Role create(Role role) {
		role.setNome(role.getNome().toUpperCase());
		Role roleCreated = this.roleRepository.save(role);
		return roleCreated;
	}

	@Override
	public Boolean delete(Long id) {
		if(findById(id) != null) {
			this.roleRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	private Optional<Role> findById(Long id) {
		return this.roleRepository.findById(id);
	}

}
