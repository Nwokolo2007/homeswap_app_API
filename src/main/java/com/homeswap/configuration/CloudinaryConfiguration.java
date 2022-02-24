package com.homeswap.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;

public class CloudinaryConfiguration {

	
	@Bean
	public Cloudinary cloudinaryConfig() {
	    Cloudinary cloudinary = null;
	    Map config = new HashMap();
	    config.put("cloud_name", "flabeblast");
	    config.put("api_key", "643527445346692");
	    config.put("api_secret", "VM-pnn7X58fVNwUbFGVE8_BCydo");
	    cloudinary = new Cloudinary(config);
	    return cloudinary;
	}
}

