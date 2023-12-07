package com.example.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservice.entity.Manager;

@Repository
public interface ManagerRepo extends JpaRepository<Manager, Long>{

	

}
