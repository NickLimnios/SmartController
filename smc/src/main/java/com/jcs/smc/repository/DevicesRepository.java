package com.jcs.smc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcs.smc.entity.Devices;

@Repository("devicesrepository")
public interface DevicesRepository extends JpaRepository<Devices,Integer>{
	List<Devices> findAll();
	List<Devices> findById(int id);
	List<Devices> findByCode(String code);
}
