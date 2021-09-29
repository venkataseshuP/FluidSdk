package com.asolutions.InvoiceDesigner.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"typeId" , "namespaceId", "slNo", "elementName"})})
public class TypeElements {
	
	@EmbeddedId
	private TypeElementsPK id;
	private String elementName;
	private String elementTypeId;
	private String elementDesc;
	private String minOccurs;
	private String maxOccurs;
	public TypeElementsPK getId() {
		return id;
	}
	public void setId(TypeElementsPK id) {
		this.id = id;
	}
	public String getElementName() {
		return elementName;
	}
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}
	public String getElementTypeId() {
		return elementTypeId;
	}
	public void setElementTypeId(String elementTypeId) {
		this.elementTypeId = elementTypeId;
	}
	public String getElementDesc() {
		return elementDesc;
	}
	public void setElementDesc(String elementDesc) {
		this.elementDesc = elementDesc;
	}
	public String getMinOccurs() {
		return minOccurs;
	}
	public void setMinOccurs(String minOccurs) {
		this.minOccurs = minOccurs;
	}
	public String getMaxOccurs() {
		return maxOccurs;
	}
	public void setMaxOccurs(String maxOccurs) {
		this.maxOccurs = maxOccurs;
	}
	
	
	
}
