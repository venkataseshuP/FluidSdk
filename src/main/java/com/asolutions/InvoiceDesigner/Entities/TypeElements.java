package com.asolutions.InvoiceDesigner.Entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"typeId" , "namespaceId", "slNo", "elementName"})})
public class TypeElements {
	
	private String typeId;
	private String namespaceId;
	private String slNo;
	private String elementName;
	private String elementTypeId;
	private String elementDesc;
	private String minOccurs;
	private String maxOccurs;
	
	
}
