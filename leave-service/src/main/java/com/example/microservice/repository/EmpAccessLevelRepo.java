package com.example.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservice.entity.AccessLevel;
import com.example.microservice.entity.EmpAccessLevel;

@Repository
public interface EmpAccessLevelRepo extends JpaRepository<EmpAccessLevel, Long>{

	void save(AccessLevel accessLevel);

}
