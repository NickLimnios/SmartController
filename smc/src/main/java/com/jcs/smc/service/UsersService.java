package com.jcs.smc.service;

import java.util.List;

import com.jcs.smc.entity.Users;

public interface UsersService {
	List<Users> findAll();
	List<Users> findById(int id);
	List<Users> findByUsername(String username);
	Users save(Users user);
	void delete(int id);
	void delete(Users user);
}
