package com.asolutions.FluidWeb.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.FluidWeb.Entities.Template;

@Repository
public interface TemplateRepository extends CrudRepository<Template, String> {

}
