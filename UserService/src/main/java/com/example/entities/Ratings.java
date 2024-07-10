package com.example.entities;

import lombok.Data;

@Data
public class Ratings {
	private String ratingId;
	private Integer userId;
	private Integer hotelId;
	private Integer rating;
	private String feedback;
	private Hotels hotel;
}
