package tn.esprit.pfe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.pfe.entities.User;


@Repository
public interface IUtilisateurRepo extends JpaRepository <User, Long> {
	
	
Optional<User> findByUsername (String username);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);
	
	Optional<User> findByEmail(String email);
	
	@Query("select u from User u where u.archived = 1")
	List<User> getEmployes ();
	
	@Query("select u from User u where u.archived = 2")
	List<User> getArchivedEmployes ();
   

}
