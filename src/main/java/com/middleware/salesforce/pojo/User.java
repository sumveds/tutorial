package com.middleware.salesforce.pojo;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5169339775974284123L;

	private String profileId;

	private String active;

	private String id;

	private String name;
	
	public User() {
	}

	public User(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("{id=").append(this.id);
		sb.append(",profileId=").append(this.profileId);
		sb.append(",active=").append(this.active);
		sb.append(",name=").append(this.name).append("}");
		
		return sb.toString();
	}

}
