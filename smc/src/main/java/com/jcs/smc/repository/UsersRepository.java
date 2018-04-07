package com.jcs.smc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcs.smc.entity.Users;

@Repository("userRepository")
public interface UsersRepository extends JpaRepository<Users,Integer> {
	List<Users> findAll();
	List<Users> findById(int id);
	List<Users> findByUsername(String username);
}
