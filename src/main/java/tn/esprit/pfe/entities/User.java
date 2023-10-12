package tn.esprit.pfe.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



@Entity
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email") 
    })



public class User {


	
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long idUser;

	  @NotBlank
	  @Size(max = 20)
	  private String username;

	  @NotBlank
	  @Size(max = 50)
	  @Email
	  private String email;

	  @NotBlank
	  @Size(max = 120)
	  private String password;
	  
	  
	  private String prenom;
		
		private String nom;
	  
	  @JsonFormat
	  private LocalDate dateOfBirth;
		
		private String phone;
		
		
		private String cin;
		private String adresse ; 
		private String ville; 
		private String nationality; 
		private String family_status; 
		private String photo ="avatar.jpg" ; 
		
		
		private String repassword;
		
		private String status;
		private String salary;
		private String cnss; 
		private String departement;
		private String fonction;
		private String typeContrat;
		private LocalDate dateEntree;
		private LocalDate dateSortie;
		private String coutHeuresSup;
		private int dureeConges = 30;
		private int joursConges;
		private int soldeConges = 30;
		private String id_card_number;
		
		private int budget = 0;
		private int archived = 1 ; 
		

	  @ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(  name = "user_roles", 
	        joinColumns = @JoinColumn(name = "user_id"), 
	        inverseJoinColumns = @JoinColumn(name = "role_id"))
	  private Set<Role> roles = new HashSet<>();
	  
	  
	  
	  
	  
	  
	  
	  @JsonIgnore
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
		private List<Conge> conges;
		
		
		
	  
	  

	  public List<Conge> getConges() {
		return conges;
	}

	public void setConges(List<Conge> conges) {
		this.conges = conges;
	}

	public User() {
	  }

	  public User(String username, String email, LocalDate dateOfBirth,String phone, String password) {
	    this.username = username;
	    this.email = email;
	 
	    this.password = password;
	    this.dateOfBirth = dateOfBirth;
		this.phone = phone;
	  }

	  
	  
	  
	  public Long getIdUser() {
	    return idUser;
	  }

	  public void setIdUser(Long id) {
	    this.idUser= id;
	  }

	  public String getUsername() {
	    return username;
	  }

	  public void setUsername(String username) {
	    this.username = username;
	  }

	  public String getEmail() {
	    return email;
	  }

	  public void setEmail(String email) {
	    this.email = email;
	  }

	  public String getPassword() {
	    return password;
	  }

	  public void setPassword(String password) {
	    this.password = password;
	  }

	  
	  
	  
	  
	  public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Role> getRoles() {
	    return roles;
	  }

	  public void setRoles(Set<Role> roles) {
	    this.roles = roles;
	  }

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getFamily_status() {
		return family_status;
	}

	public void setFamily_status(String family_status) {
		this.family_status = family_status;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
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

	public int getJoursConges() {
		return joursConges;
	}

	public void setJoursConges(int joursConges) {
		this.joursConges = joursConges;
	}

	public int getSoldeConges() {
		return soldeConges;
	}

	public void setSoldeConges(int soldeConges) {
		this.soldeConges = soldeConges;
	}

	public String getId_card_number() {
		return id_card_number;
	}

	public void setId_card_number(String id_card_number) {
		this.id_card_number = id_card_number;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getArchived() {
		return archived;
	}

	public void setArchived(int archived) {
		this.archived = archived;
	}
	
	
	
}
