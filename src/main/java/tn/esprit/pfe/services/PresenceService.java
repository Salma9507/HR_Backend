package tn.esprit.pfe.services;

import org.springframework.stereotype.Service;

@Service
public class PresenceService {

	/*@Autowired
	private PresenceRepository presenceRepo;
	@Autowired
	private IUtilisateurRepo userInfoRepo;

	public Presence findByIdAndDay(String nfcTagID, LocalTime time) {
		List<User> userInfo = userInfoRepo.findUserByNFCTagID(nfcTagID);
	if (!userInfo.isEmpty()) {
			List<Attendance> attendances = attRepo.findByIdAndDay(userInfo.get(0).getUserId(), LocalDate.now());
			if (attendances.isEmpty() || (!attendances.isEmpty() && attendances.get(0).getEntryTime() != null
					&& attendances.get(0).getLeaveTime() != null)) {
				Attendance attendance = new Attendance();
				attendance.setDay(LocalDate.now());
				attendance.setEntryTime(time);
				attendance.setUserInfo(userInfo.get(0));
				attRepo.save(attendance);
				return attendance;
			}
			attendances.get(0).setLeaveTime(time);
			attRepo.save(attendances.get(0));
			return attendances.get(0);
		}
		return null;
	}
	
*/
}
