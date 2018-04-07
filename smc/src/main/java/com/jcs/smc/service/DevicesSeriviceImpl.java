package com.jcs.smc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcs.smc.entity.Devices;
import com.jcs.smc.repository.DevicesRepository;

@Service
public class DevicesSeriviceImpl implements DevicesService{

	@Autowired
	private DevicesRepository devicesRepo;
	
	@Override
	public List<Devices> findAll() {
		return devicesRepo.findAll();
	}

	@Override
	public List<Devices> findById(int id) {
		return devicesRepo.findById(id);
	}

	@Override
	public List<Devices> findByCode(String code) {
		return devicesRepo.findByCode(code);
	}

	@Override
	public Devices save(Devices device) {
		return devicesRepo.save(device);
	}

	@Override
	public void delete(int id) {
		devicesRepo.deleteById(id);
		
	}

	@Override
	public void delete(Devices device) {
		devicesRepo.delete(device);
		
	}

}
