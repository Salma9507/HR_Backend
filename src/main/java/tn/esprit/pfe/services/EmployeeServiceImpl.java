package tn.esprit.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pfe.entities.Conge;
import tn.esprit.pfe.entities.Employee;
import tn.esprit.pfe.repository.IEmployeeRepo;

@Service
public class EmployeeServiceImpl {
	
	

	@Autowired
	private IEmployeeRepo employeeRepo;

	
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	
	public boolean saveEmploye(Employee employee) {

		if (employeeRepo.save(employee) != null)
			return true;
		else
			return false;
	}

	
	public void deleteEmploye(Employee employee) {
		if (employee != null)
			employeeRepo.delete(employee);

	}

	
	public Employee updateEmploye(Employee employee) {
		return employeeRepo.save(employee);
	}

	
	public Long countEmployee() {

		return employeeRepo.count();

	}

	
	public Optional<Employee> findById(Long id) {

		return employeeRepo.findById(id);

	}
	
	public List<Conge> getCongeByemployeId (Long id){
		
		Employee employe = new Employee();
		if (employe.getConges() != null)
			return employe.getConges();
		else 
			return null ;
		
	}

}