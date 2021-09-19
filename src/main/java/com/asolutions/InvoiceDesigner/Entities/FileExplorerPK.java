package com.asolutions.InvoiceDesigner.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.asolutions.InvoiceDesigner.SequenceGenerators.StringPrefixedSequenceIdGenerator;

@Embeddable
public class FileExplorerPK implements Serializable {

	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemId")
	@GenericGenerator(name = "itemId", strategy = "com.asolutions.InvoiceDesigner.SequenceGenerators.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "9999"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "FE_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%07d") })
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
