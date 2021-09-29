package com.asolutions.InvoiceDesigner.Entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"templateId" , "slNo", "refferedTemplateId"})})
public class RefferedTemplates {

	private String templateId;
	private String slNo;
	private String refferedTemplateId;
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
	public String getRefferedTemplateId() {
		return refferedTemplateId;
	}
	public void setRefferedTemplateId(String refferedTemplateId) {
		this.refferedTemplateId = refferedTemplateId;
	}
	
}
