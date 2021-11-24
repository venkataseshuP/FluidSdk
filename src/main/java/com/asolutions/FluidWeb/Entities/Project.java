package com.asolutions.FluidWeb.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Project {

	@Id
	private String pid;
	private String projectName;
	private boolean active;
	private boolean init;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pid",referencedColumnName = "pid")
	private ProjectProperties properties;
		
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public ProjectProperties getProperties() {
		return properties;
	}
	public void setProperties(ProjectProperties properties) {
		this.properties = properties;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isInit() {
		return init;
	}
	public void setInit(boolean init) {
		this.init = init;
	}
	
		
	
}
