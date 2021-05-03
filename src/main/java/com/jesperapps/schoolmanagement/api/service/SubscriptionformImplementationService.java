package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.SubscriptionRequest;

import com.jesperapps.schoolmanagement.api.model.ClassSubscription;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;
import com.jesperapps.schoolmanagement.api.model.SubscriptionStatus;
import com.jesperapps.schoolmanagement.api.model.User;

import com.jesperapps.schoolmanagement.api.repository.SubscriptionFormRepository;
import com.jesperapps.schoolmanagement.api.repository.SubscriptionStatusRepository;
import com.jesperapps.schoolmanagement.api.repository.UserRepository;
import com.jesperapps.schoolmanagement.api.utils.SubscriptionStatusTag;

import com.jesperapps.schoolmanagement.api.model.Class;

@Service
public class SubscriptionformImplementationService implements SubscriptionFormService {

	@Autowired
	private SubscriptionFormRepository subscriptionFormRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClassService classService;
	
	
	
	@Autowired
	private MediumService mediumService;
	
	@Autowired
	private EducationBoardService educationBoardService;
	
	@Autowired
	private SubscriptionStatusRepository subscriptionStatusRepository;
	
	@Autowired
	private SchoolClassesService schoolClassesService;
	

	
	@Override
	public ClassSubscription findBySubscriptionId(int subscriptionId) {
		
		return subscriptionFormRepository.findBySubscriptionId(subscriptionId);
	}


	@Override
	public Response createSubscription(SubscriptionRequest subscriptionRequest) {
		System.out.println("check" + subscriptionRequest.getSubscriptionClass().toString()+","+subscriptionRequest.getSubscriptionClass().getSchoolClassesId());
		
		Response response= new Response(409,"Error While subscribing");
		ClassSubscription classSubscription= new ClassSubscription();
		List <ClassSubscription>  userSubscription = subscriptionFormRepository.findAllBySubscriptionClass_schoolClassesIdAndUser_userId(subscriptionRequest.getSubscriptionClass().getShoolClassesId() , subscriptionRequest.getUser().getUserId() );
		  //System.out.println("userSubscription"+userSubscription.toString());
		  //System.out.println("userSubscription"+userSubscription.size());
		if(userSubscription.isEmpty() == false)
		{
			   response.setStatusCode(409);
			   response.setDescription("Class Already Subscribed For User");
			   return response;
		}else
			
		{
			SchoolClasses requestedSchoolClassFromDB = schoolClassesService.findSchoolClassesFromId(subscriptionRequest.getSubscriptionClass().getSchoolClassesId());
			//ClassSubscription subreqclass=subscriptionFormRepository.findBySubscriptionClass_schoolClassesId(subscriptionRequest.getSubscriptionClass().getShoolClassesId());
//			subscriptionForm.setSubscriptionId(subscriptionRequest.getSubscriptionId());
			System.out.println(subscriptionRequest.getSubscriptionClass().getSchoolClassesId());
			if(requestedSchoolClassFromDB != null) {
				System.out.println(requestedSchoolClassFromDB.toString());
				classSubscription.setSubscriptionClass(requestedSchoolClassFromDB);
			}else{
					response.setErrorCode(409);
					response.setDescription("No Class Found");
			}
			classSubscription.setSubscriptionClass(schoolClassesService.findSchoolClassesFromId(subscriptionRequest.getSubscriptionClass().getShoolClassesId()));
//			classSubscription.setMedium(mediumService.findMediumFromId(subscriptionRequest.getMedium().getMediumId()));
//			classSubscription.setEducationBoard(educationBoardService.findEducationBoardFromId(subscriptionRequest.getEducationBoard().getEducationBoardId()));
//			subscriptionForm.getSubscriptionStatus()
			User subscriptionUser = userRepository.findByUserId(subscriptionRequest.getUser().getUserId());
			if(subscriptionUser != null) {
				SubscriptionStatus subscribedStatusFromDB = subscriptionStatusRepository.findByStatus(SubscriptionStatusTag.SUBSCRIBED);
				if(subscriptionRequest.getSubscriptionStatus().getSubscriptionStatusid() != null) {
					subscribedStatusFromDB = subscriptionStatusRepository.findBySubscriptionStatusId(subscriptionRequest.getSubscriptionStatus().getSubscriptionStatusid());
				}else if(subscriptionRequest.getSubscriptionStatus().getSubscriptionStatus() != null) {
					subscribedStatusFromDB = subscriptionStatusRepository.findByStatus(subscriptionRequest.getSubscriptionStatus().getSubscriptionStatus());
				}
				classSubscription.setUser(subscriptionUser);
				subscriptionUser.addSubscription(classSubscription);
				classSubscription.setSubscriptionStatus(subscribedStatusFromDB);
				subscriptionUser.addSubscription(classSubscription);
			
//				subscriptionFormRepository.save(classSubscription);
				userRepository.save(subscriptionUser);
				response.setStatusCode(200);
				response.setDescription("Successfully Subscribed");
//				response.setSubscriptionId(subscriptionForm.getSubscriptionId());
	//
//				response.setSubscriptionClass(subscriptionForm.getSubscriptionClass().getClassId());
//				response.setMedium(subscriptionForm.getMedium().getMediumLanguage());
//				response.setEducationBoard(subscriptionForm.getEducationBoard().getEducationBoardName());
//				response.setUser(subscriptionUser);
//				response.setSubscriptionStatus(new SubscriptionStatusJson(subscribedStatusFromDB));
				return response;	
		}

		}

		return null;
	}


	@Override
	public List<ClassSubscription> findAll() {
		
		return subscriptionFormRepository.findAll();
	}


	@Override
	public List<ClassSubscription> findByClass(SchoolClasses cls) {
	
		return this.subscriptionFormRepository.findBySubscriptionClass(cls);
	}


	@Override
	public boolean saveSubscriptionForm(ClassSubscription subscriptionFromDb) {
		try{
			subscriptionFormRepository.save(subscriptionFromDb);
				return true;
				}
			catch(Exception e) 
				{
				return false;
				}
	}


	@Override
	public List<ClassSubscription> findByUser(User userFromDb) {
		
		return this.subscriptionFormRepository.findByUser(userFromDb);
	}


	@Override
	public boolean checkClassInResponse(List<SchoolClasses> classListForResponse, SchoolClasses cls) {
		for(int i=0;i<classListForResponse.size();i++) {
			if(classListForResponse.get(i).getShoolClassesId() == cls.getSchoolClassesId()) {
				return true;
			}
		}
		return false;
	}


	@Override
	public List<ClassSubscription> findAllBySubscriptionClass_schoolClassesIdAndUser_userId(int schoolClassesId , int UserID) {
		// TODO Auto-generated method stub
		return subscriptionFormRepository.findAllBySubscriptionClass_schoolClassesIdAndUser_userId( schoolClassesId ,  UserID);
	}


	@Override
	public List<ClassSubscription> findAllBySchoolClasses_schoolId(School schoolId) {
		// TODO Auto-generated method stub
		return subscriptionFormRepository.findAllBySubscriptionClass_School(schoolId);
	}




	

	



}
