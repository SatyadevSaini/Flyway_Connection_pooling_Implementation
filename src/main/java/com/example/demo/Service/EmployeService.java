package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Employee;

public interface EmployeService {
	
	 Employee add(Employee emp);
	 List<Employee> get();
	 List<Employee> getnamelike();
	 Employee update(Integer id , Employee emp);
	 
}
