package com.asolutions.FluidWeb.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.FluidWeb.Entities.ComplexType;
import com.asolutions.FluidWeb.Entities.TypesrepoPK;

@Repository
public interface ComplexTypeRepository extends CrudRepository<ComplexType, TypesrepoPK>{
}
