package com.example.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservice.entity.Leave;

public interface LeaveRepo extends JpaRepository<Leave, Long>{

}
