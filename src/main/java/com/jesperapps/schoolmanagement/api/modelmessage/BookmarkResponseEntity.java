package com.jesperapps.schoolmanagement.api.modelmessage;

import com.jesperapps.schoolmanagement.api.message.BaseResponse;
import com.jesperapps.schoolmanagement.api.model.Bookmark;
import com.jesperapps.schoolmanagement.api.model.User;

public class BookmarkResponseEntity extends BaseResponse {

	
	private Integer bookmarkId;
    private String filename;
    private int user;
    
    
    public BookmarkResponseEntity() {
		super();
	}
    

	public BookmarkResponseEntity(Integer bookmarkId2, String filename2, int user2) {
		this.bookmarkId=bookmarkId2;
		this.filename=filename2;
		this.user=user2;
	}


	public BookmarkResponseEntity(Bookmark book) {
		this.bookmarkId=book.getBookmarkId();
		this.filename=book.getFilename();
		this.user=book.getUser().getUserId();
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
	
	

	

	public int getUser() {
		return user;
	}


	public void setUser(int user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Bookmark [bookmarkId=" + bookmarkId + ", filename=" + filename + "]";
	}

}
