package com.asolutions.InvoiceDesigner.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ApiHeaderParam {

	@EmbeddedId
	private ApiHeaderParamPK id;
	
	private String paramName;
	private String template;
	private String paramType;
	private String description;
	private boolean mandatory;
	private String defaultvalue;
	public ApiHeaderParamPK getId() {
		return id;
	}
	public void setId(ApiHeaderParamPK id) {
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
		
	
}
