package com.jesperapps.schoolmanagement.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jesperapps.schoolmanagement.api.message.ClassBaseResponse;
import com.jesperapps.schoolmanagement.api.message.ClassRequest;
import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.message.SubscriptionResponse;
import com.jesperapps.schoolmanagement.api.message.TopicSubscriptionResponse;
import com.jesperapps.schoolmanagement.api.message.YearBaseResponse;
import com.jesperapps.schoolmanagement.api.model.Bookmark;
import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.model.Year;
import com.jesperapps.schoolmanagement.api.modelmessage.BookmarkRequestEntity;
import com.jesperapps.schoolmanagement.api.modelmessage.BookmarkResponseEntity;
import com.jesperapps.schoolmanagement.api.service.AnswerAttachmentService;
import com.jesperapps.schoolmanagement.api.service.AnswerService;
import com.jesperapps.schoolmanagement.api.service.BookmarkService;
import com.jesperapps.schoolmanagement.api.service.UserService;
import com.jesperapps.schoolmanagement.api.utils.StatusClass;
import com.jesperapps.schoolmanagement.api.utils.SubscriptionStatusTag;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BookMarkController {

	@Autowired
	private BookmarkService bookmarkService;

	@Autowired
	private UserService userService;

	@PostMapping("/bookmark")
	public ResponseEntity addbookmark(@RequestBody BookmarkRequestEntity bookmarkRequestEntity) {
		Bookmark bookmark = new Bookmark(bookmarkRequestEntity);
		Bookmark bookmark2 = bookmarkService.createbookmark(bookmark);
		if (bookmark2 != null) {
			BookmarkResponseEntity bookmarkResponseEntity = new BookmarkResponseEntity();
			bookmarkResponseEntity.setStatusCode(200);
			bookmarkResponseEntity.setDescription("BookMark Created Sucessfully");
			return new ResponseEntity(bookmarkResponseEntity, HttpStatus.OK);
		} else {
			BookmarkResponseEntity bookmarkResponseEntity = new BookmarkResponseEntity();
			bookmarkResponseEntity.setStatusCode(409);
			bookmarkResponseEntity.setDescription(" Unable to Create BookMark");
			return new ResponseEntity(bookmarkResponseEntity, HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/bookmark")
	public List<BookmarkResponseEntity> listAllBookmarks() {
		List<BookmarkResponseEntity> res = new ArrayList<>();

		bookmarkService.findAll().forEach(book -> {
			res.add(new BookmarkResponseEntity(book));
		});
		return res;
	}

	@GetMapping("/bookmark/{bookmarkId}")
	public BookmarkResponseEntity viewBookmark(@PathVariable int bookmarkId) {
		Bookmark cls = bookmarkService.findById(bookmarkId);
		BookmarkResponseEntity bookmarkResponse = new BookmarkResponseEntity();
		if (cls != null) {

			bookmarkResponse.setBookmarkId(cls.getBookmarkId());
			bookmarkResponse.setFilename(cls.getFilename());
			bookmarkResponse.setUserId(cls.getUser().getUserId());
//			classResponse.setClassId(cls.getClassId());
//			classResponse.setClassName(cls.getClassName());
//			classResponse.setStatus(cls.getStatus());
//			classResponse.setMedium(cls.getMedium().getMediumLanguage());
//			classResponse.setEducationBoard(cls.getEducationBoard().getEducationBoardName());
		}
		return bookmarkResponse;

	}

	@GetMapping("/bookmarks/{userId}")
	private ResponseEntity getAllBookMarksForUsers(@PathVariable Integer userId) {

		List<BookmarkResponseEntity> response = new ArrayList<>();
		User userFromDb = userService.findById(userId);
		if (userFromDb != null) {

			bookmarkService.findByUser(userFromDb).forEach(user -> {

				response.add(new BookmarkResponseEntity(user));
			});
			if (response.isEmpty()) {
				TopicSubscriptionResponse userResponseEntity = new TopicSubscriptionResponse();
				userResponseEntity.setStatusCode(201);
				userResponseEntity.setDescription("No Data is Available");
				return new ResponseEntity(userResponseEntity, HttpStatus.NOT_FOUND);
			}

		} else {
			BookmarkResponseEntity res = new BookmarkResponseEntity();
			res.setStatusCode(201);
			res.setDescription("No Data Available");
			return new ResponseEntity(res, HttpStatus.CONFLICT);
		}
		return new ResponseEntity(response, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/bookmark/{bookmarkId}")
	public ResponseEntity deletebookmarkById(@PathVariable Integer bookmarkId) {
		BookmarkResponseEntity bookmarkResponse = new BookmarkResponseEntity();

		Bookmark cls = bookmarkService.findById(bookmarkId);
		if (cls != null) {
			bookmarkService.deleteBookmark(cls);
			bookmarkResponse.setDescription("deleted Successfully");
			bookmarkResponse.setStatusCode(200);
		}
		return new ResponseEntity(bookmarkResponse, HttpStatus.OK);

	}

}
