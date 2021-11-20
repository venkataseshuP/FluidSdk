package com.asolutions.FluidWeb.Entities;

import javax.persistence.Id;

public class EndpointRepo {

	@Id
	private String endpointId;
	private String url;
	private String desc;
	
	public String getEndpointId() {
		return endpointId;
	}
	public void setEndpointId(String endpointId) {
		this.endpointId = endpointId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
