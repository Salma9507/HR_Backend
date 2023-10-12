package tn.esprit.pfe.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class PKEmployeMeeting  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long idMeeting ; 

}
