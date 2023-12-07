package com.example.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.rating.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	

//	   @Query("SELECT skill.work, rating.techRating, rating.commRating " +
//	           "FROM EmployeeData e " +
//	           "JOIN e.empSkill skill " +
//	           "JOIN e.empRating rating " +
//	           "WHERE skill.work = 'trainee' " +
//	           "AND rating.techRating < 2.5 " +
//	           "AND rating.commRating < 2.5")
	
//	@Query("SELECT e.email " +
//		       "FROM EmployeeData e " +
//		       "JOIN e.empSkill skill " +
//		       "JOIN e.empRating rating " +
//		       "WHERE skill.work = 'trainee' " +
//		       "AND rating.techRating < 2.5 " +
//		       "OR rating.commRating < 2.5")
//	    List<Object[]> findWorkTechCommRatingsForTraineesWithLowRatings();

	
	@Query("SELECT e " +
		       "FROM Employee e " +
		       "JOIN e.empskill skill " +
		       "JOIN e.emprating rating " +
		       "WHERE skill.working = 'trainee' " +
		       "AND (rating.techrating < 2.5 AND rating.communicrating < 2.5)")
	      List<Employee> findEmployeesWithLowRatings();

}
