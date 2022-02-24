package com.homeswap.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.homeswap.models.Enums.AvailabilityType;

@Entity
public class Home {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Name")
	private String Name;
	
	@ManyToOne
	private User homeUser;
	
	@OneToOne
	private Address homeAddress;
	
	@Column(name = "Online")
	private boolean Online;
	
	@Column
	private String Description;
	@Column
	private boolean Verified;
	@Column
	private int Size;
	@Column
	private int NoOfRooms;
	@Column
	private int NoBathRooms;
	@Column
	private int NoSingleBeds;
	@Column
	private int NoOfDoubleBeds;
	@Column
	private int NoOfBabyBeds;
	@Column
	private int NoOfCribs;
	@Column
	private Date AvalibleFrom;
	@Column
	private Date AvailableTo;
	@Column
	private AvailabilityType AvailType;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "home_services", 
				joinColumns = @JoinColumn(name = "homeId"), 
				inverseJoinColumns = @JoinColumn(name = "serviceId"))
	private Collection<Service>Services;
	
	
	@ManyToMany(fetch =  FetchType.LAZY)
	@JoinTable(name = "home_rules",
	
				joinColumns = @JoinColumn(name = "homeId"),
				inverseJoinColumns = @JoinColumn(name = "ruleId"))
	private Collection<Rules>rules;
	
	
	
	@OneToMany(mappedBy = "home")
	private Collection <HomeImage>HomeImages;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public User getHomeUser() {
		return homeUser;
	}

	public void setHomeUser(User homeUser) {
		this.homeUser = homeUser;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public boolean isOnline() {
		return Online;
	}

	public void setOnline(boolean online) {
		this.Online = online;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		this.Description = description;
	}

	public boolean isVerified() {
		return Verified;
	}

	public void setVerified(boolean verified) {
		this.Verified = verified;
	}

	public int getSize() {
		return Size;
	}

	public void setSize(int size) {
		this.Size = size;
	}

	public int getNoOfRooms() {
		return NoOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.NoOfRooms = noOfRooms;
	}

	public int getNoBathRooms() {
		return NoBathRooms;
	}

	public void setNoBathRooms(int noBathRooms) {
		this.NoBathRooms = noBathRooms;
	}

	public int getNoSingleBeds() {
		return NoSingleBeds;
	}

	public void setNoSingleBeds(int noSingleBeds) {
		this.NoSingleBeds = noSingleBeds;
	}

	public int getNoOfDoubleBeds() {
		return NoOfDoubleBeds;
	}

	public void setNoOfDoubleBeds(int nonOfDoubleBeds) {
		this.NoOfDoubleBeds = nonOfDoubleBeds;
	}

	public int getNoOfBabyBeds() {
		return NoOfBabyBeds;
	}

	public void setNoOfBabyBeds(int noOfBabyBeds) {
		this.NoOfBabyBeds = noOfBabyBeds;
	}

	public int getNoOfCribs() {
		return NoOfCribs;
	}

	public void setNoOfCribs(int noOfCribs) {
		this.NoOfCribs = noOfCribs;
	}

	public Date getAvalibleFrom() {
		return AvalibleFrom;
	}

	public void setAvalibleFrom(Date avalibleFrom) {
		this.AvalibleFrom = avalibleFrom;
	}

	public Date getAvailableTo() {
		return AvailableTo;
	}

	public void setAvailableTo(Date availableTo) {
		this.AvailableTo = availableTo;
	}

	public AvailabilityType getAvailType() {
		return AvailType;
	}

	public void setAvailType(AvailabilityType availType) {
		AvailType = availType;
	}

	public Collection<Service> getServices() {
		return Services;
	}

	public void setServices(Collection<Service> services) {
		this.Services = services;
	}

	public Collection<Rules> getRules() {
		return rules;
	}

	public void setRules(Collection<Rules> rules) {
		this.rules = rules;
	}

	public Collection<HomeImage> getHomeImages() {
		return HomeImages;
	}

	public void setHomeImages(Collection<HomeImage> homeImages) {
		this.HomeImages = homeImages;
	}


	
	

	
	

	
	
}
