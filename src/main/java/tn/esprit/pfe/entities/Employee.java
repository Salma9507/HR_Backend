package tn.esprit.pfe.entities;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;

import lombok.EqualsAndHashCode;


@Entity

@EqualsAndHashCode(callSuper = false)

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Employee extends User {
	

	private String status;
	private String salary;
	private String cnss; 
	private String departement;
	private String fonction;
	private String typeContrat;
	private LocalDate dateEntree;
	private LocalDate dateSortie;
	private String coutHeuresSup;
	private int dureeConges;
	private String id_card_number;
	
	
	private boolean archived;

	
	
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Employee(String username, String email, String prenom, String nom, LocalDate dateOfBirth, String phone,
			String password) {
		super(username, email,dateOfBirth, phone, password);
		// TODO Auto-generated constructor stub
	}





	public Employee(String status, String salary, String cnss, String departement, String fonction, String typeContrat,
			LocalDate dateEntree, LocalDate dateSortie, String coutHeuresSup, int dureeConges, String id_card_number,
			boolean archived, List<EmployeMeeting> employeMeetings) {
		super();
		this.status = status;
		this.salary = salary;
		this.cnss = cnss;
		this.departement = departement;
		this.fonction = fonction;
		this.typeContrat = typeContrat;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.coutHeuresSup = coutHeuresSup;
		this.dureeConges = dureeConges;
		this.id_card_number = id_card_number;
		this.archived = archived;
		this.employeMeetings = employeMeetings;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getSalary() {
		return salary;
	}


	public void setSalary(String salary) {
		this.salary = salary;
	}


	public String getCnss() {
		return cnss;
	}


	public void setCnss(String cnss) {
		this.cnss = cnss;
	}


	public String getDepartement() {
		return departement;
	}


	public void setDepartement(String departement) {
		this.departement = departement;
	}


	public String getFonction() {
		return fonction;
	}


	public void setFonction(String fonction) {
		this.fonction = fonction;
	}


	public String getTypeContrat() {
		return typeContrat;
	}


	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}


	public LocalDate getDateEntree() {
		return dateEntree;
	}


	public void setDateEntree(LocalDate dateEntree) {
		this.dateEntree = dateEntree;
	}


	public LocalDate getDateSortie() {
		return dateSortie;
	}


	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}


	public String getCoutHeuresSup() {
		return coutHeuresSup;
	}


	public void setCoutHeuresSup(String coutHeuresSup) {
		this.coutHeuresSup = coutHeuresSup;
	}


	public int getDureeConges() {
		return dureeConges;
	}


	public void setDureeConges(int dureeConges) {
		this.dureeConges = dureeConges;
	}


	public String getId_card_number() {
		return id_card_number;
	}


	public void setId_card_number(String id_card_number) {
		this.id_card_number = id_card_number;
	}


	public boolean isArchived() {
		return archived;
	}


	public void setArchived(boolean archived) {
		this.archived = archived;
	}
	

	@OneToMany(mappedBy = "employe")
	private List<EmployeMeeting> employeMeetings;
	
	
	
	

}
