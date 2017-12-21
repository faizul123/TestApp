package com.test.request.beans;

import java.util.List;

public class AppInfo {

	private String buildId;
	
	private String version;
	
	private boolean isReadyToPublish;
	
	private String description;
	
	private List<Platform> platforms;
	
	private List<String> archTypes;
	
	public AppInfo(){
		
	}

	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isReadyToPublish() {
		return isReadyToPublish;
	}

	public void setReadyToPublish(boolean isReadyToPublish) {
		this.isReadyToPublish = isReadyToPublish;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Platform> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<Platform> platforms) {
		this.platforms = platforms;
	}

	public List<String> getArchTypes() {
		return archTypes;
	}

	public void setArchTypes(List<String> archTypes) {
		this.archTypes = archTypes;
	}
	
}
