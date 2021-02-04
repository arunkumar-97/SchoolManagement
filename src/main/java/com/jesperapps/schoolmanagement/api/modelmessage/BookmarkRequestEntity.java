package com.jesperapps.schoolmanagement.api.modelmessage;

import javax.persistence.Column;
import javax.persistence.Id;

import com.jesperapps.schoolmanagement.api.model.User;

public class BookmarkRequestEntity {


	private Integer bookmarkId;
    private String filename;
    private User user;
    
    
    public BookmarkRequestEntity() {
		super();
	}
    

	public Integer getBookmarkId() {
		return bookmarkId;
	}

	public void setBookmarkId(Integer bookmarkId) {
		this.bookmarkId = bookmarkId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Bookmark [bookmarkId=" + bookmarkId + ", filename=" + filename + "]";
	}

	
		
	
}
