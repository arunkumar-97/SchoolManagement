package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import com.jesperapps.schoolmanagement.api.model.UserProfilePicture;

public interface UserProfilePictureService{
    UserProfilePicture saveFile(MultipartFile userProfilePicture);
}