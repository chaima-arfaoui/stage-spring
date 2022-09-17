package com.bezkoder.spring.security.postgresql.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.security.postgresql.models.Ticket;

public interface TicketRepository  extends JpaRepository<Ticket,Long> {

	Optional<Ticket> findById(long id);



}
