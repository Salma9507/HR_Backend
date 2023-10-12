package tn.esprit.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pfe.entities.NoteInterne;



@Repository
public interface NoteInterneRepo extends JpaRepository<NoteInterne, Long>{

}
