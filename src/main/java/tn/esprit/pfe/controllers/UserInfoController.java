package tn.esprit.pfe.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import jakarta.servlet.ServletContext;
import tn.esprit.pfe.entities.User;
import tn.esprit.pfe.repository.IUtilisateurRepo;
import tn.esprit.pfe.services.UserService;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.sun.mail.iap.Response;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserInfoController {

	
	@Autowired
	ServletContext context;

	@Autowired
	private IUtilisateurRepo userRepo;
	
	@Autowired
	private UserService userService;

	
	
	
	
	

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@GetMapping("/user/{id}")
	public User findById(@PathVariable("id") Long id) {
		return userRepo.findById(id).get();

	}
	
	@GetMapping("/avatar/{id}")
	public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {

		User user = userRepo.findById(id).get();
		return Files.readAllBytes(Paths.get(context.getRealPath("/Images/") + user.getPhoto()));

	}
	
	
	


	
	@DeleteMapping("/users/{id}")
	void deleteUser(@PathVariable Long id) {
		userRepo.deleteById(id);
	  }
	
	
	
	@PutMapping("/updateUser")
	public User updateUser (@RequestBody User user) {
		return userRepo.save(user);
	}
	
	
	@GetMapping("/archiveEmploye/{id}")
	public void archiveEmploye (@PathVariable Long id) {
		
		User user = userRepo.findById(id).get();
		user.setArchived(2);
		userRepo.save(user);
	}
	
	@GetMapping("/activeEmployees")
	public List<User> getEmployees(){
		return userRepo.getEmployes();
	}
	
	@GetMapping("/archivedEmployees")
	public List<User> getArchivedEmployees(){
		return userRepo.getArchivedEmployes();
	}
	
	
	
	@PutMapping("/user")
	public ResponseEntity<Response> editUser(@RequestParam("image") MultipartFile file, @RequestParam("user") String user) 
			throws JsonParseException , JsonMappingException , Exception {
		
		User userIm = new ObjectMapper().registerModule(new JavaTimeModule()).readValue(user, User.class);
		
        boolean isExit = new File(context.getRealPath("/Images/")).exists();
        
        if (!isExit)
        {
        	new File (context.getRealPath("/Images/")).mkdir();
        	System.out.println("mk dir.............");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
        try
        {
        	System.out.println("Image");
        	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
        	 
        }catch(Exception e) {
        	e.printStackTrace();
        }

       
        userIm.setPhoto(newFileName);
        User user3 = userRepo.save(userIm);
        if (user3 != null)
        {
        	return new ResponseEntity<Response>(new Response (""),HttpStatus.OK);
        }
        else
        {
        	return new ResponseEntity<Response>(new Response ("Article not saved"),HttpStatus.BAD_REQUEST);	
        }
	}
	
	
	
	@PutMapping("/photo")
	public void editPhoto (@RequestParam("image") MultipartFile file, @RequestParam("id") String id) 
			throws JsonParseException , JsonMappingException , Exception {
		
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
        try
        {
        	System.out.println("Image");
        	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
        	 
        }catch(Exception e) {
        	e.printStackTrace();
        }

        
        
        
	}
	
	
	
	@PostMapping("/createEmploye")
    public ResponseEntity<?> createEmploye(@RequestPart("user") String user, @RequestParam("image") 
    MultipartFile file1) throws JsonParseException, JsonMappingException, IOException {
		
		
			
				User user1 = new ObjectMapper().readValue(user , User.class);
				System.out.println(user1);
				
				user1.setPhoto(file1.getOriginalFilename());
				User user2 = userRepo.save(user1);
				if (user2!=null) {
				return  ResponseEntity.status(HttpStatus.ACCEPTED).body("User is saved");
				}else {
					return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is not saved");
			}	
	}
	
	
	@PostMapping(path="/updateUsername")
	public ResponseEntity<Boolean> updateUsername( @RequestBody ObjectNode json
			){
		String email;
		String username;
		try {
			email = new ObjectMapper().treeToValue(json.get("email"), String.class);
			username = new ObjectMapper().treeToValue(json.get("username"), String.class);
			boolean test = this.userService.updateUsername(email, username);
			if(test)
			return new ResponseEntity<Boolean>(test,HttpStatus.OK);

		} catch (JsonProcessingException e) {
			System.out.println("Parsing Exception!!");
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false,HttpStatus.NOT_ACCEPTABLE);

		}			
		return new ResponseEntity<Boolean>(false,HttpStatus.NOT_ACCEPTABLE);

			
		}
	

	
	@PostMapping(path="/updatePassword")
	public ResponseEntity<Boolean> updatePassword( @RequestBody ObjectNode json
			){
		String email;
		String oldPass;
		String newPass;
		

		try {
			email = new ObjectMapper().treeToValue(json.get("email"), String.class);
			oldPass = new ObjectMapper().treeToValue(json.get("oldPass"), String.class);
			newPass = new ObjectMapper().treeToValue(json.get("newPass"), String.class);

			boolean test = this.userService.updatePassword(email, oldPass, newPass);
			if(test)
			return new ResponseEntity<Boolean>(test,HttpStatus.OK);

		} catch (JsonProcessingException e) {
			System.out.println("Parsing Exception!!");
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false,HttpStatus.NOT_ACCEPTABLE);

		}			
		return new ResponseEntity<Boolean>(false,HttpStatus.NOT_ACCEPTABLE);

			
		}
	
	
	



}
