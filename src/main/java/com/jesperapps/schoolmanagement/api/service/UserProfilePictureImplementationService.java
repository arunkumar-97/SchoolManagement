package com.jesperapps.schoolmanagement.api.service;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.message.Attachment;
import com.jesperapps.schoolmanagement.api.model.UserProfilePicture;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;


@Service
public class UserProfilePictureImplementationService implements UserProfilePictureService{

    private final String LOCATION = "E:\\SchoolManagementUserProfilePicture";

    private boolean saveRequestFile(String name, String bytes){
        try{
            if(Files.notExists(Paths.get(LOCATION))){
                File directoryFile = new File(LOCATION);
                if(directoryFile.mkdir()){
                    //directory created successfully;
                }else{
                    //error creating directory
                }
            }
            if(name != ""){
                File newProfilePicture = new File(LOCATION + "\\"+ name);
				OutputStream buffer = new FileOutputStream(newProfilePicture);
				buffer.write(Base64.decodeBase64(bytes));
				buffer.close();
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
    public UserProfilePicture saveFile(Attachment profilePicture){
        UserProfilePicture userProfilePicture = new UserProfilePicture();
        if(this.saveRequestFile(profilePicture.getName(), profilePicture.getFileByte())){
            userProfilePicture.setPictureName(profilePicture.getName());
            userProfilePicture.setPictureLocation(LOCATION+"\\"+profilePicture.getName());
            return userProfilePicture;
        }
        return null;
    }
}