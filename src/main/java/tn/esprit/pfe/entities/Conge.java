package tn.esprit.pfe.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Data;


@Entity

@Data
public class Conge implements Serializable  {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCong;
	private String typeCong;
	private Date debutCong;
	private Date finCong;
	private Date createdAt;
	private String description;
	private int duree ; 
	private int soldeConge ; 
	private String statusOfDemand="Waiting";
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "idUser")
	private User user;
	
	
	
	
	
	public Long getIdCong() {
		return idCong;
	}
	public void setIdCong(Long idCong) {
		this.idCong = idCong;
	}
	public String getTypeCong() {
		return typeCong;
	}
	public void setTypeCong(String typeCong) {
		this.typeCong = typeCong;
	}
	public Date getDebutCong() {
		return debutCong;
	}
	public void setDebutCong(Date debutCong) {
		this.debutCong = debutCong;
	}
	public Date getFinCong() {
		return finCong;
	}
	public void setFinCong(Date finCong) {
		this.finCong = finCong;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public int getSoldeConge() {
		return soldeConge;
	}
	public void setSoldeConge(int soldeConge) {
		this.soldeConge = soldeConge;
	}
	public String getStatusOfDemand() {
		return statusOfDemand;
	}
	public void setStatusOfDemand(String statusOfDemand) {
		this.statusOfDemand = statusOfDemand;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
