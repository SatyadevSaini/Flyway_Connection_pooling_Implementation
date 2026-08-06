package com.example.demo.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Employee;
import com.example.demo.Repo.EmployeRepo;
import jakarta.transaction.Transactional;

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
		return repo.findAll();
	}

	@Override
	public Employee update(Integer id, Employee emp) {
		
		Employee existsemp = repo.findById(id).orElseThrow(() ->
        new RuntimeException("Employee not found with id : " + id));
		existsemp.setContactNumber(emp.getContactNumber());
		existsemp.setName(emp.getName());
		existsemp.setSalary(emp.getSalary());
		
		return repo.save(existsemp);
		
	}

	@Override
	public void delete(Integer id) {
		Employee existscheck = repo.findById(id).orElseThrow(() -> new RuntimeException("Employe not find" +id));
		repo.delete(existscheck);
		
	}

	@Override
	@Transactional
	public List<Employee> add100Employe(List<Employee> emp) {
		return repo.saveAll(emp);
	}

}
