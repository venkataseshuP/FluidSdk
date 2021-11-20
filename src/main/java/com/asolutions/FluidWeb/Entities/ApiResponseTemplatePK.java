package com.asolutions.FluidWeb.Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ApiResponseTemplatePK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String apiid;
	private String responseId;
	public String getApiid() {
		return apiid;
	}
	public void setApiid(String apiid) {
		this.apiid = apiid;
	}
	public String getResponseId() {
		return responseId;
	}
	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
	
}
