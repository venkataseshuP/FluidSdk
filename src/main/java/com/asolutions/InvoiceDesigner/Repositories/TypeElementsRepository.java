package com.asolutions.InvoiceDesigner.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.TypeElements;
import com.asolutions.InvoiceDesigner.Entities.TypeElementsPK;

@Repository
public interface TypeElementsRepository extends CrudRepository<TypeElements, TypeElementsPK> {

	
}
