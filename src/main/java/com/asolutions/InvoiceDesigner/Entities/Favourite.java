package com.asolutions.InvoiceDesigner.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

@Entity
public class Favourite {

	@EmbeddedId
	private FavouritePK id;
	
	@OneToOne
	@JoinColumns({
		@JoinColumn(name = "itemid",referencedColumnName = "id",insertable = false, updatable = false),
		@JoinColumn(name = "pid", referencedColumnName = "pid",insertable = false, updatable = false)
	})
	private FileExplorer fileDetails;

	public FavouritePK getId() {
		return id;
	}

	public void setId(FavouritePK id) {
		this.id = id;
	}

	public FileExplorer getFileDetails() {
		return fileDetails;
	}

	public void setFileDetails(FileExplorer fileDetails) {
		this.fileDetails = fileDetails;
	}
}
