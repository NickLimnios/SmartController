package com.jcs.smc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcs.smc.entity.Users;
import com.jcs.smc.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersRepository usersRepo;
	
	@Override
	public List<Users> findAll() {
		return usersRepo.findAll();
	}

	@Override
	public List<Users> findById(int id) {
		return usersRepo.findById(id);
	}

	@Override
	public List<Users> findByUsername(String username) {
		return usersRepo.findByUsername(username);
	}

	@Override
	public Users save(Users user) {
		return usersRepo.save(user);
	}

	@Override
	public void delete(int id) {
		usersRepo.deleteById(id);
		
	}

	@Override
	public void delete(Users user) {
		usersRepo.delete(user);
		
	}

}
