package com.jesperapps.schoolmanagement.api.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.jesperapps.schoolmanagement.api.modelmessage.AnswerContentJSON;

import net.bytebuddy.implementation.auxiliary.AuxiliaryType.SignatureRelevant;

@Entity
public class AnswerContent extends AbstractAuditingEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer answerContentId;
	
	
	@Lob
	private String answerConent;
	private String label;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="GifImg_Id")
	private AnswerAttachment imageAttachment;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="answerId",referencedColumnName = "answerId")
	private Answers answer;


	
	public AnswerContent() {
		
	}


	public AnswerContent(AnswerContentJSON contentJson) {
		// TODO Auto-generated constructor stub
		this.answerContentId = contentJson.getAnswerContentId();
		this.answerConent=contentJson.getAnswerConent();
		this.label=contentJson.getLabel();
		if(contentJson.getAnswerAttachmentJSON() != null) {
			this.imageAttachment = new AnswerAttachment(contentJson.getAnswerAttachmentJSON());
		}
	}


	public Integer getAnswerContentId() {
		return answerContentId;
	}


	public void setAnswerContentId(Integer answerContentId) {
		this.answerContentId = answerContentId;
	}

	


	public String getAnswerConent() {
		return answerConent;
	}


	public void setAnswerConent(String answerConent) {
		this.answerConent = answerConent;
	}


	


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public AnswerAttachment getImageAttachment() {
		return imageAttachment;
	}


	public void setImageAttachment(AnswerAttachment imageAttachment) {
		this.imageAttachment = imageAttachment;
	}


	public Answers getAnswer() {
		return answer;
	}


	public void setAnswer(Answers answer) {
		this.answer = answer;
	}


//	@Override
//	public String toString() {
//		return "AnswerContent [answerContentId=" + answerContentId + ", answerConent=" + answerConent + ", label="
//				+ label + ", imageAttachment=" + imageAttachment + ", answer=" + answer + "]";
//	}
	
	
	
	
	
}
