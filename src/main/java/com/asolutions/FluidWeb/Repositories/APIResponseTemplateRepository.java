package com.asolutions.FluidWeb.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.FluidWeb.Entities.ApiResponseTemplate;
import com.asolutions.FluidWeb.Entities.ApiResponseTemplatePK;

@Repository
public interface APIResponseTemplateRepository extends CrudRepository<ApiResponseTemplate, ApiResponseTemplatePK> {

	List<ApiResponseTemplate> findByIdApiid(String apiid);
}
