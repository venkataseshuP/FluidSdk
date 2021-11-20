package com.asolutions.FluidWeb.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.FluidWeb.Entities.Namespacerep;

@Repository
public interface NamespacerepRepository extends CrudRepository<Namespacerep, String> {

}
