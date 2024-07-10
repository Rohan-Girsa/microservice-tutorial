package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.entities.Ratings;
import com.example.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/v1/create-ratings")
	public ResponseEntity<Ratings> createRatings(@RequestBody Ratings rating){
		Ratings rating1 = ratingService.create(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
	}
	@GetMapping("/v1/get-all-ratings")
	public ResponseEntity<List<Ratings>> getRatings(){
		List<Ratings> list = ratingService.getRatings();
		return ResponseEntity.ok(list);
	}
	@GetMapping("/v1/get-single-user-ratings/{id}")
	public ResponseEntity<List<Ratings>> getSingleHotel(@PathVariable int id){
		List<Ratings> list = ratingService.getRatingsByUserId(id);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/v1/get-single-hotel-ratings/{id}")
	public ResponseEntity<List<Ratings>> getAllHotel(@PathVariable int id){
		List<Ratings> list = ratingService.getRatingsByHotelId(id);
		return ResponseEntity.ok(list);
	}

	@PutMapping("/v1/update-rating/{id}")
	public Ratings updateRating(@PathVariable("id") Integer id, Ratings rating){
		return null;
	}

	@DeleteMapping("/v1/delete-rating/{id}")
	public void deleteRating(@PathVariable("id") Integer id){

	}
}
