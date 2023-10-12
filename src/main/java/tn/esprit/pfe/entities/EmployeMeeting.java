package tn.esprit.pfe.entities;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeMeeting implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private PKEmployeMeeting pkEmployeMeeting;
	
	@ManyToOne
	@JoinColumn(name = "idMeeting", referencedColumnName = "idMeeting", insertable = false, updatable = false)
	private Meeting meeting;
	
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "idUser", insertable = false, updatable = false)
	private Employee employe;

}


