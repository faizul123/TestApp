package com.test.dao.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.test.service.FileInfo;

@Entity
public class FileIndex {

	@Id
	private String id;
	
	private String name;
	
	private int size;	
	
	private String destPath;
	
	private String contentType;
	
	private boolean isReferenced = false;
	
	private long uploadedTime = System.currentTimeMillis();
	
	public FileIndex(){}
	
	public FileIndex(FileInfo info){
		updateFileInfo(info);
	}
	
	public void updateFileInfo(FileInfo fileInfo){
		this.id = fileInfo.getId();
		this.size = fileInfo.getSize();
		this.name = fileInfo.getName();
		this.destPath = fileInfo.getDestPath();
		this.contentType = fileInfo.getContentType();
		this.isReferenced = fileInfo.isTempFile();
		this.uploadedTime = fileInfo.getUploadedTime();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public boolean isReferenced() {
		return isReferenced;
	}

	public void setReferenced(boolean isReferenced) {
		this.isReferenced = isReferenced;
	}

	public long getUploadedTime() {
		return uploadedTime;
	}

	public void setUploadedTime(long uploadedTime) {
		this.uploadedTime = uploadedTime;
	}
}
