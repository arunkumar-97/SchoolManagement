package com.jesperapps.schoolmanagement.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.model.Bookmark;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.modelmessage.BookmarkResponseEntity;


public interface BookmarkService {

	Bookmark createbookmark(Bookmark bookmark);

	List<Bookmark> findAll();

	List<Bookmark> findByUser(User userFromDb);

	Bookmark findById(int bookmarkId);

	

}
