package com.asolutions.FluidWeb.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.FluidWeb.Entities.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, String> {
	
}
