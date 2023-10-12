package tn.esprit.pfe.controllers;

import java.time.LocalDate;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import tn.esprit.pfe.entities.Presence;
import tn.esprit.pfe.entities.User;
import tn.esprit.pfe.repository.IUtilisateurRepo;
import tn.esprit.pfe.repository.PresenceRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PresenceController {

	
	@Autowired
	private PresenceRepository presenceRepo;

	@Autowired
	private IUtilisateurRepo userRepo;

	@GetMapping("/presences")
	public List<Presence> getAllpresences() {
		return presenceRepo.findAll();
	}

	@PostMapping("/createPresence")
	public Presence createPresence(@RequestBody ObjectNode presence, @RequestParam Long id) throws JsonProcessingException {
		Presence pre = new Presence();
		pre.setNbrheures(new ObjectMapper().treeToValue(presence.get("nbrheures"), Integer.class));
		pre.setDay(LocalDate.parse(new ObjectMapper().treeToValue(presence.get("day"), String.class)));
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			pre.setUserInfo(user.get());
		}
		return presenceRepo.save(pre);
	}
	
	@DeleteMapping("/presence/delete/{id}")
	public void deletePresence (@PathVariable Long id){
		presenceRepo.deleteById(id);
		
	}
	
	
		
	@GetMapping("/getPresence")
	public List<Presence> findUserPresenceByUserId (@RequestParam Long id) {
		
		return presenceRepo.findUserPresenceByUserId(id);
	}
	
	
	/*@GetMapping("/getPresence")
	public ResponseEntity<List<Presence>> findUserPresenceByUserId(@RequestParam Long id) {
	    List<Presence> presenceList = presenceRepo.findUserPresenceByUserId(id);
	    return new ResponseEntity<>(presenceList, HttpStatus.OK);
	}*/
}
