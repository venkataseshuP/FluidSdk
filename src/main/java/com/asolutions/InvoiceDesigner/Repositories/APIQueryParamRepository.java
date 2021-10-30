package com.asolutions.InvoiceDesigner.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.ApiQueryParam;
import com.asolutions.InvoiceDesigner.Entities.ApiQueryParamPK;

@Repository
public interface APIQueryParamRepository extends CrudRepository<ApiQueryParam, ApiQueryParamPK> {

	List<ApiQueryParam> findByIdApiid(String apiid);

}
