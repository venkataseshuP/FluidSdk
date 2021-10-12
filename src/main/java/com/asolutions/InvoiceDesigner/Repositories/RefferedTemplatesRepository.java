package com.asolutions.InvoiceDesigner.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.RefferedTemplate;
import com.asolutions.InvoiceDesigner.Entities.RefferedTemplatesPK;

@Repository
public interface RefferedTemplatesRepository extends CrudRepository<RefferedTemplate, RefferedTemplatesPK> {

	List<RefferedTemplate> findByIdTemplateId(String templateId);
}
