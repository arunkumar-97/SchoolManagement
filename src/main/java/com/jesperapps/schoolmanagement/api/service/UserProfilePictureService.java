package com.jesperapps.schoolmanagement.api.service;


import org.springframework.web.multipart.MultipartFile;

import com.jesperapps.schoolmanagement.api.model.UserProfilePicture;

public interface UserProfilePictureService{
    UserProfilePicture saveFile(MultipartFile userProfilePicture);
}