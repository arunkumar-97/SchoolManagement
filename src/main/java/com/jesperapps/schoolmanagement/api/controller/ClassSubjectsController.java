package com.jesperapps.schoolmanagement.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.ClassSubjectsRequest;
import com.jesperapps.schoolmanagement.api.message.ClassSubjectsResponse;
import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.SchoolClassesRequest;
import com.jesperapps.schoolmanagement.api.message.SchoolClassesResponse;
import com.jesperapps.schoolmanagement.api.message.UserRequest;
import com.jesperapps.schoolmanagement.api.message.UserResponse;
import com.jesperapps.schoolmanagement.api.model.ClassSubjects;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.service.ClassSubjectsService;
import com.jesperapps.schoolmanagement.api.service.SchoolClassesService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ClassSubjectsController{

	@Autowired
	private ClassSubjectsService classSubjectsService;

	@Autowired
	private SchoolClassesService schoolClassesService;

	@PostMapping("/class/subject")
	public Response createSubjectsToClass(@RequestBody ClassSubjectsRequest classSubjectsRequest) {
		return classSubjectsService.createSubjectsToClass(classSubjectsRequest);
	}
	
	@PostMapping("/classes/subjects")
	public ClassSubjectsResponse createMultipleSubjectsToClass(@RequestBody List<ClassSubjectsRequest> classSubjectsRequest) {
			return classSubjectsService.createMultipleSubjectsToClass(classSubjectsRequest);
		}

	@GetMapping("/subject/class/{schoolClassesId}")
	private ResponseEntity getAllSubscribedClassForUsers(@PathVariable Integer schoolClassesId) {

		List<ClassSubjects> response = new ArrayList<>();
		SchoolClasses schoolFromDb = schoolClassesService.findByShoolClassesId(schoolClassesId);
		if (schoolFromDb != null) {

			classSubjectsService.findBySchoolClasses(schoolFromDb).forEach(user -> {

				response.add(new ClassSubjects(user));

			});

			if (response.isEmpty()) {
				ClassSubjectsResponse userResponseEntity = new ClassSubjectsResponse();
				userResponseEntity.setStatusCode(201);
				userResponseEntity.setDescription("No Data is Available");
				return new ResponseEntity(userResponseEntity, HttpStatus.NOT_FOUND);
			}

		} else {
			ClassSubjectsResponse userResponseEntity = new ClassSubjectsResponse();
			userResponseEntity.setStatusCode(201);
			userResponseEntity.setDescription("No Data  Not Found");
			return new ResponseEntity(userResponseEntity, HttpStatus.CONFLICT);
		}
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/class/subject/{classSubjectsId}")
	public ResponseEntity updateUser(@RequestBody ClassSubjectsRequest ClassSubjectsRequest) {
		if (ClassSubjectsRequest.getClassSubjectsId() == null) {
			ClassSubjectsRequest userResponseEntity = new ClassSubjectsRequest();
			userResponseEntity.setStatusCode(404);
			userResponseEntity.setDescription("UserId Not Found");
			return new ResponseEntity(userResponseEntity, HttpStatus.CONFLICT);
		}
		ClassSubjects classSubjectsDatas = classSubjectsService.findClassSubjectsFromId(ClassSubjectsRequest.getClassSubjectsId());
		if (classSubjectsDatas != null) {
			ClassSubjects users = new ClassSubjects(ClassSubjectsRequest.getClassSubjectsId(),classSubjectsDatas.getSchoolClasses(),classSubjectsDatas.getSubject(),ClassSubjectsRequest.getStatus(),ClassSubjectsRequest);
//			users.setCreatedByUser(userDatas.get().getCreatedByUser());
//			if (userRequestEntity.getAttachment() == null) {
//			} else {
//				if (userDatas.get().getAttachment() == null) {
//					Attachment attachment = new Attachment(userRequestEntity.getAttachment());
//					Attachment att = attachmentService.save(attachment);
//					String fileDownloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
//							.path("/download_image/").path(att.getAttachmentId().toString()).toUriString();
//
//					String fileViewUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/view_image/")
//							.path(att.getAttachmentId().toString()).toUriString();
//					att.setFileDownloadUrl(fileDownloadUrl);
//					att.setFileViewUrl(fileViewUrl);
//					users.setAttachment(att);
//				} else {
//					Attachment attachment = new Attachment(userRequestEntity.getAttachment());
//					users.setAttachment(attachment);
//				}
//			}
//			users.setPasscode(userDatas.get().getPasscode());
			ClassSubjects userData = classSubjectsService.save(users);
			if (userData != null) {
				ClassSubjectsRequest userResponseEntity = new ClassSubjectsRequest(userData);
				ClassSubjectsResponse userResponseEntity1 = new ClassSubjectsResponse(userResponseEntity);
//				UserType uTypes = userRequestEntity.getUserType();
//				for (UserType ut : userResponseEntity.getData().getUserType()) {
//					UserType userType = new UserType(ut, ut);
//					uTypes.add(userType);
//				}
//				userResponseEntity.setUserType(uTypes);
				userResponseEntity1.setStatusCode(200);
				userResponseEntity1.setDescription("Class Subjects Updated Successfully");
				return new ResponseEntity(userResponseEntity1, HttpStatus.OK);
			} else {
				UserResponse userResponseEntity = new UserResponse();
				userResponseEntity.setStatusCode(400);
				userResponseEntity.setDescription("Unable to Update Class Subjects");
				return new ResponseEntity(userResponseEntity, HttpStatus.CONFLICT);
			}
		} else {
			UserResponse userResponseEntity = new UserResponse();
				userResponseEntity.setStatusCode(404);
				userResponseEntity.setDescription("Class Subjects Not Found");
				return new ResponseEntity(userResponseEntity, HttpStatus.CONFLICT);
		}
	}

}
