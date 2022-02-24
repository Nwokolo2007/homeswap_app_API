package com.homeswap.models;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;



@Entity

@Table(name ="user",
uniqueConstraints = {
		
		@UniqueConstraint(columnNames = "email")
})

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private String profilePhotoUrl;
	
	private String displayName;
	
	
	@NotBlank
	@Size(max = 50)
	private String username;
	@NotBlank
	@Size(max = 50)
	private String email;
	
	@NotBlank
	@Size(max = 120)
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	
	private Set<Role> roles =  new HashSet<>();
	
	
   @OneToMany(mappedBy = "homeUser")
   
   private Collection<Home>homes;
	
	
	public User()
	{
		
	}
	
	public User(String email, String password,String displayName)
	{
		this.username =  email;
		this.email =  email;
		this.password =  password;
		this.displayName = displayName;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getProfilePhotoUrl() {
		return profilePhotoUrl;
	}

	public void setProfilePhotoUrl(String profilePhotoUrl) {
		this.profilePhotoUrl = profilePhotoUrl;
	}

	public Collection<Home> getHomes() {
		return homes;
	}

	public void setHomes(Collection<Home> homes) {
		this.homes = homes;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	
	
	
	
	
	
}
