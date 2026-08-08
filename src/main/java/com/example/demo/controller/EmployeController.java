package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employee;
import com.example.demo.Repo.EmployeRepo;
import com.example.demo.Service.EmployeServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmployeController {
	
	@Autowired
	EmployeServiceImpl service;
	
	@Autowired
	EmployeRepo repo;
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee saveEmp = service.add(employee);
		return new ResponseEntity<>(saveEmp , HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAll(){
		List<Employee> data= service.get();
		return new ResponseEntity<>(data , HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> update(@PathVariable Integer id , @RequestBody Employee emp){
		Employee data= service.update(id, emp);
		return new ResponseEntity<>(data , HttpStatus.OK);
	}
	
	@GetMapping("/getlike")
	public ResponseEntity<List<Employee>> get(){
		List<Employee> data= service.getnamelike();
		return new ResponseEntity<>(data , HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
		service.delete(id);
		return  ResponseEntity.noContent().build();
	}
	
	@PostMapping("/addAll")
	public ResponseEntity<List<Employee>> addAll(@RequestBody List<Employee> emp){
	List<Employee> employees =	service.add100Employe(emp);
	return new ResponseEntity<>(employees , HttpStatus.CREATED);
	}
	
	@GetMapping("/getNameLike/{name}")
	public ResponseEntity<List<Employee>> getNameLike(@PathVariable String name){
		List<Employee> employees = service.findByNameLike("%"+name+"%");
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	
	@GetMapping("/nameContaining/{name}")
	public ResponseEntity<List<Employee>> containing(@PathVariable String name){
		List<Employee> employees = service.findByNameContaining(name);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	
	@GetMapping("/findByNameStartingwith/{name}")
	public ResponseEntity<List<Employee>> findByNameStartingwith(@PathVariable String name){
		List<Employee> employees = service.findByNameStartingwith(name);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/findByNameEndingWith/{name}")
	public ResponseEntity<List<Employee>> findByNameEndingWith(@PathVariable String name){
		List<Employee> employees = service.findByNameEndingWith(name);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/findBySalaryGreaterThan/{salary}")
	public ResponseEntity<List<Employee>> findBySalaryGreaterThan(@PathVariable Integer salary){
		List<Employee> employees = service.findBySalaryGreaterThan(salary);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	 
	
	@GetMapping("/findBySalaryBetween")
	public ResponseEntity<List<Employee>> findBySalaryBetween(@RequestParam Integer min , @RequestParam Integer max){
		List<Employee> employees = service.findBySalaryBetween(min, max);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	

	

}
