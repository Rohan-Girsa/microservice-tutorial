package com.example.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.entities.Hotels;
import com.example.entities.Ratings;
import com.example.external.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.User;
import com.example.exceptions.ResourceNotFoundException;
import com.example.repo.UserRepo;
import com.example.service.UserService;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelService hotelService;

	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User getUser(int id) {
		User user = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with given ID: "+id+" does not exists."));
		Ratings[] list = restTemplate.getForObject("http://RATINGSERVICE/ratings/v1/get-single-user-ratings/"+user.getId(), Ratings[].class);
		List<Ratings> ratings = Arrays.stream(list).collect(Collectors.toList());
		List<Ratings> ratingList = ratings.stream().map(rating ->{
			Hotels hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratingList);
		return user;
	}

}
