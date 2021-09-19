package com.asolutions.InvoiceDesigner.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.asolutions.InvoiceDesigner.Entities.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, String> {
	
}
