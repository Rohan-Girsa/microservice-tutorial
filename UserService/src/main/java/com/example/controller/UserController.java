package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.User;
import com.example.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	int retryCount = 1;

	@Autowired
	private UserService userService;

	@PostMapping("/v1/create-users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

	@GetMapping("/v1/get-single-users/{id}")
//	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//	@Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable int id) {
		User user1 = userService.getUser(id);
		log.info("Retry Count: {}", retryCount);
		retryCount++;
		return ResponseEntity.ok(user1);
	}

	public ResponseEntity<User> ratingHotelFallback(int id, Exception e) {
//		log.info("Fallback is executed because service is down: {}", e.getMessage());

		User user = User.builder().email("dummy@gmail.com").name("dummy")
				.about("This user is created because some service is down").id(id).build();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/v1/get-all-users")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> list = userService.getAllUser();
		return ResponseEntity.ok(list);
	}
}
