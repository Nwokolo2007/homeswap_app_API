package com.homeswap.web.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.homeswap.models.Home;
import com.homeswap.models.Rules;
import com.homeswap.payloads.Requests.homeuploadReq;
import com.homeswap.repositories.HomeRepo;
import com.homeswap.repositories.RulesRepo;
import com.homeswap.repositories.UserRepo;
import com.homeswap.services.AddHomeService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/api/home", method = RequestMethod.POST)
public class HomeExchangeController {

	@Autowired
	UserRepo userService;
	
	@Autowired
	HomeRepo homeRepo;
	
	@Autowired AddHomeService addhomeService;
	
	@PreAuthorize("permitAll()")  
	@PostMapping("/AddExchangeHome")
	public ResponseEntity<?>uploadHome(@Valid @RequestBody homeuploadReq request) throws IOException
	{
		return addhomeService.addExchangeHome(request);
	}
	
	@PostMapping("/UploadImage")
	  public ResponseEntity<?> uploadToLocalFileSystem(@RequestParam("file")MultipartFile file,@RequestParam("homeId")Long homeId)
	  {
		return addhomeService.uploadToLocalFileSystem(file,homeId);
	  }
	
	

	
	@PreAuthorize("permitAll()")  
	@PostMapping("/allHomes")
	
	public ResponseEntity<?> getAllHomes()
	{
		return addhomeService.getPaginatedHome(1, 8);
	}
	
	
	
}
