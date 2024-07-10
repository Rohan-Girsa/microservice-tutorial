package com.example.service;

import java.util.List;

import com.example.entities.Ratings;

public interface RatingService {
	Ratings create(Ratings rating);
	List<Ratings> getRatings();
	List<Ratings> getRatingsByUserId(int id);
	List<Ratings> getRatingsByHotelId(int id);
}
