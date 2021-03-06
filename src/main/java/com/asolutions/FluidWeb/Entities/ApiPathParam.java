package com.asolutions.FluidWeb.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class ApiPathParam  {

	@EmbeddedId
	private ApiPathParamPK id;
	
	private String paramName;
	private String template;
	private String paramType;
	@Transient
	private String paramTypename;
	private String description;
	private boolean active;
	
	public ApiPathParamPK getId() {
		return id;
	}
	public void setId(ApiPathParamPK id) {
		this.id = id;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getParamType() {
		return paramType;
	}
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getParamTypename() {
		return paramTypename;
	}
	public void setParamTypename(String paramTypename) {
		this.paramTypename = paramTypename;
	}
	
	
}
