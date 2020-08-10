package com.jesperapps.schoolmanagement.api.service;

import org.springframework.stereotype.Service;
import com.jesperapps.schoolmanagement.api.model.UserProfilePicture;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ServiceImplementationUserProfilePicture implements UserProfilePictureService{

    private final String LOCATION = "E:\\SchoolManagementUserProfilePicture";

    private boolean saveRequestFile(MultipartFile file){
        try{
            if(Files.notExists(Paths.get(LOCATION))){
                File directoryFile = new File(LOCATION);
                if(directoryFile.mkdir()){
                    //directory created successfully;
                }else{
                    //error creating directory
                }
            }
            if(file.getOriginalFilename() != ""){
                file.transferTo(Paths.get(LOCATION + "\\"+ file.getOriginalFilename()));
            }
            else{
                return false;
            }
        }catch(Exception e){
            // System.out.println(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public UserProfilePicture saveFile(MultipartFile profilePicture){
        UserProfilePicture userProfilePicture = new UserProfilePicture();
        if(this.saveRequestFile(profilePicture)){
            userProfilePicture.setPictureName(profilePicture.getOriginalFilename());
            userProfilePicture.setPictureLocation(LOCATION+"\\"+profilePicture.getOriginalFilename());
            return userProfilePicture;
        }
        return null;
    }
}