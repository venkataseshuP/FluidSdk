package com.asolutions.FluidWeb.Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class FavouritePK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userid;
	private String pid;
	private String itemid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}	

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
	
}
