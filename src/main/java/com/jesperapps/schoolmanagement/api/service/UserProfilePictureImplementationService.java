package com.jesperapps.schoolmanagement.api.service;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.model.Attachment;
import com.jesperapps.schoolmanagement.api.model.TopicAttachment;
import com.jesperapps.schoolmanagement.api.model.UserProfilePicture;
import com.jesperapps.schoolmanagement.api.repository.UserProfilePictureRepository;
import com.jesperapps.schoolmanagement.api.utils.StorageUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


@Service
public class UserProfilePictureImplementationService implements UserProfilePictureService{

//  private final String LOCATION = StorageUtils.getFolderLocation("profile_pictures");
    
  
  private static final String LOCATION = StorageUtils.getFolderLocation("profile_pictures");
//    private final String LOCATION ="C:\\Users\\Admin\\UserProfilePicture";
  
  @Autowired
  private UserProfilePictureService userService;
  
  @Autowired
  private UserProfilePictureRepository pictureRepository;

    private boolean saveRequestFile(String name, String bytes){
        try{
        	System.out.println("try");
            if(Files.notExists(Paths.get(LOCATION))){
                File directoryFile = new File(LOCATION);
                if(directoryFile.mkdir()){
                    //directory created successfully;
                }else{
                    //error creating directory
                	System.out.println("else try");
                }
            }
            if(name != ""){
            	System.out.println("if");
                File newProfilePicture = new File(LOCATION + name);
				OutputStream buffer = new FileOutputStream(newProfilePicture);
				buffer.write(Base64.decodeBase64(bytes));
				buffer.close();
            }
            else{
            	System.out.println("else if");
                return false;
            }
        }catch(Exception e){
        	System.out.println("catch");
        	System.out.println(e.getMessage());
        	System.out.println(e.getLocalizedMessage());
            return false;
        }
        return true;
    }

    @Override
    public UserProfilePicture saveFile(Attachment profilePicture){

    	UserProfilePicture userProfilePicture = new UserProfilePicture();
    	System.out.println("ProfileAttachment Name" + profilePicture.getAttachmentName());
    	System.out.println("ProfileAttachment FileByte" + profilePicture.getFileByte());

        if(this.saveRequestFile(profilePicture.getAttachmentName(),profilePicture.getFileByte())){
        	
        	System.out.println("ProfileAttachment Name" + profilePicture.getAttachmentName());
                    userProfilePicture.setPictureName(profilePicture.getAttachmentName());
//                    System.out.println("profile Id" + userProfilePicture.getPictureId());
            userProfilePicture.setPictureLocation(LOCATION +profilePicture.getAttachmentName());
      
            return userProfilePicture;
        }
        return null;
    }

	@Override
	public UserProfilePicture getByPictureId(Integer pictureId) {
		// TODO Auto-generated method stub
	return this.pictureRepository.findByPictureId(pictureId);
	}

	@Override
	public long getFileSize(String pictureName) {
		@SuppressWarnings("static-access")
		File requestedFile = new File(this.LOCATION+pictureName);
		if(requestedFile.exists()) {		
			return requestedFile.length();
		}
		return 0L;
	}
	

	@Override
	public byte[] getFileBytes(String pictureName) {
		try {
			System.out.println("Location " + LOCATION);
			return Files.readAllBytes(Paths.get(LOCATION+pictureName));
		}catch(IOException e) {
		}
		return new byte[] {};
	}
}