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
	private String namespaceId;
	private int format;
	private String roottypeId;
	private int minOccurs;
	private int maxOccurs;
	private boolean published;
	

	
}
