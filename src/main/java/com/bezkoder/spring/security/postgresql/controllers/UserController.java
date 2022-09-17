package com.bezkoder.spring.security.postgresql.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.security.postgresql.models.Reclamation;
import com.bezkoder.spring.security.postgresql.models.User;
import com.bezkoder.spring.security.postgresql.repository.ReclamationRepository;
import com.bezkoder.spring.security.postgresql.repository.UserRepository;
import com.bezkoder.spring.security.postgresql.security.services.UserDetailsServiceImpl;
@RequestMapping("/api/users")
@RestController 
@CrossOrigin("*")
public class UserController {
	@Autowired
	public UserDetailsServiceImpl userDetailsServiceImpl ;
	@Autowired
	public UserRepository userRepository ;
	@Autowired
	public ReclamationRepository reclamationRepository ;
	
	  @PutMapping("/{id}")
	    public User UpdateUsers(@PathVariable(name = "id")long id, @RequestBody User U){
	        return userDetailsServiceImpl.UpdateUser(id,U);
	    }
	    @DeleteMapping("/{id}")
	    public void DeleteUser(@PathVariable(name = "id")long id){
	    	  userDetailsServiceImpl.DeleteUser(id);
	    }
        @GetMapping("/all")
        public List<User> GetAll() {
        	
        	return  userRepository.findAll();
        	
        }
        @GetMapping("/{id}")
        public Optional<User> GetById(@PathVariable(name = "id")long id) {
        	
        	return  userRepository.findById(id);
        	
        }
        
        @PutMapping("/add/{id}")
        public Optional<User> addReclamation (@PathVariable(name = "id")long id,  @RequestBody Reclamation reclamation) {
   		 Optional<User> user = userRepository.findById(id);
   		 Set<Reclamation> reclamations = user.get().getReclamations();
   		 reclamations.add(reclamation);
   		 user.get().setReclamations(reclamations);
   			// userRepository.save(user.get());
   		 reclamationRepository.save(reclamation);
	         userDetailsServiceImpl.UpdateUser(id,user.get());
   		 return user ;
        }
}
