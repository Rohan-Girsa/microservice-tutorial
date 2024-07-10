package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.User;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<User, Integer>{
//	User findById(int id);
}
