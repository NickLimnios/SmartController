package com.jcs.smc.service;

import java.util.List;

import com.jcs.smc.entity.Rooms;

public interface RoomsService {
	List<Rooms> findAll();
	Rooms findById(int id);
	Rooms findByCode(String code);
	Rooms save(Rooms room);
	void delete(int id);
	void delete(Rooms room);
}
