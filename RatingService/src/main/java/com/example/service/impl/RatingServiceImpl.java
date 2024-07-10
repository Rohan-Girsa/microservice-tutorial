package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Ratings;
import com.example.repo.RatingRepo;
import com.example.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public Ratings create(Ratings rating) {
		return ratingRepo.save(rating);
	}

	@Override
	public List<Ratings> getRatings() {
		return ratingRepo.findAll();
	}

	@Override
	public List<Ratings> getRatingsByUserId(int id) {
		return ratingRepo.findByUserId(id);
	}

	@Override
	public List<Ratings> getRatingsByHotelId(int id) {
		return ratingRepo.findByHotelId(id);
	}

}
