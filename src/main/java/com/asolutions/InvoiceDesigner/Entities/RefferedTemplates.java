package com.asolutions.InvoiceDesigner.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"templateId" , "slNo", "refferedTemplateId"})})
public class RefferedTemplates {

	@EmbeddedId
	private RefferedTemplatesPK id;
	private String refferedTemplateId;
	
	public RefferedTemplatesPK getId() {
		return id;
	}
	public void setId(RefferedTemplatesPK id) {
		this.id = id;
	}
	public String getRefferedTemplateId() {
		return refferedTemplateId;
	}
	public void setRefferedTemplateId(String refferedTemplateId) {
		this.refferedTemplateId = refferedTemplateId;
	}

		
	
}
