package com.jesperapps.schoolmanagement.api.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jesperapps.schoolmanagement.api.model.TopicAttachment;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerAttachmentJSON;
import com.jesperapps.schoolmanagement.api.repository.TopicAttachmentRepository;
import com.jesperapps.schoolmanagement.api.utils.StorageUtils;


@Service
public class TopicAttachmentImplementationService  implements TopicAttachmentService{
	
	
	private static final String LOCATION = StorageUtils.getFolderLocation("video_answers");
	
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
                File newAnswerImage = new File(LOCATION + fileName);
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
		String[] fname = requestAttachment.getName().split("\\.(?=[^\\.]+$)");
//		System.out.println("Name" + fname);
//		System.out.println("Name" + fname.length);
//		System.out.println("Name" + fname[0]);
		Random rand = new Random(); 
		int rand_int1 = rand.nextInt(1000); 
		if(this.saveFileToLocalStorage(requestAttachment.getName(),requestAttachment.getFileByte())) {
		
			if(requestAttachment.getPreviewfileByte() !=null) {
				if(this.saveFileToLocalStorage("Preview"+requestAttachment.getName(),requestAttachment.getPreviewfileByte())){
					return true;
					}
				return false;
				}
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
			return Files.readAllBytes(Paths.get(this.LOCATION+pictureName));
		}catch(IOException e) {
		}
		return new byte[] {};
	}
	
	
	
	@SuppressWarnings("static-access")
	@Override
	public byte[] getPreviewFileBytes(String pictureName) {
		try {
			return Files.readAllBytes(Paths.get(this.LOCATION+pictureName));
		}catch(IOException e) {
		}
		return new byte[] {};
	}

	@Override
	public long getFileSize(String fileName) {
		@SuppressWarnings("static-access")
		File requestedFile = new File(this.LOCATION+fileName);
		if(requestedFile.exists()) {		
			return requestedFile.length();
		}
		return 0L;
	}

	}


