package com.homeswap.payloads.Responses;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.homeswap.models.Address;
import com.homeswap.models.HomeImage;
import com.homeswap.models.Rules;
import com.homeswap.models.Service;
import com.homeswap.models.User;
import com.homeswap.models.Enums.AvailabilityType;

public class homesResponse {

	private Long id;
	private String Name;
	private Long homeUserId;
	private Address homeAddress;
	private boolean Online;
	private Long lat;
	private Long lng;
	private String Description;
	private List<ImageResponse> images;

	private boolean Verified;

	private int Size;

	private int NoOfRooms;

	private int NoBathRooms;

	private int NoSingleBeds;
	
	private int NoOfDoubleBeds;

	private int NoOfBabyBeds;

	private int NoOfCribs;

	private Date AvalibleFrom;
	private Date AvailableTo;
	
	private AvailabilityType AvailType;
	
	private Collection<Service>Services;
	
	private Collection<Rules>rules;
	
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

	public Long getHomeUser() {
		return homeUserId;
	}

	public void setHomeUser(Long homeUser) {
		this.homeUserId = homeUser;
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

	public List<ImageResponse> getImages() {
		return images;
	}

	public void setImages(List<ImageResponse> images) {
		this.images = images;
	}

	public Long getLat() {
		return lat;
	}

	public void setLat(Long lat) {
		this.lat = lat;
	}

	public Long getLng() {
		return lng;
	}

	public void setLng(Long lng) {
		this.lng = lng;
	}


	
	
}
