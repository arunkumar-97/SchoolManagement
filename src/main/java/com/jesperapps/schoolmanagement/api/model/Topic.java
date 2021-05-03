package com.jesperapps.schoolmanagement.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity 
public class Topic extends AbstractAuditingEntity implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer topicId;
	private String topicName;
	
	
	@ManyToOne
	@JoinColumn(name="schoolId" , referencedColumnName = "schoolId")
	private School school;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="topic")
	private List<TopicAttachment> topicAttachment;
	
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public List<TopicAttachment> getTopicAttachment() {
		return topicAttachment;
	}
	public void setTopicAttachment(List<TopicAttachment> topicAttachment) {
		this.topicAttachment = topicAttachment;
	}
	
	
	
	
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public void addAttachment(TopicAttachment attachment) {
		if(this.topicAttachment == null) {
			this.topicAttachment = new ArrayList<>();
		}
		if(attachment != null) {
			this.topicAttachment.add(attachment);
		}
	}
	

}
