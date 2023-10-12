package tn.esprit.pfe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.pfe.entities.Conge;

@Repository
public interface ICongeRepo  extends JpaRepository<Conge, Long>  {
	
	@Query("select c from Conge c where c.statusOfDemand like 'Waiting'")
	public List<Conge> getCongeByStatus();
	
	@Query("select count(duree) from Conge c where c.user.idUser = :id")
	public int countDuree(Long id );
	
	
	
	

}
