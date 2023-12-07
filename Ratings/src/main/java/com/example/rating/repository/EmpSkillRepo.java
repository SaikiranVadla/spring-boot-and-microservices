package com.example.rating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rating.entity.EmpSkill;

@Repository
public interface EmpSkillRepo extends JpaRepository<EmpSkill, Long> {

}
