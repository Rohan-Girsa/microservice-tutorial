package com.example.sevice;

import java.util.List;

import com.example.entities.Hotel;

public interface HotelService {
	
	Hotel create(Hotel hotel);
	List<Hotel> getAll();
	Hotel get(int id);
}
