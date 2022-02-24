package com.homeswap.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Service {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	@Column(length =100)
	private String Name;
	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	

	
	
}
