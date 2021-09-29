package com.asolutions.InvoiceDesigner.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"namespaceId" , "typeName"}),
						  @UniqueConstraint(columnNames = {"typeId" , "namespaceId"})})
public class Typesrepo {

	@EmbeddedId
	private TypesrepoPK id;
	private String templateId;
	private String typeName;
	private String desc;
	private String type;
	
	public TypesrepoPK getId() {
		return id;
	}
	public void setId(TypesrepoPK id) {
		this.id = id;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
