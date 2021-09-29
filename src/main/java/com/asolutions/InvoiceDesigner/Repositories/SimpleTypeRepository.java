package com.asolutions.InvoiceDesigner.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.SimpleType;

@Repository
public interface SimpleTypeRepository extends CrudRepository<SimpleType, String> {

}
