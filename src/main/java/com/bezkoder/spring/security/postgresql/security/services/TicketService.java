package com.bezkoder.spring.security.postgresql.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bezkoder.spring.security.postgresql.models.Ticket;
import com.bezkoder.spring.security.postgresql.repository.TicketRepository;

@Service
public class TicketService {
	 @Autowired
	    private TicketRepository ticketRepository;

	public List<Ticket> getticket() {
		 return ticketRepository.findAll();
	
	}

	public Ticket getticket(long id) {
		return ticketRepository.findById(id).get();
	}

	public void addNewTicket(Ticket ticket) {
		ticketRepository.save(ticket);
		
	}

	public Ticket UpdateTicket(long id, Ticket T) {
		 T.setId(id);
	        return ticketRepository.save(T);
	}

	public void DeleteTicket(long id) {
	  ticketRepository.deleteById(id);
		
	}
	

}
