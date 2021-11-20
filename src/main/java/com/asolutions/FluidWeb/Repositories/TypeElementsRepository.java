package com.asolutions.FluidWeb.Repositories;

import java.util.LinkedList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asolutions.FluidWeb.Entities.TypeElement;
import com.asolutions.FluidWeb.Entities.TypeElementPK;

@Repository
public interface TypeElementsRepository extends CrudRepository<TypeElement, TypeElementPK> {

	LinkedList<TypeElement> findByIdTypeIdAndId_namespaceIdOrderById_slNoAsc(String typeId, String namespaceId);
	@Transactional
	@Modifying
    @Query(value = "delete from TypeElement where id.typeId =:typeId")
	void deleteTypeElementsByTypeId(@Param("typeId") String typeId);
	
}
