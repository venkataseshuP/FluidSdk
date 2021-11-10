package com.asolutions.InvoiceDesigner.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.TypeElement;
import com.asolutions.InvoiceDesigner.Entities.TypeElementPK;

@Repository
public interface TypeElementsRepository extends CrudRepository<TypeElement, TypeElementPK> {

	List<TypeElement> findByIdTypeIdAndId_namespaceId(String typeId, String namespaceId);
	
}
