package com.jcs.smc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcs.smc.entity.DevicesTypes;
import com.jcs.smc.repository.DevicesTypesRepository;

@Service
public class DevicesTypesServiceImpl implements DevicesTypesService {

	@Autowired
	private DevicesTypesRepository devicesTypesRepo;
	
	@Override
	public List<DevicesTypes> findAll() {
		return devicesTypesRepo.findAll();
	}

	@Override
	public List<DevicesTypes> findById(int id) {
		return devicesTypesRepo.findById(id);
	}

	@Override
	public List<DevicesTypes> findByCode(String code) {
		return devicesTypesRepo.findByCode(code);
	}

	@Override
	public DevicesTypes save(DevicesTypes deviceType) {
		return devicesTypesRepo.save(deviceType);
	}

	@Override
	public void delete(int id) {
		devicesTypesRepo.deleteById(id);
		
	}

	@Override
	public void delete(DevicesTypes deviceType) {
		devicesTypesRepo.delete(deviceType);
		
	}

}
