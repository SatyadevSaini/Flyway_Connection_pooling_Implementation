package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Employee;

public interface EmployeService {
	
	 Employee add(Employee emp);
	 List<Employee> get();
	 List<Employee> getnamelike();
	 Employee update(Integer id , Employee emp);
	 void delete(Integer id);
	 List<Employee> add100Employe(List<Employee> emp);  // API for adding 100 employee at one call !!  
	 //create like query 
	 List<Employee> findByNameLike(String name);
     //containing query !!!
	 List<Employee> findByNameContaining(String name);
	 List<Employee> findByNameStartingwith(String name);
	 
	 List<Employee> findByNameEndingWith(String name);

	 List<Employee> findBySalaryGreaterThan(Integer Salary);
	 
	 List<Employee> findBySalaryBetween(Integer min, Integer max);

}
