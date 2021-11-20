package com.asolutions.FluidWeb.Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ApiRequestTemplatePK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String apiid;
	private String requestId;
	public String getApiid() {
		return apiid;
	}
	public void setApiid(String apiid) {
		this.apiid = apiid;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
