package com.asolutions.FluidWeb.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private String uid;
	private String email;
	private boolean emailVerified = false;
	private String displayName;
	private String photoURL;
	@Column(name="PREFFEREDPROJECT")
	private String prefferedProject;

//	getters and setters

	public String getPrefferedProject() {
		return prefferedProject;
	}

	public void setPrefferedProject(String prefferedProject) {
		this.prefferedProject = prefferedProject;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}
	

}
