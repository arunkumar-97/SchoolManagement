package com.jesperapps.schoolmanagement.api.service;


import com.jesperapps.schoolmanagement.api.model.Attachment;
import com.jesperapps.schoolmanagement.api.model.TopicAttachment;
import com.jesperapps.schoolmanagement.api.model.UserProfilePicture;

public interface UserProfilePictureService{
	
	static final String BASE_URL = "/userprofile";
	
    UserProfilePicture saveFile(Attachment userProfilePicture);

    UserProfilePicture getByPictureId(Integer pictureId);

	long getFileSize(String pictureName);

	byte[] getFileBytes(String pictureName);
}