package com.example.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rating.entity.EmpRating;

public interface EmpRatingRepo extends JpaRepository<EmpRating, Long> {

	
}
