package com.example.service;

import java.util.List;

import com.example.entities.User;

public interface UserService {
	User saveUser(User user);
	List<User> getAllUser();
	User getUser(int id);
}
