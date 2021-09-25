package com.asolutions.InvoiceDesigner.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.FileExplorerPK;
import com.asolutions.InvoiceDesigner.Entities.SwaggerSpec;

@Repository
public interface SwaggerSpecRepository extends CrudRepository<SwaggerSpec, FileExplorerPK> {

	List<SwaggerSpec> findByIdPid(String pid);
}
