package com.asolutions.FluidWeb.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.FluidWeb.Entities.RefferedTemplate;
import com.asolutions.FluidWeb.Entities.RefferedTemplatesPK;

@Repository
public interface RefferedTemplatesRepository extends CrudRepository<RefferedTemplate, RefferedTemplatesPK> {

	List<RefferedTemplate> findByIdTemplateId(String templateId);
}
