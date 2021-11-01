package com.asolutions.InvoiceDesigner.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.ApiResponseTemplate;
import com.asolutions.InvoiceDesigner.Entities.ApiResponseTemplatePK;

@Repository
public interface APIResponseTemplateRepository extends CrudRepository<ApiResponseTemplate, ApiResponseTemplatePK> {

	List<ApiResponseTemplate> findByIdApiid(String apiid);
}
