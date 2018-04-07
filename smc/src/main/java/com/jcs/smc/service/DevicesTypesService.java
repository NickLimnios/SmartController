package com.jcs.smc.service;

import java.util.List;

import com.jcs.smc.entity.DevicesTypes;

public interface DevicesTypesService {
	List<DevicesTypes> findAll();
	List<DevicesTypes> findById(int id);
	List<DevicesTypes> findByCode(String code);
	DevicesTypes save(DevicesTypes deviceType);
	void delete(int id);
	void delete(DevicesTypes deviceType);
}
