package com.asolutions.InvoiceDesigner.RestControllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asolutions.InvoiceDesigner.Entities.FavouritePK;
import com.asolutions.InvoiceDesigner.Entities.Favourite;
import com.asolutions.InvoiceDesigner.Repositories.FavouriteRepository;

@RestController
@CrossOrigin(origins = "*")
public class FavouriteRestController {

	@Autowired
	private FavouriteRepository favouritesRepository;

	@GetMapping(value = "/{userid}/{pid}/files", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Iterable<Favourite> getFavourites(@PathVariable String userid, @PathVariable String pid) {
		try {
			return favouritesRepository.findById_UseridAndId_Pid(userid, pid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	@PostMapping(value = "/favourite", 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Iterable<Favourite> addFavourite(@RequestBody Favourite favourite) {
		favouritesRepository.save(favourite);
		return favouritesRepository.findById_UseridAndId_Pid(favourite.getId().getUserid(),favourite.getId().getPid());
	}
	
	@DeleteMapping(value="/{userId}/{pid}/favourite/{itemId}", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Map<String, String> deleteFavourite(@PathVariable String userId, @PathVariable String pid,@PathVariable String itemId) {
		Map<String, String> output =  new HashMap<String, String>();
		try {
			FavouritePK favouritePK =  new FavouritePK();
			favouritePK.setItemid(itemId);
			favouritePK.setPid(pid);
			favouritePK.setUserid(userId);
			favouritesRepository.deleteById(favouritePK);
			output.put("status", "success") ;
		} catch (Exception e) {
			// TODO: handle exception
			output.put("status", "failed") ;
		}		
		return output;
	}

}
