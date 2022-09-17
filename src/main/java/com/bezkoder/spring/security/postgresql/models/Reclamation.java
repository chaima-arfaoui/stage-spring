package com.bezkoder.spring.security.postgresql.models;
import javax.persistence.EnumType;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Data
@AllArgsConstructor
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)

public class Reclamation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public String country;
	public String message;
	public String category ;
	@Column(nullable = false)
	//@NotBlank
	@Enumerated(EnumType.STRING)
	private RecRole type;
	@CreatedBy
	private Long user_id ;
	
	

	public Reclamation() {
		super();
	}

	public Reclamation(String country, String message, RecRole type, Long user_id) {
		super();
		this.country = country;
		this.message = message;
		this.type = type;
		this.user_id = user_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public RecRole getType() {
		return type;
	}

	public void setType(RecRole type) {
		this.type = type;
	}

	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;

	}
	

}
