package com.jcs.smc.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jcs.smc.entity.Rooms;

@Repository("roomsRepository")
public interface RoomsRepository extends JpaRepository<Rooms, Integer>{
	List<Rooms> findAll();
	Rooms findById(int id);
	Rooms findByCode(String code);
}
