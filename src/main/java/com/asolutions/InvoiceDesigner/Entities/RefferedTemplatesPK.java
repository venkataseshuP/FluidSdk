package com.asolutions.InvoiceDesigner.Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RefferedTemplatesPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String templateId;
	private String slNo;
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getSlNo() {
		return slNo;
	}
	public void setSlNo(String slNo) {
		this.slNo = slNo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
