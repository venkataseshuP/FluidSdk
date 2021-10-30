package com.asolutions.InvoiceDesigner.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.ApiHeaderParam;
import com.asolutions.InvoiceDesigner.Entities.ApiHeaderParamPK;

@Repository
public interface APIHeaderParamRepository extends CrudRepository<ApiHeaderParam, ApiHeaderParamPK> {

	List<ApiHeaderParam> findByIdApiid(String apiid);

}
