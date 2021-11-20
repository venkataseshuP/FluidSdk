package com.asolutions.FluidWeb.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.FluidWeb.Entities.ApiRequestTemplate;
import com.asolutions.FluidWeb.Entities.ApiRequestTemplatePK;

@Repository
public interface APIRequestTemplateRepository extends CrudRepository<ApiRequestTemplate, ApiRequestTemplatePK>{

	List<ApiRequestTemplate> findByIdApiid(String apiid);
}
