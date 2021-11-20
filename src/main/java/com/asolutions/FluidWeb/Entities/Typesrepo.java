package com.asolutions.FluidWeb.Entities;

import java.util.LinkedList;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
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
	private String pattern;
	private String enums;
	private String minOccurs;
	private String maxOccurs;
	@Transient
	private LinkedList<TypeElement> typeelements;
	@Transient
	private boolean isRoottype;
	
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
	public LinkedList<TypeElement> getTypeelements() {
		return typeelements;
	}
	public void setTypeelements(LinkedList<TypeElement> typeelements) {
		this.typeelements = typeelements;
	}
	public boolean isRoottype() {
		return isRoottype;
	}
	public void setRoottype(boolean isRoottype) {
		this.isRoottype = isRoottype;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getEnums() {
		return enums;
	}
	public void setEnums(String enums) {
		this.enums = enums;
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
