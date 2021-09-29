package com.asolutions.InvoiceDesigner.Repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.FavouritePK;
import com.asolutions.InvoiceDesigner.Entities.Favourite;

@Repository
public interface FavouriteRepository extends CrudRepository<Favourite, FavouritePK> {
	
	List<Favourite> findById_UseridAndId_Pid(String userid, String pid);
	
	@Transactional
	@Modifying
    @Query(value = "DELETE FROM Favourite WHERE itemid = :itemId and pid = :pid")
    void deleteByItemId_Pid(@Param("itemId") String itemId, @Param("pid") String pid ); 

}
