package com.jesperapps.schoolmanagement.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.model.TopicAttachment;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerAttachmentJSON;

import com.jesperapps.schoolmanagement.api.repository.TopicRepository;

@Service
public class TopicImplementationService implements TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private TopicAttachmentService topicAttachmentService;
	
	private TopicAttachment createNewTopicAttachmentFromRequest(AnswerAttachmentJSON topicAttachmentRequest) {
		if(this.topicAttachmentService.saveFile(topicAttachmentRequest)) {
			return new TopicAttachment(topicAttachmentRequest);	
		}
		return null;
	}
	
	private Topic updateTopicAttachmentURL(Topic topicToBeUpdated) {
		List<TopicAttachment> topicAttachmentList = topicToBeUpdated.getTopicAttachment();
		if(topicAttachmentList != null) {
		topicAttachmentList.forEach(attachment ->{
			attachment.setPictureLocation(TopicAttachmentService.BASE_URL+"/"+attachment.getPictureId());
			attachment.setPreviewLocation(TopicAttachmentService.PREVIEW_URL+"/"+attachment.getPictureId());
		});
		topicToBeUpdated.setTopicAttachment(topicAttachmentList);
		}
		return topicToBeUpdated;
	}

	@Override
	public Topic checkTopic(String topicName) {
		
		return topicRepository.findByTopicName(topicName);
	}

	@Override
	public Topic createnewTopic(Integer topicId, String topicName) {
		Topic newTopic =new Topic();
		newTopic.setTopicId(topicId);
		newTopic.setTopicName(topicName);		
		this.saveTopic(newTopic);
		return newTopic;
	}

	
	
	@Override
	public Topic findByTopicName(String topicName) {
		
		return topicRepository.findByTopicName(topicName);
	}

	@Override
	public List<TopicAttachment> addTopicAttachment(Topic topicFromDb,List<AnswerAttachmentJSON> topicAttachmentList) {
		// TODO Auto-generated method stub
		if(topicAttachmentList != null) {
			List<TopicAttachment> newTopicAttachmentListForDb = new ArrayList<>();
			topicAttachmentList.forEach(requestTopicAttachment -> {
				TopicAttachment newTopicAttachment = this.createNewTopicAttachmentFromRequest(requestTopicAttachment);
				if(newTopicAttachment != null){
					newTopicAttachment.setTopic(topicFromDb);
					topicFromDb.addAttachment(newTopicAttachment);
					newTopicAttachmentListForDb.add(newTopicAttachment);
				}
			});
			return newTopicAttachmentListForDb;
		}
		return null;
	}


	@Override
	public void saveTopic(Topic newTopic) {
		topicRepository.save(newTopic);
		newTopic = this.updateTopicAttachmentURL(newTopic);
		topicRepository.save(newTopic);
		
	}

	@Override
	public Topic findByTopicId(Integer topicId) {
		// TODO Auto-generated method stub
		return topicRepository.findByTopicId(topicId);
	}

	@Override
	public List<Topic> findAll() {
		
		return topicRepository.findAll();
	}
	

	
	
	

}
