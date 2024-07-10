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

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/v1/create-users")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	@GetMapping("/v1/get-single-users/{id}")
	public ResponseEntity<User> getSingleUser(@PathVariable int id){
		User user1 = userService.getUser(id);
		return ResponseEntity.ok(user1);
	}
	
	@GetMapping("/v1/get-all-users")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> list = userService.getAllUser();
		return ResponseEntity.ok(list);
	}
}
