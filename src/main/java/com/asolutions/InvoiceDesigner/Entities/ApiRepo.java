package com.asolutions.InvoiceDesigner.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ApiRepo {

	@EmbeddedId
	private ApiRepoPK id;
	private String desc;
	private String apiName;

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
