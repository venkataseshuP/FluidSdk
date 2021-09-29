package com.asolutions.InvoiceDesigner.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.Typesrepo;

@Repository
public interface TypesrepoRepository extends CrudRepository<Typesrepo, String>{

}
