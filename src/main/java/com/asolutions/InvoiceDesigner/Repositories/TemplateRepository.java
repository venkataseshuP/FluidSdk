package com.asolutions.InvoiceDesigner.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.Template;

@Repository
public interface TemplateRepository extends CrudRepository<Template, String> {

}
