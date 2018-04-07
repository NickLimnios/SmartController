package com.jcs.smc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcs.smc.entity.DevicesTypes;

@Repository("devicesTypesRepository")
public interface DevicesTypesRepository extends JpaRepository<DevicesTypes, Integer>{
	List<DevicesTypes> findAll();
	List<DevicesTypes> findById(int id);
	List<DevicesTypes> findByCode(String code);
}