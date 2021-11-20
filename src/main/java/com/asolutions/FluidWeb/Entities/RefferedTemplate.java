package com.asolutions.FluidWeb.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class RefferedTemplate {

	@EmbeddedId
	private RefferedTemplatesPK id;
	
	public RefferedTemplatesPK getId() {
		return id;
	}
	public void setId(RefferedTemplatesPK id) {
		this.id = id;
	}
}
