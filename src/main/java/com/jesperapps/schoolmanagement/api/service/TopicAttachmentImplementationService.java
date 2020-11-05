package com.jesperapps.schoolmanagement.api.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.model.TopicAttachment;

import com.jesperapps.schoolmanagement.api.modelmessage.AnswerAttachmentJSON;
import com.jesperapps.schoolmanagement.api.repository.TopicAttachmentRepository;


@Service
public class TopicAttachmentImplementationService  implements TopicAttachmentService{
	
	
	private static final String LOCATION = "E:\\ContentUploading\\videoAnswers";
	
	@Autowired
	private TopicAttachmentRepository topicAttachmentRepository;
	
	
	
	private boolean saveFileToLocalStorage(String fileName, String fileBytes) {
		try {
			if(Files.notExists(Paths.get(LOCATION))){
                File directoryFile = new File(LOCATION);
                if(directoryFile.mkdir()){
                    //directory created successfully;
                }else{
                    //error creating directory
                	return false;
                }
            }
            if(fileName != ""){
                File newAnswerImage = new File(LOCATION + "\\"+ fileName);
				OutputStream buffer = new FileOutputStream(newAnswerImage);
				buffer.write(this.addPaddingToBase64String(fileBytes));
				buffer.close();
            }
            else{
                return false;
            }
		}catch(Exception e) {
			System.out.println(e.toString()+fileBytes.length());
			return false;
		}
		return true;
	}
	
	private byte[] addPaddingToBase64String(String base64Encoded) {
		Integer length = base64Encoded.length();
		if(length % 4 ==0) {
			return Base64.decodeBase64(base64Encoded);
		}else {
			Integer numberOfZeros = 4-(base64Encoded.length() % 4);
			char[] zerosArray = new char[numberOfZeros];
			Arrays.fill(zerosArray, '0');
			return Base64.decodeBase64(base64Encoded+new String(zerosArray));
		}
	}
	
	
	private boolean deleteFileFromLocalStorage(String fileName) {
		try {
			Files.delete(Paths.get(LOCATION+"\\"+fileName));
		}catch(Exception e) {
			return false;
		}
		return true;
	}


	@Override
	public boolean saveFile(AnswerAttachmentJSON requestAttachment) {
		if(this.saveFileToLocalStorage(requestAttachment.getName(), requestAttachment.getFileByte()))
		{
			return true;
		}
		return false;
	}

	@Override
	public void save(TopicAttachment newAttachement) {
		this.topicAttachmentRepository.save(newAttachement);
		
	}

	@Override
	public boolean updateFile(AnswerAttachmentJSON updatedAttachment, String oldFileName) {
		if(this.deleteFileFromLocalStorage(oldFileName)) {
			if(updatedAttachment.getName() != null && updatedAttachment.getFileByte() != null) {
				return this.saveFile(updatedAttachment);
			}
		}
		else {
			return false;
		}
		return false;
	}

	@Override
	public boolean updateAttachmentDetails(TopicAttachment attachmentFromDb, AnswerAttachmentJSON requestAttachment) {

			if(this.deleteFileFromLocalStorage(attachmentFromDb.getPictureName())) {
				if(this.saveFile(requestAttachment)) {
					return true;
				}
			}
			return false;
	}

	@Override
	public TopicAttachment getByPictureId(Integer pictureId) {
		
		return this.topicAttachmentRepository.findByPictureId(pictureId);
		
	}

	@SuppressWarnings("static-access")
	@Override
	public byte[] getFileBytes(String pictureName) {
		try {
			return Files.readAllBytes(Paths.get(this.LOCATION+"\\"+pictureName));
		}catch(IOException e) {
		}
		return new byte[] {};
	}

	}


