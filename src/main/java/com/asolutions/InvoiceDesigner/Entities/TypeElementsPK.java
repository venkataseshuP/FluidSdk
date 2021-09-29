package com.asolutions.InvoiceDesigner.Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

@Embeddable
public class TypeElementsPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private TypesrepoPK typeId;
	private String slNo;
	
	public TypesrepoPK getTypeId() {
		return typeId;
	}

	public void setTypeId(TypesrepoPK typeId) {
		this.typeId = typeId;
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
