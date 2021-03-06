package com.asolutions.FluidWeb.RestControllers;

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

import com.asolutions.FluidWeb.Entities.Favourite;
import com.asolutions.FluidWeb.Entities.FavouritePK;
import com.asolutions.FluidWeb.Repositories.FavouriteRepository;

@RestController
@CrossOrigin(origins = "*")
public class FavouriteRestController {

	@Autowired
	private FavouriteRepository favouritesRepository;

	@GetMapping(value = "/{userid}/{pid}/favourites", produces = { MediaType.APPLICATION_JSON_VALUE })
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
	public Favourite addFavourite(@RequestBody Favourite favourite) {
		return favouritesRepository.save(favourite);
		
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
	
	@DeleteMapping(value="/{pid}/favourite/{itemId}")
	public void deleteFavouriteByItemId(@PathVariable String pid,@PathVariable String itemId) {
		try {
			favouritesRepository.deleteByItemId_Pid(itemId, pid);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}		
	}

}
