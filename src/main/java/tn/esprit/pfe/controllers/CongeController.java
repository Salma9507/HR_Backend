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

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tn.esprit.pfe.entities.Conge;
import tn.esprit.pfe.entities.User;
import tn.esprit.pfe.repository.ICongeRepo;
import tn.esprit.pfe.repository.IUtilisateurRepo;
import tn.esprit.pfe.services.CongeService;






@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CongeController {

	@Autowired
	private CongeService congeService ;
	
	@Autowired
	private IUtilisateurRepo userRepo ;
	
	
	
	@Autowired
	private ICongeRepo congeRepo ; 

	
	@GetMapping("/conges")
	public List<Conge> getAllConge(){
		return congeRepo.findAll();
				
	}
	
	@PostMapping("/createConge")
	public Conge createConge ( @Valid @RequestBody Conge conge, @RequestParam Long id ) {
		
		User user = userRepo.findById(id).get();
		conge.setUser(user);
		return congeRepo.save(conge);
	}
	
	@GetMapping("/conge/{id}")
	public ResponseEntity<Conge> findById(@PathVariable("id") Long id) {
		Optional<Conge> conge = congeRepo.findById(id);
		if (conge.isPresent())
			return new ResponseEntity<Conge>(conge.get(), HttpStatus.OK);
		else
			return new ResponseEntity<Conge>(HttpStatus.NO_CONTENT);

	}
	
	@GetMapping("/congeUser/{id}")
	public List<Conge> getCongesByIdUser(@PathVariable("id") Long id){
		
		User user = userRepo.findById(id).get();
		return user.getConges();
		
	}
	
	@GetMapping("/accepter")
	public void accepterConge( @RequestParam Long id) {
	
		congeService.accepterConge(id);
		
}
	
	@GetMapping("/refuser")
	public void refuserConge (@RequestParam Long id) {
		
		congeService.refuserConge(id);
	}
	
	@DeleteMapping("/deleteConge/{id}")
	public ResponseEntity<Conge> deleteConge (@PathVariable("id") Long id) {
		Optional<Conge> conge = congeRepo.findById(id);
		if (conge.isPresent()) {
			congeRepo.delete(conge.get());
			return new ResponseEntity<Conge>(conge.get(), HttpStatus.ACCEPTED);
		} else
			return new ResponseEntity<Conge>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	@GetMapping("conges_attente")
	public List<Conge> getCongeByStatus (){
		return congeRepo.getCongeByStatus();
	}
	
	@GetMapping("/dureeConge/{id}")
	public int getDuree(@PathVariable Long id ) {
		return congeService.countDuree(id);
	}
	
	@GetMapping("/soldeConge/{id}")
	public int getSoldeConge(@PathVariable Long id ) {
		User user = userRepo.findById(id).get();
		return user.getJoursConges() - congeService.countDuree(id);
	}
	
	
	
	
}