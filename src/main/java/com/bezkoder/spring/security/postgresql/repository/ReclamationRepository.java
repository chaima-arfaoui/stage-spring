package com.bezkoder.spring.security.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.security.postgresql.models.Reclamation;


public interface ReclamationRepository extends JpaRepository<Reclamation,Long> {

}
