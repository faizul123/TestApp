package com.test.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.config.AppConstants;
import com.test.dao.beans.FileIndex;
import com.test.util.URLDirectory;
import com.test.util.Utility;


public class FileInfo {

	
	private String id;
	
	private String name;
	
	private int size;	
	
	@JsonIgnore
	private String destPath;
	
	@JsonIgnore
	private byte[] bytes;
	
	private String contentType;
	
	@JsonIgnore
	private boolean isReferenced = false;
	
	private long uploadedTime = System.currentTimeMillis();
	
	private String downloadLink;

	public FileInfo(MultipartFile file,String destPath) throws IOException{
		this.bytes = file.getBytes();
		this.name = file.getOriginalFilename();
		this.contentType = file.getContentType();
		this.size = bytes.length;
		this.id = Utility.randomUUID();
		setDestPath(destPath);
	}
	
	public FileInfo(FileIndex index){
		this.id = index.getId();
		this.name = index.getName();
		this.size = index.getSize();
		this.destPath = index.getDestPath();
		this.contentType = index.getContentType();
		this.isReferenced = index.isReferenced();
		this.uploadedTime = index.getUploadedTime();
		setDownloadLink(this.id);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public void setDestPath(String destPath){
		this.destPath = destPath + System.currentTimeMillis() + name;
	}
	
	public String getDestPath(){
		return this.destPath;
	}
	
	@JsonIgnore
	public boolean isTempFile(){
		return isReferenced;
	}
	
	public void setTempFile(boolean isTempFile){
		this.isReferenced = isTempFile;
	}
	
	public long getUploadedTime(){
		return uploadedTime;
	}
	
	public void setDownloadLink(String downloadLink){
		this.downloadLink =  AppConstants.HOST + URLDirectory.download + "?key=" + downloadLink;
	}
	
	public String getDownloadLink(){
		return downloadLink;
	}
}
