package com.homeswap.web.controllers;

import java.util.Collection;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeswap.models.Home;
import com.homeswap.models.Rules;
import com.homeswap.models.Service;
import com.homeswap.payloads.Requests.homeDetailsRequest;
import com.homeswap.repositories.HomeRepo;
import com.homeswap.repositories.ServicesRepo;

@RestController
@RequestMapping(path = "/api/services")
public class HomeServicesController {

	@Autowired
	ServicesRepo servicesRepo;

	@Autowired
	HomeRepo homeRepo;

	@PreAuthorize("permitAll()")
	@PostMapping("/all")

	public ResponseEntity<List<Service>> getAllServices() {
		List<Service> allAppServices = servicesRepo.findAll();
		return ResponseEntity.ok(allAppServices);
	}

	
	  @PostMapping("/homeServices") 
	  public ResponseEntity<?> getServicesByHome(@Valid @RequestBody homeDetailsRequest home)
	  {
		   Home userHome = homeRepo.findById(home.getId()); 
		   Collection<Service>homeServices = userHome.getServices();
		   return ResponseEntity.ok(homeServices); 
	   
	  }
	 
		
		  @PostMapping("/homeRules")
		  public ResponseEntity<?>getHomeRules(@Valid @RequestBody homeDetailsRequest  home) 
		  {
			  Home userHome = homeRepo.findById(home.getId());
			 Collection<Rules> homeRules =  userHome.getRules();
			 return ResponseEntity.ok(homeRules);
		 
		 }
		 
	 

}
