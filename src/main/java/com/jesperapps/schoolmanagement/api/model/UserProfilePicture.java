package com.jesperapps.schoolmanagement.api.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserProfilePicture{
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pictureId;
    private String pictureName;
    private String pictureLocation;
    @OneToOne(mappedBy="userProfile", cascade=CascadeType.ALL)
    private User user;

    public Integer getPictureId(){
        return this.pictureId;
    }
    public String getPictureName(){
        return pictureName;
    }
    public void setPictureName(String pictureName){
        this.pictureName = pictureName;
    }
    public String getPictureLocation(){
        return this.pictureLocation;
    }
    public void setPictureLocation(String pictureLocation){
        this.pictureLocation = pictureLocation;
    }
    public User getUser(){
        return this.user;
    }
    public void setUser(User user){
        this.user = user;
    }
}