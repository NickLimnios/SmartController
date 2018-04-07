package com.jcs.smc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcs.smc.entity.DevicesServices;

@Repository("devicesservicesrepository")
public interface DevicesServicesRepository extends JpaRepository<DevicesServices,Integer>{
	List<DevicesServices> findAll();
	List<DevicesServices> findById(int id);
	List<DevicesServices> findByName(String name);
}
