package com.example.rental.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rental.model.RegistrationRequest;
import com.example.rental.repository.UserRepository;

@RestController
@RequestMapping("/api/register")
public class RegistrationController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/save")
	public void saveUser(@RequestParam("id") Long id, @RequestParam("firstName") String first, 
			@RequestParam("lastName") String last, 
			@RequestParam("email") String email, @RequestParam("password") String password) {
		
		RegistrationRequest request = new RegistrationRequest();
		request.setId(id);
		request.setFirstName(first);
		request.setLastName(last);
		request.setEmail(email);
		request.setPassword(password);
		userRepository.save(request);
	}
	
	@GetMapping("/find")
	public ResponseEntity<List<RegistrationRequest>> findByEmail(@RequestParam("email") String email) {
		return new ResponseEntity<List<RegistrationRequest>>(this.userRepository.findByEmail(email), HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public  RegistrationRequest  deletRequest(@PathVariable(value="id") Long id,
			@RequestBody RegistrationRequest request) {
		
		Optional<RegistrationRequest> optRequest = this.userRepository.findById(id);
		if(optRequest.isPresent()) {
			this.userRepository.deleteAll();
		}
		return request;
	}
	
	@GetMapping("/user")
	public List<RegistrationRequest> getAllUser() {
		return this.userRepository.findAll();
	}
}
