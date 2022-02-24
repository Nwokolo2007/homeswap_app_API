package com.homeswap.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.utils.ObjectUtils;
import com.homeswap.configuration.CloudinaryConfiguration;
import com.homeswap.models.User;

public class CloudinaryGifService {
	
    @Autowired
	CloudinaryConfiguration cloudinaryConfig;
	
    @Bean
    public String uploadFile(MultipartFile gif) {
        try {
            File uploadedFile = convertMultiPartToFile(gif);
            Map uploadResult = cloudinaryConfig.cloudinaryConfig().uploader().uploadLarge(uploadedFile, ObjectUtils.emptyMap());
            boolean isDeleted = uploadedFile.delete();

            if (isDeleted){
               System.out.println("File successfully deleted");
            }else
                System.out.println("File doesn't exist");
            return  uploadResult.get("url").toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
	    File convFile = new File(file.getOriginalFilename());
	    FileOutputStream fos = new FileOutputStream(convFile);
	    fos.write(file.getBytes());
	    fos.close();
	    return convFile;
	}

	public void saveGifToDB(String url, String title, Optional<User> currentUser) {
		// TODO Auto-generated method stub
		
	}

	

	public LinkedHashMap<String, Object> modifyJsonResponse(String string, String url) {
		// TODO Auto-generated method stub
		return null;
	}


}
