package com.jesperapps.schoolmanagement.api.service;


import com.jesperapps.schoolmanagement.api.model.Attachment;
import com.jesperapps.schoolmanagement.api.model.UserProfilePicture;

public interface UserProfilePictureService{
    UserProfilePicture saveFile(Attachment userProfilePicture);
}