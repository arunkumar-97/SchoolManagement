package com.jesperapps.schoolmanagement.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.model.Bookmark;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.modelmessage.BookmarkResponseEntity;
import com.jesperapps.schoolmanagement.api.repository.BookmarkRepository;

@Service
public class BookmarkImplementationService  implements  BookmarkService {

	@Autowired
	 private BookmarkRepository bookmarkRepository;

	@Override
	public Bookmark createbookmark(Bookmark bookmark) {
		return bookmarkRepository.save(bookmark);
	}

	@Override
	public List<Bookmark> findAll() {
		// TODO Auto-generated method stub
		return bookmarkRepository.findAll();
	}

	@Override
	public List<Bookmark> findByUser(User userFromDb) {
		// TODO Auto-generated method stub
		return bookmarkRepository.findByUser(userFromDb);
	}

	@Override
	public Bookmark findById(int bookmarkId) {
		// TODO Auto-generated method stub
		return bookmarkRepository.findByBookmarkId(bookmarkId);
	}

	@Override
	public void deleteBookmark(Bookmark cls) {
		// TODO Auto-generated method stub
		bookmarkRepository.delete(cls);
	}

	
	
}
