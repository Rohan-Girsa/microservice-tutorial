package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Hotel;
import com.example.sevice.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping("/v1/create-hotels")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel hotel1 = hotelService.create(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
	}
	
	@PreAuthorize("hasAuthority('SCOPE_internal')")
	@GetMapping("/v1/get-single-hotel/{id}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable int id){
		Hotel hotel1 = hotelService.get(id);
		return ResponseEntity.ok(hotel1);
	}
	
	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping("/v1/get-all-hotels")
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> list = hotelService.getAll();
		return ResponseEntity.ok(list);
	}
}
