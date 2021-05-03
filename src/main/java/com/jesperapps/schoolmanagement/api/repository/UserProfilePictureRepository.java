package com.jesperapps.schoolmanagement.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.UserProfilePicture;
public interface UserProfilePictureRepository extends JpaRepository<UserProfilePicture, Integer>
{

	UserProfilePicture findByPictureId(Integer pictureId);

}