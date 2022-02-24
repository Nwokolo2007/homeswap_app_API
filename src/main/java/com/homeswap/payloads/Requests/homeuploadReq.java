package com.homeswap.payloads.Requests;

import java.util.Collection;
import com.homeswap.models.Rules;
import com.homeswap.models.Service;

public class homeuploadReq {
	
	private Long zipCode;
	private Collection<Service> services;
	private Collection<Rules>rules;
	private String address;
	private Long userId;
	private String city;
	private String country;
	private boolean online;
	private int size;
	private int noOfRooms;
	private int noBathRooms;
	private int noSingleBeds;
	private int noOfDoubleBeds;
	private int noOfBabyBeds;
	private int noOfCribs;
	private Location location;
	private String description;
	private String street;
	private Availability availability;
	public Long getZipCode() {
		return zipCode;
	}
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}
	public Collection<Service> getServices() {
		return services;
	}
	public void setServices(Collection<Service> services) {
		this.services = services;
	}
	public Collection<Rules> getRules() {
		return rules;
	}
	public void setRules(Collection<Rules> rules) {
		this.rules = rules;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean isOnline() {
		return online;
	}
	public void setOnline(boolean online) {
		this.online = online;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getNoOfRooms() {
		return noOfRooms;
	}
	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	public int getNoBathRooms() {
		return noBathRooms;
	}
	public void setNoBathRooms(int noBathRooms) {
		this.noBathRooms = noBathRooms;
	}
	public int getNoSingleBeds() {
		return noSingleBeds;
	}
	public void setNoSingleBeds(int noSingleBeds) {
		this.noSingleBeds = noSingleBeds;
	}
	public int getNoOfDoubleBeds() {
		return noOfDoubleBeds;
	}
	public void setNoOfDoubleBeds(int noOfDoubleBeds) {
		this.noOfDoubleBeds = noOfDoubleBeds;
	}
	public int getNoOfBabyBeds() {
		return noOfBabyBeds;
	}
	public void setNoOfBabyBeds(int noOfBabyBeds) {
		this.noOfBabyBeds = noOfBabyBeds;
	}
	public int getNoOfCribs() {
		return noOfCribs;
	}
	public void setNoOfCribs(int noOfCribs) {
		this.noOfCribs = noOfCribs;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Availability getAvailability() {
		return availability;
	}
	public void setAvailability(Availability availability) {
		this.availability = availability;
	}

	
	
	
	

}



	   