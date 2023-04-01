package com.tim.model;

//import lombok.Getter;
//import lombok.Setter;

import javax.persistence.Column;


public class ApplicationRequest {

    private long applicationId;
    private String description;
    private String applicationName;
    private String owner;

	/*
	 * @Override public String toString() { return "ApplicationRequest{" +
	 * "applicationId=" + applicationId + ", description='" + description + '\'' +
	 * ", applicationName='" + applicationName + '\'' + ", owner='" + owner + '\'' +
	 * '}'; }
	 */

	public long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
    
    
}
