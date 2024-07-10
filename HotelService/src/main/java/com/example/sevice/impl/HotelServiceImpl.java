package com.example.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Hotel;
import com.example.exceptions.ResourceNotFoundException;
import com.example.repo.HotelRepo;
import com.example.sevice.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel create(Hotel hotel) {
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel get(int id) {
		return hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with given ID: "+id+" does not exists."));
	}

}
