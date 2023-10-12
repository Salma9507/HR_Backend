package tn.esprit.pfe.services;

import org.springframework.stereotype.Service;

import tn.esprit.pfe.dto.RegisterRequest;
import tn.esprit.pfe.entities.User;
import tn.esprit.pfe.repository.IUtilisateurRepo;

@Service
public class AuthService {
	
private IUtilisateurRepo userRepo ; 
	
	public void signup (RegisterRequest registerRequest) {
		User user = new User();
		user.setUsername(registerRequest.getUserName());
		user.setPassword(registerRequest.getPassword());
		user.setEmail(registerRequest.getEmail());
		userRepo.save(user);
	}

}
