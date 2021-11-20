package com.asolutions.FluidWeb.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.FluidWeb.Entities.ApiHeaderParam;
import com.asolutions.FluidWeb.Entities.ApiHeaderParamPK;

@Repository
public interface APIHeaderParamRepository extends CrudRepository<ApiHeaderParam, ApiHeaderParamPK> {

	List<ApiHeaderParam> findByIdApiid(String apiid);

}
