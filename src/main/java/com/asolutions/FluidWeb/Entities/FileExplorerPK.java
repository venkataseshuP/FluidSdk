package com.asolutions.FluidWeb.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FileExplorerPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="ID")
	private String itemId;
	private String pid;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
