package com.asolutions.InvoiceDesigner.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class FileExplorer {
	
	@EmbeddedId
	private FileExplorerPK id;
	private String parentId;
	private String name;
	private String type;
	@Transient
	private boolean showChildren = false;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumns({
		@JoinColumn(name = "parentId",referencedColumnName = "id"),
		@JoinColumn(name = "pid", referencedColumnName = "pid")
	})
	private List<FileExplorer> children;

	

	public FileExplorerPK getId() {
		return id;
	}

	public void setId(FileExplorerPK id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isShowChildren() {
		return showChildren;
	}

	public void setShowChildren(boolean showChildren) {
		this.showChildren = showChildren;
	}

	public List<FileExplorer> getChildren() {
		return children;
	}

	public void setChildren(List<FileExplorer> children) {
		this.children = children;
	}

	
}
