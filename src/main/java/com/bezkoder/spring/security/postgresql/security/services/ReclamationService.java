package com.bezkoder.spring.security.postgresql.security.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.security.postgresql.models.Reclamation;
import com.bezkoder.spring.security.postgresql.models.User;
import com.bezkoder.spring.security.postgresql.repository.ReclamationRepository;
import com.bezkoder.spring.security.postgresql.repository.UserRepository;
import com.bezkoder.spring.security.postgresql.security.UserPrincipal;
@Service
public class ReclamationService {
	@Autowired
    private ReclamationRepository reclamationRepository;
	@Autowired
    private UserRepository userRepository;


	public List<Reclamation> getreclamation(){
		 return reclamationRepository.findAll();}

	public Reclamation addNewReclamation(Reclamation reclamation) {
		try {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null ||
                !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken) {
        	System.err.println("!!!!!");
        }
 
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Long userId = userDetails.getId();
        reclamation.setUser_id(userId);
		Reclamation newReclamation  = reclamationRepository.save(reclamation);
		return newReclamation;
		} catch(Exception e ) {throw e; }
		
		/* List<User> users = userRepository.findAll();
		 Set<Reclamation> reclamations = new HashSet<>();
		 reclamations.add(reclamation);
		 User user = users.get(0);
		 user.setReclamations(reclamations);
			// userRepository.save(user);
		return users ;*/
	};

	public Reclamation getreclamation(long id) {
		return reclamationRepository.findById(id).get();
		};

	public Reclamation UpdateReclamation(long id, Reclamation R) {
		 R.setId(id);
	        return reclamationRepository.save(R);
	};



	public void DeleteReclamartion(long id) {
		  reclamationRepository.deleteById(id);
	};

}


