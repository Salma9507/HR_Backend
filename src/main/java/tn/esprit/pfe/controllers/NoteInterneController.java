package tn.esprit.pfe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pfe.entities.NoteInterne;
import tn.esprit.pfe.repository.NoteInterneRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NoteInterneController {

	@Autowired
	private NoteInterneRepo noteInterneRepo ; 
	
	@PostMapping("/createNoteInterne")
    public NoteInterne createCandidate( @RequestBody NoteInterne noteInterne) {
		System.out.println("hello"+noteInterne.getTitle());
		return noteInterneRepo.save(noteInterne);
		
	}
	
	@GetMapping("/notes")
    public List<NoteInterne> getAllNotes() {
        return noteInterneRepo.findAll();
    }
	
	@DeleteMapping("/notes/{id}")
	void deleteNote(@PathVariable Long id) {
		noteInterneRepo.deleteById(id);
	  }
	
	
	
	@PutMapping("/annonce")
	public NoteInterne editNote(@RequestBody NoteInterne note) {
		return noteInterneRepo.save(note);
	}

}
