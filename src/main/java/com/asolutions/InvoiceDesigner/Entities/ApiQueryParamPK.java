package com.asolutions.InvoiceDesigner.Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ApiQueryParamPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String apiid;
	private String paramId;
	
	public String getApiid() {
		return apiid;
	}
	public void setApiid(String apiid) {
		this.apiid = apiid;
	}
	public String getParamId() {
		return paramId;
	}
	public void setParamId(String paramId) {
		this.paramId = paramId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
