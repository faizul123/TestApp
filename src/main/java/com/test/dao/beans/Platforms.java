package com.test.dao.beans;

import javax.persistence.Entity;

@Entity
public class Platforms {

	private String buildId;
	
	private String platform;
	
	private String version;
	
	private String archType;

	public void setBuildId(String buildId){
		this.buildId = buildId;
	}
	
	public String getBuildId(){
		return this.buildId;
	}
	
	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getVersions() {
		return version;
	}

	public void setVersions(String version) {
		this.version = version;
	}
	
	public void setArchType(String archType){
		this.archType = archType;
	}
	
	public String getArchType(){
		return this.archType;
	}
	
}
