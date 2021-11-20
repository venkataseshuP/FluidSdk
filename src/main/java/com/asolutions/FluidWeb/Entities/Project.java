package com.asolutions.FluidWeb.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.asolutions.FluidWeb.SequenceGenerators.StringPrefixedSequenceIdGenerator;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pid")
    @GenericGenerator(
            name = "pid",
            strategy = "com.asolutions.FluidWeb.SequenceGenerators.StringPrefixedSequenceIdGenerator",
            parameters = {
                @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "9999"),
                @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "P_"),
                @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%07d") })
	private String pid;
	private String projectName;
	
	@ManyToMany(mappedBy = "projects")
	private Set<User> users = new HashSet<>();
	
//	getters and setters
	public String getId() {
		return pid;
	}
	public void setId(String pid) {
		this.pid = pid;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
	
}
