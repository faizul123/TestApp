package com.test.dao.beans;

public class Apps {

	private String id;
	
	private String version;
	
	private boolean isCurrentVersion;
	
	private String platform;
	
	private String supportedVersions;
	
	private String buildId;
	
	private long createdTime;
	
	private long modifiedTime;

	protected Apps(){}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isCurrentVersion() {
		return isCurrentVersion;
	}

	public void setCurrentVersion(boolean isCurrentVersion) {
		this.isCurrentVersion = isCurrentVersion;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getSupportedVersions() {
		return supportedVersions;
	}

	public void setSupportedVersions(String supportedVersions) {
		this.supportedVersions = supportedVersions;
	}

	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}

	public long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(long createdTime) {
		this.createdTime = createdTime;
	}

	public long getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(long modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
	
	
}
