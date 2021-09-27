package com.asolutions.InvoiceDesigner.Entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"typeId" , "namespaceId"})})
public class SimpleType {

	private String typeId;
	private String namespaceId;
	private String regex;
}
