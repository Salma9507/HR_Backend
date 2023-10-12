package tn.esprit.pfe.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.ServletContext;
import tn.esprit.pfe.entities.Conge;
import tn.esprit.pfe.entities.Employee;
import tn.esprit.pfe.repository.IEmployeeRepo;
import tn.esprit.pfe.services.EmployeeServiceImpl;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	
	
	//private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EmployeeServiceImpl emplService;
	
	@Autowired
	private IEmployeeRepo employeeRepo;
	

	
	@Autowired  
	ServletContext context;
	
	
	 @GetMapping("/employees")
	    public List<Employee> getAllEmployees() {
	        return employeeRepo.findAll();
	    }

	
	 

	 

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> findById(@PathVariable("id") Long id) {
		Optional<Employee> emp = emplService.findById(id);
		if (emp.isPresent())
			return new ResponseEntity<Employee>(emp.get(), HttpStatus.OK);
		else
			return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);

	}

	@PostMapping("/employees/create")
	public ResponseEntity<Employee> create(@RequestBody Employee employee) {
		try {
			emplService.saveEmploye(employee);
			return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@PostMapping("/employees/update")
	public ResponseEntity<Employee> update(@RequestBody Employee employe) {
		try {
			emplService.saveEmploye(employe);
			return new ResponseEntity<Employee>(employe, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> deleteEmploye(@PathVariable("id") Long id) {
		Optional<Employee> emp = emplService.findById(id);
		if (emp.isPresent()) {
			emplService.deleteEmploye(emp.get());
			return new ResponseEntity<Employee>(emp.get(), HttpStatus.ACCEPTED);
		} else
			return new ResponseEntity<Employee>(HttpStatus.NOT_ACCEPTABLE);
	}
	

	
	@DeleteMapping("/employees/{id}")
	  void deleteEmployee(@PathVariable Long id) {
		employeeRepo.deleteById(id);
	  }

	
	
	@GetMapping("/employees/count")
	Long countEmploye() {
		return emplService.countEmployee();
	}
	
    @GetMapping("/employees/conges")
	List<Conge> getCongeByemployeId (Long id) {
		return emplService.getCongeByemployeId(id);
	}
	



}
	
	

