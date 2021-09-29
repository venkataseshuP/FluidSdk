package com.asolutions.InvoiceDesigner.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Template {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String templateId;
	private String templateDesc;
	private String namespaceId;
	private int format;
	private String roottypeId;
	private int minOccurs;
	private int maxOccurs;
	private boolean published;
	
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getTemplateDesc() {
		return templateDesc;
	}
	public void setTemplateDesc(String templateDesc) {
		this.templateDesc = templateDesc;
	}
	public String getNamespaceId() {
		return namespaceId;
	}
	public void setNamespaceId(String namespaceId) {
		this.namespaceId = namespaceId;
	}
	public int getFormat() {
		return format;
	}
	public void setFormat(int format) {
		this.format = format;
	}
	public String getRoottypeId() {
		return roottypeId;
	}
	public void setRoottypeId(String roottypeId) {
		this.roottypeId = roottypeId;
	}
	public int getMinOccurs() {
		return minOccurs;
	}
	public void setMinOccurs(int minOccurs) {
		this.minOccurs = minOccurs;
	}
	public int getMaxOccurs() {
		return maxOccurs;
	}
	public void setMaxOccurs(int maxOccurs) {
		this.maxOccurs = maxOccurs;
	}
	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	
	

	
}
