package com.homeswap.payloads.Responses;

import java.util.List;

public class JwtResponse {

	
	private String token;
	private String type;
	private Long id;
	private String username;
	private String photoURL;
	private String email;
	private List<String> roles;
	private String displayName;
	private String jwt;
	public JwtResponse(String jwt, Long id, String username, String email, List<String> roles, String photoURL,String displayName) {
		
	this.token =  jwt;
	this.roles = roles;
	this.id = id;
	this.username = username;
	this.email = email;
	this.photoURL =  photoURL;
	this.displayName = displayName;
		// TODO Auto-generated constructor stub
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public String getPhotoURL() {
		return photoURL;
	}
	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	
}
