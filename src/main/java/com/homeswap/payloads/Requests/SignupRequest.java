package com.homeswap.payloads.Requests;

import java.util.HashSet;
import java.util.Set;

public class SignupRequest {

	private String username;
	private String password;
	private String displayName;
	private String email;
	private Set<String> role;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<String> getRole() {
		return role;
	}

	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	
	
}
