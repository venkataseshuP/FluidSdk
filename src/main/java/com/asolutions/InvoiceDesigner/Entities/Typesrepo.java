package com.asolutions.InvoiceDesigner.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"namespaceId" , "typeName"})})
public class Typesrepo {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String typeId;
	private String namespaceId;
	private String templateId;
	private String typeName;
	private String desc;
	private String type;
	
}
