package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.Bookmark;
import com.jesperapps.schoolmanagement.api.model.User;

public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {

	List<Bookmark> findByUser(User userFromDb);

	Bookmark findByBookmarkId(int bookmarkId);

}
