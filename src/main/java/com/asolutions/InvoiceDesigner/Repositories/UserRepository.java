package com.asolutions.InvoiceDesigner.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.asolutions.InvoiceDesigner.Entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	
}
