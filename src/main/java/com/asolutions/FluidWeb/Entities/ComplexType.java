package com.asolutions.FluidWeb.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"typeId" , "namespaceId"})})
public class ComplexType {

	@EmbeddedId
	private TypesrepoPK id;

	public TypesrepoPK getId() {
		return id;
	}

	public void setId(TypesrepoPK id) {
		this.id = id;
	}
	
	
}
