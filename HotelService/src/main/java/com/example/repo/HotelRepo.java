package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Hotel;

@Repository
@Transactional
public interface HotelRepo extends JpaRepository<Hotel, Integer>{

}
