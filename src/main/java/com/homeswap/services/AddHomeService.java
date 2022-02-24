package com.homeswap.services;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.homeswap.models.Address;
import com.homeswap.models.Home;
import com.homeswap.models.HomeImage;
import com.homeswap.models.Rules;
import com.homeswap.models.User;
import com.homeswap.payloads.Requests.homeuploadReq;
import com.homeswap.payloads.Responses.ImageResponse;
import com.homeswap.payloads.Responses.homesResponse;
import com.homeswap.repositories.AddressRepo;
import com.homeswap.repositories.HomeImageRepo;
import com.homeswap.repositories.HomeRepo;
import com.homeswap.repositories.RulesRepo;
import com.homeswap.repositories.ServicesRepo;
import com.homeswap.repositories.UserRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Service
public class AddHomeService {

	
	@Autowired
	HomeRepo homeRepo;
	
	@Autowired
	HomeImageRepo homeImageRepo;
	
	@Autowired
	ServicesRepo serviceRepo;
	
	@Autowired
	RulesRepo rulesRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AddressRepo addressRepo;
	
	//C:\\PersonalProjects\\JavaProjects\\HomeExchangeProject\\homeimages    C:\PersonalProjects\JavaProjects\HomeExchangeProject\src\main\resources\homeimages
    public final String storageDirectoryPath =  "C:\\images";// "C:\\Users\\Ahmed\\Desktop\\mediumImages";
    public ResponseEntity<?> uploadToLocalFileSystem(MultipartFile file, Long homeId) {
        /* we will extract the file name (with extension) from the given file to store it in our local machine for now
        and later in virtual machine when we'll deploy the project
         */
    	
    	Home home =  homeRepo.findById(homeId).get();
    	if(home == null)
    	{
    		//validation here and return
    	}
    	/*for(MultipartFile file : files)
    	{*/
    		 String fileName = StringUtils.cleanPath(file.getOriginalFilename());

    	        /* The Path in which we will store our image . we could change it later
    	        based on the OS of the virtual machine in which we will deploy the project.
    	        In my case i'm using windows 10 .
    	         */
    	        Path storageDirectory = Paths.get(storageDirectoryPath);
    	        /*
    	        * we'll do just a simple verification to check if the folder in which we will store our images exists or not
    	        * */
    	        if(!Files.exists(storageDirectory)){ // if the folder does not exist
    	            try {
    	                Files.createDirectories(storageDirectory); // we create the directory in the given storage directory path
    	            }catch (Exception e){
    	                e.printStackTrace();// print the exception
    	            }
    	        }

    	        Path destination = Paths.get(storageDirectory.toString() + "\\" + fileName);

    	        try {
    	            Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);// we are Copying all bytes from an input stream to a file

    	        } catch (IOException e) {
    	            e.printStackTrace();
    	        }
    	        // the response will be the download URL of the image
    	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
    	                .path(fileName)
    	                .toUriString();
    	        HomeImage  image = new HomeImage();
    	        image.setImageUrl(fileDownloadUri);
    	        image.setHome(home);
    	       image =   homeImageRepo.save(image);
    	       
    	       ImageResponse responseImage = new ImageResponse();
    	       
    	       responseImage.setHomeId(homeId);
    	       responseImage.setImageId(image.getId());
    	       responseImage.setImageUrl(fileDownloadUri);
        
          return ResponseEntity.ok(responseImage);
    }

    public  byte[] getImageWithMediaType(String imageName) throws IOException {
        Path destination =   Paths.get(storageDirectoryPath+"\\"+imageName);// retrieve the image by its name
        
        return IOUtils.toByteArray(destination.toUri());
    }
    
    
    

	public ResponseEntity<?> addExchangeHome(homeuploadReq request) {
	
		boolean isValid =  false;
		Home home =  new Home();
		homesResponse homeResp  = new homesResponse();
		String response = "";
		
		if(request.getAddress().equals(""))
		{
		  response = "Address is requred";
		  isValid = false;
		}
		else if(request.getServices().isEmpty())
		{
			response = "Kindly add available services";
			isValid =  false;
		}
		else if(request.getLocation() == null)
		{
			response = "Add location data";
			isValid =  false;
		}
		else 
		{
			
			isValid =  true;
		}
		
		if(!isValid)
		{
			return ResponseEntity.ok(response);
		}
		
		try 
		{
			Collection<com.homeswap.models.Service>services =  new ArrayList<com.homeswap.models.Service>();
			
			home.setServices(services);
			

			Collection<Rules> rules =  new ArrayList<Rules>();
			
			home.setRules(rules);
			
			for(com.homeswap.models.Service service:request.getServices())
			{
				service = serviceRepo.findById(service.getId()).get();
				
				home.getServices().add(service);
			}
			

			for(Rules rule:request.getRules())
			{
				rule = rulesRepo.findById(rule.getId()).get();
				home.getRules().add(rule);
			}
			
			User user = userRepo.findById(request.getUserId()).get();
			
			if(user == null)
			{
				// handle error here;
			}
			
			
			  Address homeAddress = new Address();
			  homeAddress.setCountry(request.getCountry());
			  homeAddress.setLat(request.getLocation().getLat());
			  homeAddress.setLng(request.getLocation().getLongitude());
			  homeAddress.setStreetName(request.getStreet());
			  homeAddress.setCity(request.getCity());
			  homeAddress.setZipCode(request.getZipCode());
			  
			  homeAddress =  addressRepo.save(homeAddress);
			  
			home.setDescription(request.getDescription());
			home.setHomeAddress(homeAddress);
			home.setAvailableTo(request.getAvailability().getStartDate());
			home.setAvalibleFrom(request.getAvailability().getStartDate());
			home.setNoBathRooms(request.getNoBathRooms());
			home.setNoOfDoubleBeds(request.getNoOfDoubleBeds());
			home.setNoOfBabyBeds(request.getNoOfBabyBeds());
			home.setNoOfCribs(request.getNoOfCribs());
			home.setNoOfRooms(request.getNoOfRooms());
			home.setNoSingleBeds(request.getNoSingleBeds());
			home.setHomeUser(user);
			
			home = homeRepo.save(home);

			homeResp.setHomeUser(user.getId());
			homeResp.setId(home.getId());
			homeResp.setServices(services);
			homeResp.setRules(rules);
			
			
		}
		catch(Exception ex)
		{
			response = "An exception occured during processing error =>" + ex.getMessage();
		}
		
		return ResponseEntity.ok(homeResp);
	}

	
	public ResponseEntity<?> getPaginatedHome(int pageSize, int pageLimit)
	{
		List<Home>homes = homeRepo.findHomes(1,8);
		List<homesResponse>homeR = new ArrayList<homesResponse>();
		
		
		for(int i =0;i<homes.size();i++)
		{
			
			
			Home home = homes.get(i);
			homesResponse homeResp = new homesResponse();
			homeResp.setServices(home.getServices());
			homeResp.setDescription(home.getDescription());
			homeResp.setHomeUser(home.getHomeUser().getId());
			homeResp.setRules(home.getRules());
			homeResp.setDescription(home.getDescription());
			homeResp.setName(home.getHomeUser().getDisplayName());
			homeResp.setLat(home.getHomeAddress().getLat());
			
			homeResp.setLng(home.getHomeAddress().getLng());
			
			homeResp.setId(home.getId());
		
			
			Collection<HomeImage> homeImages = home.getHomeImages();
			int count = 0;
			List<ImageResponse>images =  new ArrayList<ImageResponse>();
			for(HomeImage img:homeImages)
			{
				
				if(count == 3)break;
				
				ImageResponse image = new ImageResponse();
				image.setImageUrl(img.getImageUrl());
				images.add(image);
				count +=1;
			}
			homeResp.setImages(images);
			homeR.add(homeResp);
		}
		return ResponseEntity.ok(homeR);
	}
	
	
}

class uploadImageResponse{
	
	private  String imageUrl ;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
}
