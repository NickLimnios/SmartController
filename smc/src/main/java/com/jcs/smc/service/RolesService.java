package com.jcs.smc.service;

import java.util.List;

import com.jcs.smc.entity.Roles;

public interface RolesService {
	List<Roles> findAll();
	List<Roles> findById(int id);
	List<Roles> findByCode(String code);
	Roles save(Roles role);
	void delete(int id);
	void delete(Roles role);
}
