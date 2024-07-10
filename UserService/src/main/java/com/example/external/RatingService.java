package com.example.external;

import com.example.entities.Ratings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

    @PostMapping("/ratings/v1/create-ratings")
    public Ratings createRating(Ratings rating);

    @PutMapping("/ratings/v1/update-rating/{id}")
    public Ratings updateRating(@PathVariable("id") Integer id, Ratings rating);

    @DeleteMapping("/ratings/v1/delete-rating/{id}")
    public void deleteRating(@PathVariable("id") Integer id);
}
