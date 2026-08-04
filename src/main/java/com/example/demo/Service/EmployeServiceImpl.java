package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Repo.EmployeRepo;

@Service
public class EmployeServiceImpl implements EmployeService {
	
	@Autowired
	EmployeRepo repo;

	@Override
	public Employee add(Employee emp) {
		return repo.save(emp) ;
	}

	@Override
	public List<Employee> get() {
		return repo.findAll();
	}

	@Override
	public List<Employee> getnamelike() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee update(Integer id, Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

}
