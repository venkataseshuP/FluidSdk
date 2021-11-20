package com.asolutions.FluidWeb.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class ApiQueryParam {

	@EmbeddedId
	private ApiQueryParamPK id;
	
	private String paramName;
	private String template;
	private String paramType;
	@Transient
	private String paramTypename;
	private String description;
	private boolean mandatory;
	private String defaultvalue;
	
	public ApiQueryParamPK getId() {
		return id;
	}
	public void setId(ApiQueryParamPK id) {
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
	public boolean isMandatory() {
		return mandatory;
	}
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}
	
	public String getDefaultvalue() {
		return defaultvalue;
	}
	public void setDefaultvalue(String defaultvalue) {
		this.defaultvalue = defaultvalue;
	}
	public String getParamTypename() {
		return paramTypename;
	}
	public void setParamTypename(String paramTypename) {
		this.paramTypename = paramTypename;
	}
	
	
}
