package com.jesperapps.schoolmanagement.api.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.model.AnswerAttachment;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerAttachmentJSON;
import com.jesperapps.schoolmanagement.api.repository.AnswerAttachmentRepository;



@Service
public class AnswerAttachmentImplementationService  implements AnswerAttachmentService{

	
private static final String LOCATION = "E:\\ContentUploading\\imageAnswers";
	
	@Autowired
	private AnswerAttachmentRepository answerAttachementRepository;
	
	
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
				buffer.write(Base64.decodeBase64(fileBytes));
				buffer.close();
            }
            else{
                return false;
            }
		}catch(Exception e) {
			return false;
		}
		return true;
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
	public void save(AnswerAttachment newAttachement) {
		this.answerAttachementRepository.save(newAttachement);
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
	public boolean updateAttachmentDetails(AnswerAttachment attachmentFromDb,
			AnswerAttachmentJSON updateAttachmentRequest) {
		if(this.deleteFileFromLocalStorage(attachmentFromDb.getPictureName())) {
			if(this.saveFile(updateAttachmentRequest)) {
				return true;
			}
		}
		return false;
	}

	
}
