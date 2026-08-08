package com.example.demo.Repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.Employee;

@Repository
public interface EmployeRepo extends JpaRepository<Employee, Integer> {
	
	List<Employee> findByNameLike(String name);
	List<Employee> findByNameContaining(String name); 
	List<Employee> findByNameStartingWith(String name);
	List<Employee> findByNameEndingWith(String name);
	List<Employee> findBySalaryGreaterThan(Integer Salary);
	List<Employee> findBySalaryBetween(Integer min, Integer max);
	
}
