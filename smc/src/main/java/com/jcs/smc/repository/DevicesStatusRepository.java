package com.jcs.smc.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcs.smc.entity.DevicesStatus;

@Repository("devicesstatusRepository")
public interface DevicesStatusRepository extends JpaRepository<DevicesStatus,Integer>{
	List<DevicesStatus> findAll();
	List<DevicesStatus> findById(int id);
	List<DevicesStatus> findByCode(String code);
}
