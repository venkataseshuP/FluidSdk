package com.asolutions.InvoiceDesigner.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ApiRepo {

	@EmbeddedId
	private ApiRepoPK id;
	private String desc;
	private String apiName;
	private String endpointId;
	private String method;
	private String url;

	public String getEndpointId() {
		return endpointId;
	}

	public void setEndpointId(String endpointId) {
		this.endpointId = endpointId;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ApiRepoPK getId() {
		return id;
	}

	public void setId(ApiRepoPK id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

}
