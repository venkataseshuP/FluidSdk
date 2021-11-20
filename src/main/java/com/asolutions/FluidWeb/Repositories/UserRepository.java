package com.asolutions.FluidWeb.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.FluidWeb.Entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	
}
