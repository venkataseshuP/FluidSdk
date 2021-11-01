package com.asolutions.InvoiceDesigner.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.ApiRequestTemplate;
import com.asolutions.InvoiceDesigner.Entities.ApiRequestTemplatePK;

@Repository
public interface APIRequestTemplateRepository extends CrudRepository<ApiRequestTemplate, ApiRequestTemplatePK>{

	List<ApiRequestTemplate> findByIdApiid(String apiid);
}
