package com.asolutions.FluidWeb.Repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asolutions.FluidWeb.Entities.Typesrepo;
import com.asolutions.FluidWeb.Entities.TypesrepoPK;

@Repository
public interface TypesrepoRepository extends CrudRepository<Typesrepo, TypesrepoPK>{

	List<Typesrepo> findByTemplateId(String templateId);
	
	List<Typesrepo> findByType(String type);
	
	@Transactional
	@Modifying
    @Query(value = "SELECT c.id , c.typeName , c.type , c.templateId FROM Typesrepo c WHERE UPPER(c.typeName) like %:typeName% and c.type =:type")
	List<Object[]> findByTypeNameAndType(@Param("typeName") String typeName, @Param("type") String type);
	
	Typesrepo findByIdTypeId(String typeId);
}
