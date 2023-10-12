package tn.esprit.pfe.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity

public class Meeting implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idMeeting;
	private String titre;
	private String type;
	
	
	//@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate meetingDay;
	private LocalTime meetingTime;
	private boolean canceled;
//	@OneToMany(mappedBy = "meeting")
//	private List<EmployeMeeting> employeMeetings;
	
	
	
	public Long getIdMeeting() {
		return idMeeting;
	}
	public void setIdMeeting(Long idMeeting) {
		this.idMeeting = idMeeting;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalDate getMeetingDay() {
		return meetingDay;
	}
	public void setMeetingDay(LocalDate meetingDay) {
		this.meetingDay = meetingDay;
	}
	public LocalTime getMeetingTime() {
		return meetingTime;
	}
	public void setMeetingTime(LocalTime meetingTime) {
		this.meetingTime = meetingTime;
	}
	public boolean isCanceled() {
		return canceled;
	}
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	public Meeting(Long idMeeting, String titre, String type,LocalDate meetingDay, LocalTime meetingTime,
			boolean canceled) {
		super();
		this.idMeeting = idMeeting;
		this.titre = titre;
		this.type = type;
		this.meetingDay = meetingDay;
		this.meetingTime = meetingTime;
		this.canceled = canceled;
	}
	public Meeting() {
		
	}
	
	
	
}





