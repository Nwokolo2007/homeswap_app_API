package com.homeswap.web.controllers;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeswap.models.Role;
import com.homeswap.models.User;
import com.homeswap.models.Enums.ERole;
import com.homeswap.payloads.Responses.JwtResponse;
import com.homeswap.payloads.Responses.MessageResponse;
import com.homeswap.payloads.Requests.*;
import com.homeswap.repositories.*;
import com.homeswap.security.jwt.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/validation")


public class AuthController {
	
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepo userRepository;
	
	@Autowired
	HomeRepo homeRepo;

	@Autowired
	RoleRepo roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PreAuthorize("permitAll()")  
	@PostMapping("/signin")
	
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		
		User user = userRepository.findByUsername(loginRequest.getEmail()).get();
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
				                                 user.getId(), 
												 user.getEmail(), 
				                                    "",
												 roles,user.getProfilePhotoUrl(), user.getDisplayName()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User( signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()), signUpRequest.getDisplayName());

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		user = userRepository.save(user);
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signUpRequest.getEmail(), signUpRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);	
		List<String> userRoles = new ArrayList<String>();
		userRoles.add("USER");
			
		
		return ResponseEntity.ok(new JwtResponse(jwt, 
                user.getId(), 
				 user.getEmail(), 
                   "",
                   userRoles,user.getProfilePhotoUrl(), user.getDisplayName()));

	}
	
	
	
	
}