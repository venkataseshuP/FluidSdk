package com.asolutions.InvoiceDesigner.Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RefferedTemplatesPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String templateId;
	private String refferedTemplateId;
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	
	public String getRefferedTemplateId() {
		return refferedTemplateId;
	}
	public void setRefferedTemplateId(String refferedTemplateId) {
		this.refferedTemplateId = refferedTemplateId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
