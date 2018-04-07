package com.jcs.smc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcs.smc.entity.DevicesServices;
import com.jcs.smc.repository.DevicesServicesRepository;

@Service
public class DevicesServicesServiceImpl implements DevicesServicesService {

	@Autowired
	private DevicesServicesRepository devicesServicesRepo;
	
	@Override
	public List<DevicesServices> findAll() {
		return devicesServicesRepo.findAll();
	}

	@Override
	public List<DevicesServices> findById(int id) {
		return devicesServicesRepo.findById(id);
	}

	@Override
	public List<DevicesServices> findByName(String name) {
		return devicesServicesRepo.findByName(name);
	}

	@Override
	public DevicesServices save(DevicesServices deviceservice) {
		return devicesServicesRepo.save(deviceservice);
	}

	@Override
	public void delete(int id) {
		devicesServicesRepo.deleteById(id);
		
	}

	@Override
	public void delete(DevicesServices deviceservice) {
		devicesServicesRepo.delete(deviceservice);
		
	}

}
