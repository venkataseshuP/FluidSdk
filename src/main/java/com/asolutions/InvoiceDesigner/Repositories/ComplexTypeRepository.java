package com.asolutions.InvoiceDesigner.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.ComplexType;
import com.asolutions.InvoiceDesigner.Entities.TypesrepoPK;

@Repository
public interface ComplexTypeRepository extends CrudRepository<ComplexType, TypesrepoPK>{
}
