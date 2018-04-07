package com.jcs.smc.service;

import java.util.List;

import com.jcs.smc.entity.DevicesServices;

public interface DevicesServicesService {
	List<DevicesServices> findAll();
	List<DevicesServices> findById(int id);
	List<DevicesServices> findByName(String name);
	DevicesServices save(DevicesServices deviceservice);
	void delete(int id);
	void delete(DevicesServices deviceservice);
}
