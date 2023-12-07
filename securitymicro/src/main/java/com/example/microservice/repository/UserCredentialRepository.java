package com.example.microservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservice.entity.UserCredential;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Integer>{
	
	 Optional<UserCredential> findByEmail(String email);
	}


