package com.asolutions.InvoiceDesigner.RestControllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asolutions.InvoiceDesigner.Entities.ApiPathParam;
import com.asolutions.InvoiceDesigner.Entities.ApiPathParamPK;
import com.asolutions.InvoiceDesigner.Entities.ApiRepo;
import com.asolutions.InvoiceDesigner.Entities.ApiRepoPK;
import com.asolutions.InvoiceDesigner.Repositories.APIPathParamRepository;
import com.asolutions.InvoiceDesigner.Repositories.APIRepoRepository;

@RestController
@CrossOrigin(origins = "*")
public class APIRepoController {
	
	@Autowired
	private APIRepoRepository apiRepoRepository;
	
	@Autowired
	private APIPathParamRepository apiPathParamRepository;
	
	@GetMapping(value = "/{pid}/apis/{apidocId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ApiRepo> getApis(@PathVariable String apidocId, @PathVariable String pid) {
		try {
			return apiRepoRepository.findByIdPidAndId_apidocId(pid, apidocId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}
	
	@PostMapping(value = "/api", 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ApiRepo createAPI(@RequestBody ApiRepo api) {
		UUID uuid = UUID.randomUUID();
		api.getId().setApiid(uuid.toString());
		return apiRepoRepository.save(api);
		
	}
	
	@PutMapping(value = "/api", 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ApiRepo updateAPI(@RequestBody ApiRepo api) {
		return apiRepoRepository.save(api);		
	}
	
	@GetMapping(value = "/{pid}/api/{apiDocId}/{apiId}", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Optional<ApiRepo> getAPI( @PathVariable String pid,  @PathVariable String apiDocId,  @PathVariable String apiId) {
		ApiRepoPK apiRepoPK = new ApiRepoPK();
		apiRepoPK.setApidocId(apiDocId);
		apiRepoPK.setApiid(apiId);
		apiRepoPK.setPid(pid);
		return apiRepoRepository.findById(apiRepoPK);
	}
	
	@PostMapping(value = "/api/pathparam", 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ApiPathParam createPathParam(@RequestBody ApiPathParam apiPathParam) {
		UUID uuid = UUID.randomUUID();
		apiPathParam.getId().setParamId(uuid.toString());
		return apiPathParamRepository.save(apiPathParam);
	}
	
	
	@PutMapping(value = "/api/pathparam", 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ApiPathParam updatePathParam(@RequestBody ApiPathParam apiPathParam) {
		if(apiPathParam.getId().getParamId() == null) {
			UUID uuid = UUID.randomUUID();
			apiPathParam.getId().setParamId(uuid.toString());
		}
		return apiPathParamRepository.save(apiPathParam);
	}
	
	@GetMapping(value = "/{pid}/api/{apiDocId}/{apiId}/pathparams", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ApiPathParam> getPathParamsForApi(@PathVariable String apiId){
		return apiPathParamRepository.findByIdApiid(apiId);
	}
	
	@DeleteMapping(value = "/api/{apiid}/pathparam/{paramId}", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Map<String, String> deletePathParam(@PathVariable String paramId, @PathVariable String apiid){
		Map<String, String> output = new HashMap<>();
		try {
			ApiPathParamPK apiPathParamPK = new ApiPathParamPK();
			apiPathParamPK.setApiid(apiid);
			apiPathParamPK.setParamId(paramId);
			apiPathParamRepository.deleteById(apiPathParamPK);
			output.put("status", "success");
		} catch (Exception e) {
			// TODO: handle exception
			output.put("status", "failed");
		}
		return output;
	}

}
