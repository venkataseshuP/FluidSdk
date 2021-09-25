package com.asolutions.InvoiceDesigner.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class SwaggerSpec {
	
	@EmbeddedId
	private FileExplorerPK id;
	
	@Lob
	private String spec;

	public FileExplorerPK getId() {
		return id;
	}

	public void setId(FileExplorerPK id) {
		this.id = id;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	

}
