package com.jcs.smc.service;

import java.util.List;

import com.jcs.smc.entity.DevicesStatus;

public interface DevicesStatusService {
	List<DevicesStatus> findAll();
	List<DevicesStatus> findById(int id);
	List<DevicesStatus> findByCode(String code);
	DevicesStatus save(DevicesStatus deviceStatus);
	void delete(int id);
	void delete(DevicesStatus deviceStatus);
}
