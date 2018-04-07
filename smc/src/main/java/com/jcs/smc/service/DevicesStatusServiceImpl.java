package com.jcs.smc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcs.smc.entity.DevicesStatus;
import com.jcs.smc.repository.DevicesStatusRepository;

@Service
public class DevicesStatusServiceImpl implements DevicesStatusService {

	@Autowired
	private DevicesStatusRepository devicesStatusRepo;
	
	@Override
	public List<DevicesStatus> findAll() {
		return devicesStatusRepo.findAll();
	}

	@Override
	public List<DevicesStatus> findById(int id) {
		return devicesStatusRepo.findById(id);
	}

	@Override
	public List<DevicesStatus> findByCode(String code) {
		return devicesStatusRepo.findByCode(code);
	}

	@Override
	public DevicesStatus save(DevicesStatus deviceStatus) {
		return devicesStatusRepo.save(deviceStatus);
	}

	@Override
	public void delete(int id) {
		devicesStatusRepo.deleteById(id);
		
	}

	@Override
	public void delete(DevicesStatus deviceStatus) {
		devicesStatusRepo.delete(deviceStatus);
		
	}

}
