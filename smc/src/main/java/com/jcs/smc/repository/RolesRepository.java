package com.jcs.smc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcs.smc.entity.Roles;

@Repository("rolesRepository")
public interface RolesRepository extends JpaRepository<Roles,Integer>{
	List<Roles>findAll();
	List<Roles>findById(int id);
	List<Roles>findByCode(String code);
}
