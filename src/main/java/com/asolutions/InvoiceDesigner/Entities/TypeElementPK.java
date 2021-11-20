package com.asolutions.InvoiceDesigner.Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TypeElementPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String typeId;
	private String namespaceId;
	private Integer slNo;
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getNamespaceId() {
		return namespaceId;
	}
	public void setNamespaceId(String namespaceId) {
		this.namespaceId = namespaceId;
	}
	public Integer getSlNo() {
		return slNo;
	}
	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
