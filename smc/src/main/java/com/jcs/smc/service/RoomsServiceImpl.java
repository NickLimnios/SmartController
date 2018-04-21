package com.jcs.smc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcs.smc.entity.Rooms;
import com.jcs.smc.repository.RoomsRepository;

@Service
public class RoomsServiceImpl implements RoomsService{

	@Autowired
	private RoomsRepository roomsRepo;
	
	@Override
	public List<Rooms> findAll() {
		return roomsRepo.findAll();
	}

	@Override
	public Rooms findById(int id) {
		return roomsRepo.findById(id);
	}

	@Override
	public Rooms findByCode(String code) {
		return roomsRepo.findByCode(code);
	}

	@Override
	public Rooms save(Rooms room) {
		return roomsRepo.save(room);
	}

	@Override
	public void delete(int id) {
		roomsRepo.deleteById(id);
		
	}

	@Override
	public void delete(Rooms room) {
		roomsRepo.delete(room);
		
	}
}
