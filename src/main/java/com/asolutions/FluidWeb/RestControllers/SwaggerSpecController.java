package com.asolutions.FluidWeb.RestControllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asolutions.FluidWeb.Entities.FileExplorerPK;
import com.asolutions.FluidWeb.Entities.SwaggerSpec;
import com.asolutions.FluidWeb.Repositories.SwaggerSpecRepository;

@RestController
@CrossOrigin(origins = "*")
public class SwaggerSpecController {
	
	@Autowired
	private SwaggerSpecRepository specRepository;

	@PostMapping(value="/swagger/spec",
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public SwaggerSpec createFile(@RequestBody SwaggerSpec spec){
		return specRepository.save(spec);
	}
	
	@GetMapping(value="/{pid}/spec/{specId}")
	public Optional<SwaggerSpec> getSpecById(@PathVariable String specId,@PathVariable String pid) {
		FileExplorerPK explorerPK =  new FileExplorerPK();
		explorerPK.setPid(pid);
		explorerPK.setItemId(specId);
		return specRepository.findById(explorerPK);
		
	}
	
	@DeleteMapping(value="/{pid}/spec/{itemId}",			
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Map<String, String> deleteFile(@PathVariable String itemId, @PathVariable String pid) {
		Map<String, String> output =  new HashMap<String, String>();
		try {
			FileExplorerPK explorerPK =  new FileExplorerPK();
			explorerPK.setItemId(itemId);
			explorerPK.setPid(pid);
			specRepository.deleteById(explorerPK);
			output.put("status", "success") ;
		} catch (Exception e) {
			// TODO: handle exception
			output.put("status", "failed") ;
		}		
		return output;
	}
}
