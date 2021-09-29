package com.asolutions.InvoiceDesigner.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.Namespacerep;

@Repository
public interface NamespacerepRepository extends CrudRepository<Namespacerep, String> {

}
