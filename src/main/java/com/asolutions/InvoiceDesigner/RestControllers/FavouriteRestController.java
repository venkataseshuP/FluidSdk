package com.asolutions.InvoiceDesigner.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.asolutions.InvoiceDesigner.Entities.Favourites;
import com.asolutions.InvoiceDesigner.Repositories.FavouritesRepository;

@RestController
@CrossOrigin(origins = "*")
public class FavouriteRestController {
	
	@Autowired
	private FavouritesRepository favouritesRepository;
	
	@GetMapping(value="/{userid}/{pid}/files",			
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Iterable<Favourites> getFavourites(@PathVariable String userid, @PathVariable String pid ){
		try {
			
			return favouritesRepository.findById_UseridAndId_Pid(userid, pid);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;		
		
	}
	

}
