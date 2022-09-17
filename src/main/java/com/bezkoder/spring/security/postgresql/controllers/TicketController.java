package com.bezkoder.spring.security.postgresql.controllers;

import java.util.List;

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

import com.bezkoder.spring.security.postgresql.models.Ticket;
import com.bezkoder.spring.security.postgresql.security.services.TicketService;
@CrossOrigin("*")
@RequestMapping("/api/tickets")

@RestController  
public class TicketController {
	
	 
	    @Autowired
	    private TicketService ticketservice;
	    
	    @GetMapping(value = "/ticket")
	    private List<Ticket> tickliste(){
	        return ticketservice.getticket();
	    }
	    @GetMapping(value = "/ticket/{id}")
	    private Ticket getticket(@PathVariable(name = "id")long id){
	        return ticketservice.getticket(id);}
	    
	    @PostMapping("/addticket")
	    public void addNewTicket(@RequestBody Ticket ticket){
	        ticketservice.addNewTicket(ticket);
	    }
	    
	    @PutMapping("/ticket/{id}")
	    public Ticket UpdateTickets(@PathVariable(name = "id")long id, @RequestBody Ticket T){
	        return ticketservice.UpdateTicket(id,T);
	    }
	    @DeleteMapping("/ticket/{id}")
	    public void DeleteTicket(@PathVariable(name = "id")long id){
	        ticketservice.DeleteTicket(id);
	    }
	    
}