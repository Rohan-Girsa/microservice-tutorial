package com.example.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("ratings")
@Data
public class Ratings {
	@Id
	private String ratingId;
	private Integer userId;
	private Integer hotelId;
	private Integer rating;
	private String feedback;
}
