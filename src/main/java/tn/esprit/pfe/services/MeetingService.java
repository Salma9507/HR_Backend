package tn.esprit.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pfe.entities.Meeting;
import tn.esprit.pfe.repository.IMeetingRepo;

@Service
public class MeetingService {

	
	
	@Autowired
	private IMeetingRepo meetingRepo;

	public List<Meeting> getAllMeetings() {
		return meetingRepo.findAll();
	}

	public Optional<Meeting> findMeetingById(Long id) {
		return meetingRepo.findById(id);
	}

	public Meeting saveMeeting(Meeting meeting) {
		return meetingRepo.save(meeting);
	}

	public Meeting updateMeeting(Meeting meeting) {
		return meetingRepo.save(meeting);
	}

	public void deleteMeeting(Meeting meeting) {
		if (meeting != null)
			meetingRepo.delete(meeting);
	}

}
