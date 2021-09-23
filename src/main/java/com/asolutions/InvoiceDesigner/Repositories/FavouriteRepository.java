package com.asolutions.InvoiceDesigner.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.FavouritePK;
import com.asolutions.InvoiceDesigner.Entities.Favourite;

@Repository
public interface FavouriteRepository extends CrudRepository<Favourite, FavouritePK> {
	
	List<Favourite> findById_UseridAndId_Pid(String userid, String pid);

}
