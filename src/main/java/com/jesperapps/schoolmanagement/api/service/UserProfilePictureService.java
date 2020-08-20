package com.jesperapps.schoolmanagement.api.service;


import com.jesperapps.schoolmanagement.api.message.Attachment;
import com.jesperapps.schoolmanagement.api.model.UserProfilePicture;

public interface UserProfilePictureService{
    UserProfilePicture saveFile(Attachment userProfilePicture);
}