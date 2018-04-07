package com.jcs.smc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcs.smc.entity.Roles;
import com.jcs.smc.repository.RolesRepository;

@Service
public class RolesServiceImpl implements RolesService{

	@Autowired
	private RolesRepository rolesRepo;
	
	@Override
	public List<Roles> findAll() {
		return rolesRepo.findAll();
	}

	@Override
	public List<Roles> findById(int id) {
		return rolesRepo.findById(id);
	}

	@Override
	public List<Roles> findByCode(String code) {
		return rolesRepo.findByCode(code);
	}

	@Override
	public Roles save(Roles role) {
		return rolesRepo.save(role);
	}

	@Override
	public void delete(int id) {
		rolesRepo.deleteById(id);
		
	}

	@Override
	public void delete(Roles role) {
		rolesRepo.delete(role);
		
	}

}
