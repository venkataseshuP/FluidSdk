package com.asolutions.FluidWeb.Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ApiRepoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String apidocId;
	private String pid;
	private String apiid;	
	
	
	
	public String getApiid() {
		return apiid;
	}
	public void setApiid(String apiid) {
		this.apiid = apiid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getApidocId() {
		return apidocId;
	}
	public void setApidocId(String apidocId) {
		this.apidocId = apidocId;
	}
	
	
	
}
