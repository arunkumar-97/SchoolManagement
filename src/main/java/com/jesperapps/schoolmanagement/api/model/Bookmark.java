package com.jesperapps.schoolmanagement.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jesperapps.schoolmanagement.api.modelmessage.BookmarkRequestEntity;

@Entity
public class Bookmark extends AbstractAuditingEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookmarkId;

	@Column
    private String filename;

	@ManyToOne
	@JoinColumn(name="userId", referencedColumnName="userId")
	private User user;
	
	public Bookmark() {
		
		
	}

	
	public Bookmark(BookmarkRequestEntity  bookmarkRequestEntity) {
		
		this.bookmarkId = bookmarkRequestEntity.getBookmarkId();
		this.filename = bookmarkRequestEntity.getFilename();
		this.setUser(bookmarkRequestEntity.getUser());
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
		return "Bookmark [bookmarkId=" + bookmarkId + ", filename=" + filename + ", user=" + user + "]";
	}


		
		
	
}
