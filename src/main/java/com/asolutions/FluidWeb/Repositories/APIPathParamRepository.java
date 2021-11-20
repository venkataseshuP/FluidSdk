package com.asolutions.FluidWeb.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.FluidWeb.Entities.ApiPathParam;
import com.asolutions.FluidWeb.Entities.ApiPathParamPK;

@Repository
public interface APIPathParamRepository extends CrudRepository<ApiPathParam, ApiPathParamPK> {

	List<ApiPathParam> findByIdApiid(String apiid);
}
