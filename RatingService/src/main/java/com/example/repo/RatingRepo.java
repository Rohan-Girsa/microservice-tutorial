package com.example.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Ratings;

@Repository
@Transactional
public interface RatingRepo extends MongoRepository<Ratings, String>{
	List<Ratings> findByUserId(int userId);
	List<Ratings> findByHotelId(int hotelId);
}
