package tn.esprit.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pfe.entities.Employee;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee, Long>  {

}
