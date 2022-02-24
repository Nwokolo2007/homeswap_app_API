package com.homeswap.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String City;
	
	@Column
	private Long Lng;
	
	@Column
	private Long Lat;
	
	@Column(length = 100)
	private String StreetName;
	
	@Column
	private Long ZipCode;
	
	@Column(length =100)
	private String Region;
	
	
	@Column(length = 100)
	private String Country;
	
	@OneToOne
	@JoinColumn(name = "Id")
	private Home home;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getLng() {
		return Lng;
	}

	public void setLng(Long lng) {
		Lng = lng;
	}

	public Long getLat() {
		return Lat;
	}

	public void setLat(Long lat) {
		Lat = lat;
	}

	public String getStreetName() {
		return StreetName;
	}

	public void setStreetName(String streetName) {
		StreetName = streetName;
	}

	public Long getZipCode() {
		return ZipCode;
	}

	public void setZipCode(Long zipCode) {
		ZipCode = zipCode;
	}

	public String getRegion() {
		return Region;
	}

	public void setRegion(String region) {
		Region = region;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}
	
	

}
