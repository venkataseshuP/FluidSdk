package com.asolutions.InvoiceDesigner.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.ApiRepo;
import com.asolutions.InvoiceDesigner.Entities.ApiRepoPK;

@Repository
public interface APIRepoRepository extends CrudRepository<ApiRepo, ApiRepoPK>{

	List<ApiRepo> findByIdPidAndId_apidocId(String pid, String apidocId);
	
}
