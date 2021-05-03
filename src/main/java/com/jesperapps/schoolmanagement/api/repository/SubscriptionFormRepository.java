package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.ClassSubscription;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;
import com.jesperapps.schoolmanagement.api.model.User;

public interface SubscriptionFormRepository extends JpaRepository<ClassSubscription, Integer>{

	ClassSubscription findBySubscriptionId(int subscriptionId);
						
	List<ClassSubscription> findAll();

	List<ClassSubscription> findBySubscriptionClass(SchoolClasses cls);

	List<ClassSubscription> findByUser(User userFromDb);

	List<ClassSubscription> findAllBySubscriptionClass_schoolClassesIdAndUser_userId(Integer schoolClassesId , Integer UserID);
//
//	List<ClassSubscription> findAllBySubscriptionClass_schoolClassesIdAndUser_userIdAndMedium_mediumIdAndEducationBoard_educationBoardId(
//			Integer schoolClassesId, Integer userId, int mediumId, Integer educationBoardId);

	ClassSubscription findBySubscriptionClass_schoolClassesId(Integer shoolClassesId);

//	List<ClassSubscription> findAllBySchoolClasses_schoolId(Integer schoolId);

//	List<ClassSubscription> findAllBySchoolClasses_School_SchoolId(Integer schoolId);

//	List<ClassSubscription> findAllBySchoolClasses_School_schoolId(Integer schoolId);

//	List<ClassSubscription> findAllBySchoolClasses_School(Integer schoolId);

	List<ClassSubscription> findAllBySubscriptionClass_School(School schoolId);

	
	
	

	

}
