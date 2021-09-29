package com.asolutions.InvoiceDesigner.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.RefferedTemplates;

@Repository
public interface RefferedTemplatesRepository extends CrudRepository<RefferedTemplates, String> {

}
