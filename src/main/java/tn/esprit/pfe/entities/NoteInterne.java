package tn.esprit.pfe.entities;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;



@Entity
@Data
public class NoteInterne {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ; 
	
	private String title ; 
	
	private String content ; 
	
	private Instant createdOn ; 
	
	private Instant updatedOn ; 
	
	private String username ;
	
	
	
	
	
	
	public NoteInterne() {
		super();
		
	}

	public void setUsername(String username) {
        this.username = username;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Instant getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Instant createdOn) {
		this.createdOn = createdOn;
	}

	public Instant getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Instant updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUsername() {
		return username;
	}

	public NoteInterne(Long id, String title, String content, Instant createdOn, Instant updatedOn, String username) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.username = username;
	}
	
	
	
	
}