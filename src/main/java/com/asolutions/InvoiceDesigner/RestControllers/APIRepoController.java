package com.asolutions.InvoiceDesigner.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asolutions.InvoiceDesigner.Entities.ApiRepo;
import com.asolutions.InvoiceDesigner.Repositories.APIRepoRepository;

@RestController
@CrossOrigin(origins = "*")
public class APIRepoController {
	
	@Autowired
	private APIRepoRepository apiRepoRepository;
	
	@GetMapping(value = "/{pid}/{apiId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ApiRepo> getApis(@PathVariable String apiId, @PathVariable String pid) {
		try {
			return apiRepoRepository.findByIdPidAndId_apiid(pid, apiId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}
	
	@PostMapping(value = "/api", 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ApiRepo createAPI(@RequestBody ApiRepo api) {
		return apiRepoRepository.save(api);
		
	}
	
	@PutMapping(value = "/api", 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ApiRepo updateAPI(@RequestBody ApiRepo api) {
		return apiRepoRepository.save(api);
		
	}
	

}
