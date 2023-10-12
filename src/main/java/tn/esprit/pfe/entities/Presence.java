package tn.esprit.pfe.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.Data;


@Entity
@Data

public class Presence {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private LocalDate day;
	private int nbrheures;

	@ManyToOne
	private User userInfo ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public int getNbrheures() {
		return nbrheures;
	}

	public void setNbrheures(int nbrheures) {
		this.nbrheures = nbrheures;
	}

	public User getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(User userInfo) {
		this.userInfo = userInfo;
	}

	public Presence(long id, LocalDate day, int nbrheures) {
		
		this.id = id;
		this.day = day;
		this.nbrheures = nbrheures;
	}

	public Presence() {
	
	}
	
	
	
	
}
