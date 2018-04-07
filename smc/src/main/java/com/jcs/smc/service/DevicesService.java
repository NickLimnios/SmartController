package com.jcs.smc.service;

import java.util.List;

import com.jcs.smc.entity.Devices;

public interface DevicesService {
	List<Devices> findAll();
	List<Devices> findById(int id);
	List<Devices> findByCode(String code);
	Devices save(Devices device);
	void delete(int id);
	void delete(Devices device);
}
