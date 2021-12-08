package com.asolutions.FluidWeb.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.FluidWeb.Entities.DesignerTypeProperties;
import com.asolutions.FluidWeb.Entities.TypesrepoPK;

@Repository
public interface DesignerTypePropertiesRepository extends CrudRepository<DesignerTypeProperties, TypesrepoPK> {

}
