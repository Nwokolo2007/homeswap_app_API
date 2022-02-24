package com.homeswap.web.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeswap.models.Rules;
import com.homeswap.repositories.HomeRepo;
import com.homeswap.repositories.RulesRepo;
@RestController
@RequestMapping(path = "/api/homeRules")

public class LifeStylesController {

	
	
	@Autowired
	RulesRepo homeRulesRepo;
	
	@Autowired
	HomeRepo homeRepo;
	
	@PreAuthorize("permitAll()")  
	@PostMapping("/allLifeStyles")
	
	public ResponseEntity<List<Rules>> getAllRules()
	{
		 List<Rules> allLifeStyles = homeRulesRepo.findAll();
		 return ResponseEntity.ok(allLifeStyles);
	}
	/*
	 * @PostMapping("/homeServices") public ResponseEntity<List<LifeStyle>>
	 * getServicesByHomeId(@Valid @RequestBody Home home) {
	 * List<LifeStyle>homeLifeStyles = homeRulesRepo.findByhomeId(home.getId());
	 * return ResponseEntity.ok(homeLifeStyles); }
	 */
	
}
