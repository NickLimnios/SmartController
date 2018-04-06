package com.jcs.smc.service;

import java.util.List;

import com.jcs.smc.entity.Rooms;

public interface RoomsService {
	List<Rooms> findAll();
	List<Rooms> findById(int id);
	List<Rooms> findByCode(String code);
}
