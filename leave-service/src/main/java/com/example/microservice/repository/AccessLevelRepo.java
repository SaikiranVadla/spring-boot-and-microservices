package com.example.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservice.entity.AccessLevel;

@Repository
public interface AccessLevelRepo extends JpaRepository<AccessLevel, Long>{

}
