package com.asolutions.InvoiceDesigner.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.Typesrepo;
import com.asolutions.InvoiceDesigner.Entities.TypesrepoPK;

@Repository
public interface TypesrepoRepository extends CrudRepository<Typesrepo, TypesrepoPK>{

	List<Typesrepo> findByTemplateId(String templateId);
}
