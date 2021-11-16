package com.asolutions.InvoiceDesigner.Repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.TypeElement;
import com.asolutions.InvoiceDesigner.Entities.TypeElementPK;

@Repository
public interface TypeElementsRepository extends CrudRepository<TypeElement, TypeElementPK> {

	List<TypeElement> findByIdTypeIdAndId_namespaceId(String typeId, String namespaceId);
	@Transactional
	@Modifying
    @Query(value = "delete from TypeElement where id.typeId =:typeId")
	void deleteTypeElementsByTypeId(@Param("typeId") String typeId);
	
}
