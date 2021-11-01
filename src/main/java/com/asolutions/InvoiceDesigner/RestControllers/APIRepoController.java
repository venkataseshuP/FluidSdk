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

import com.asolutions.InvoiceDesigner.Entities.ApiHeaderParam;
import com.asolutions.InvoiceDesigner.Entities.ApiHeaderParamPK;
import com.asolutions.InvoiceDesigner.Entities.ApiPathParam;
import com.asolutions.InvoiceDesigner.Entities.ApiPathParamPK;
import com.asolutions.InvoiceDesigner.Entities.ApiQueryParam;
import com.asolutions.InvoiceDesigner.Entities.ApiQueryParamPK;
import com.asolutions.InvoiceDesigner.Entities.ApiRepo;
import com.asolutions.InvoiceDesigner.Entities.ApiRepoPK;
import com.asolutions.InvoiceDesigner.Entities.ApiRequestTemplate;
import com.asolutions.InvoiceDesigner.Entities.ApiRequestTemplatePK;
import com.asolutions.InvoiceDesigner.Entities.ApiResponseTemplate;
import com.asolutions.InvoiceDesigner.Entities.ApiResponseTemplatePK;
import com.asolutions.InvoiceDesigner.Entities.FileExplorer;
import com.asolutions.InvoiceDesigner.Repositories.APIHeaderParamRepository;
import com.asolutions.InvoiceDesigner.Repositories.APIPathParamRepository;
import com.asolutions.InvoiceDesigner.Repositories.APIQueryParamRepository;
import com.asolutions.InvoiceDesigner.Repositories.APIRepoRepository;
import com.asolutions.InvoiceDesigner.Repositories.APIRequestTemplateRepository;
import com.asolutions.InvoiceDesigner.Repositories.APIResponseTemplateRepository;
import com.asolutions.InvoiceDesigner.Repositories.FileExplorerRepository;

@RestController
@CrossOrigin(origins = "*")
public class APIRepoController {
	
	@Autowired
	private APIRepoRepository apiRepoRepository;
	
	@Autowired
	private APIPathParamRepository apiPathParamRepository;
	
	@Autowired
	private APIQueryParamRepository apiQueryParamRepository;
	
	@Autowired
	private APIHeaderParamRepository apiHeaderParamRepository;
	
	@Autowired
	private APIRequestTemplateRepository apiRequestTemplateRepository;
	
	@Autowired
	private APIResponseTemplateRepository apiResponseTemplateRepository;
	
	@Autowired
	private FileExplorerRepository explorerRepository;
	
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
	
	@PostMapping(value = "/api/headerparam", 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ApiHeaderParam createHeaderParam(@RequestBody ApiHeaderParam apiHeaderParam) {
		UUID uuid = UUID.randomUUID();
		apiHeaderParam.getId().setParamId(uuid.toString());
		return apiHeaderParamRepository.save(apiHeaderParam);
	}
	
	
	@PutMapping(value = "/api/headerparam", 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ApiHeaderParam updateHeaderParam(@RequestBody ApiHeaderParam apiHeaderParam) {
		if(apiHeaderParam.getId().getParamId() == null) {
			UUID uuid = UUID.randomUUID();
			apiHeaderParam.getId().setParamId(uuid.toString());
		}
		return apiHeaderParamRepository.save(apiHeaderParam);
	}
	
	@GetMapping(value = "/{pid}/api/{apiDocId}/{apiId}/headerparams", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ApiHeaderParam> getHeaderParamsForApi(@PathVariable String apiId){
		return apiHeaderParamRepository.findByIdApiid(apiId);
	}
	
	@DeleteMapping(value = "/api/{apiid}/headerparam/{paramId}", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Map<String, String> deleteHeaderParam(@PathVariable String paramId, @PathVariable String apiid){
		Map<String, String> output = new HashMap<>();
		try {
			ApiHeaderParamPK apiHeaderParamPK = new ApiHeaderParamPK();
			apiHeaderParamPK.setApiid(apiid);
			apiHeaderParamPK.setParamId(paramId);
			apiHeaderParamRepository.deleteById(apiHeaderParamPK);
			output.put("status", "success");
		} catch (Exception e) {
			// TODO: handle exception
			output.put("status", "failed");
		}
		return output;
	}
	
	@PostMapping(value = "/api/queryparam", 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ApiQueryParam createQueryParam(@RequestBody ApiQueryParam apiQueryParam) {
		UUID uuid = UUID.randomUUID();
		apiQueryParam.getId().setParamId(uuid.toString());
		return apiQueryParamRepository.save(apiQueryParam);
	}
	
	
	@PutMapping(value = "/api/queryparam", 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ApiQueryParam updateQueryParam(@RequestBody ApiQueryParam apiQueryParam) {
		if(apiQueryParam.getId().getParamId() == null) {
			UUID uuid = UUID.randomUUID();
			apiQueryParam.getId().setParamId(uuid.toString());
		}
		return apiQueryParamRepository.save(apiQueryParam);
	}
	
	@GetMapping(value = "/{pid}/api/{apiDocId}/{apiId}/queryparams", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ApiQueryParam> getQueryParamsForApi(@PathVariable String apiId){
		return apiQueryParamRepository.findByIdApiid(apiId);
	}
	
	@DeleteMapping(value = "/api/{apiid}/queryparam/{paramId}", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Map<String, String> deleteQueryParam(@PathVariable String paramId, @PathVariable String apiid){
		Map<String, String> output = new HashMap<>();
		try {
			ApiQueryParamPK apiQueryParamPK = new ApiQueryParamPK();
			apiQueryParamPK.setApiid(apiid);
			apiQueryParamPK.setParamId(paramId);
			apiQueryParamRepository.deleteById(apiQueryParamPK);
			output.put("status", "success");
		} catch (Exception e) {
			// TODO: handle exception
			output.put("status", "failed");
		}
		return output;
	}
	
	@PostMapping(value = "/api/requesttemplate", 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ApiRequestTemplate createRequestTemplate(@RequestBody ApiRequestTemplate apiRequestTemplate) {
		UUID uuid = UUID.randomUUID();
		apiRequestTemplate.getId().setRequestId(uuid.toString());
		return apiRequestTemplateRepository.save(apiRequestTemplate);
	}
	
	
	@PutMapping(value = "/api/requesttemplate", 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ApiRequestTemplate updateRequestTemplate(@RequestBody ApiRequestTemplate apiRequestTemplate) {
		if(apiRequestTemplate.getId().getRequestId() == null) {
			UUID uuid = UUID.randomUUID();
			apiRequestTemplate.getId().setRequestId(uuid.toString());
		}
		return apiRequestTemplateRepository.save(apiRequestTemplate);
	}
	
	@GetMapping(value = "/{pid}/api/{apiDocId}/{apiId}/requesttemplates", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ApiRequestTemplate> getRequestTemplatesForApi(@PathVariable String apiId, @PathVariable String pid){
		List<ApiRequestTemplate> requestTemplates = apiRequestTemplateRepository.findByIdApiid(apiId);
		for(ApiRequestTemplate requestTemplate: requestTemplates) {
			FileExplorer explorer = explorerRepository.findByIdPidAndId_itemId(pid, requestTemplate.getTemplateId());
			if(explorer != null)
				requestTemplate.setTemplatename(explorer.getName());
		}
		return requestTemplates;
	}
	
	@DeleteMapping(value = "/api/{apiid}/requesttemplate/{requestId}", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Map<String, String> deleteRequestTemplate(@PathVariable String requestId, @PathVariable String apiid){
		Map<String, String> output = new HashMap<>();
		try {
			ApiRequestTemplatePK apiRequestTemplatePK = new ApiRequestTemplatePK();
			apiRequestTemplatePK.setApiid(apiid);
			apiRequestTemplatePK.setRequestId(requestId);
			apiRequestTemplateRepository.deleteById(apiRequestTemplatePK);
			output.put("status", "success");
		} catch (Exception e) {
			// TODO: handle exception
			output.put("status", "failed");
		}
		return output;
	}
	
	@PostMapping(value = "/api/responsetemplate", 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ApiResponseTemplate createResponseTemplate(@RequestBody ApiResponseTemplate apiResponseTemplate) {
		UUID uuid = UUID.randomUUID();
		apiResponseTemplate.getId().setResponseId(uuid.toString());
		return apiResponseTemplateRepository.save(apiResponseTemplate);
	}
	
	
	@PutMapping(value = "/api/responsetemplate", 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ApiResponseTemplate updateResponseTemplate(@RequestBody ApiResponseTemplate apiResponseTemplate) {
		if(apiResponseTemplate.getId().getResponseId() == null) {
			UUID uuid = UUID.randomUUID();
			apiResponseTemplate.getId().setResponseId(uuid.toString());
		}
		return apiResponseTemplateRepository.save(apiResponseTemplate);
	}
	
	@GetMapping(value = "/{pid}/api/{apiDocId}/{apiId}/responsetemplates", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ApiResponseTemplate> getResponseTemplatesForApi(@PathVariable String apiId, @PathVariable String pid){
		List<ApiResponseTemplate> responsetemplates = apiResponseTemplateRepository.findByIdApiid(apiId);
		for(ApiResponseTemplate responsetemplate: responsetemplates) {
			FileExplorer explorer = explorerRepository.findByIdPidAndId_itemId(pid, responsetemplate.getTemplateId());
			if(explorer != null)
				responsetemplate.setTemplatename(explorer.getName());
		}
		return responsetemplates;
	}
	
	@DeleteMapping(value = "/api/{apiid}/requesttemplate/{responseId}", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Map<String, String> deleteResponseTemplate(@PathVariable String responseId, @PathVariable String apiid){
		Map<String, String> output = new HashMap<>();
		try {
			ApiResponseTemplatePK apiResponseTemplatePK = new ApiResponseTemplatePK();
			apiResponseTemplatePK.setApiid(apiid);
			apiResponseTemplatePK.setResponseId(responseId);
			apiResponseTemplateRepository.deleteById(apiResponseTemplatePK);
			output.put("status", "success");
		} catch (Exception e) {
			// TODO: handle exception
			output.put("status", "failed");
		}
		return output;
	}

}
