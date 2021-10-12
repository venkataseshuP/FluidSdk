package com.asolutions.InvoiceDesigner.RestControllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asolutions.InvoiceDesigner.Entities.ComplexType;
import com.asolutions.InvoiceDesigner.Entities.FileExplorerPK;
import com.asolutions.InvoiceDesigner.Entities.RefferedTemplate;
import com.asolutions.InvoiceDesigner.Entities.SimpleType;
import com.asolutions.InvoiceDesigner.Entities.Template;
import com.asolutions.InvoiceDesigner.Entities.TypeElements;
import com.asolutions.InvoiceDesigner.Entities.Typesrepo;
import com.asolutions.InvoiceDesigner.Repositories.ComplexTypeRepository;
import com.asolutions.InvoiceDesigner.Repositories.FileExplorerRepository;
import com.asolutions.InvoiceDesigner.Repositories.RefferedTemplatesRepository;
import com.asolutions.InvoiceDesigner.Repositories.SimpleTypeRepository;
import com.asolutions.InvoiceDesigner.Repositories.TemplateRepository;
import com.asolutions.InvoiceDesigner.Repositories.TypeElementsRepository;
import com.asolutions.InvoiceDesigner.Repositories.TypesrepoRepository;

@RestController
@CrossOrigin(origins = "*")
public class TemplateRestController {
	
	@Autowired
	private FileExplorerRepository fileExplorerRepository;
	@Autowired
	private TemplateRepository templateRepository;
	@Autowired
	private TypesrepoRepository typesrepoRepository;
	@Autowired
	private ComplexTypeRepository complexTypeRepository;
	@Autowired
	private SimpleTypeRepository simpleTypeRepository;
	@Autowired
	private TypeElementsRepository typeElementsRepository;
	@Autowired
	private RefferedTemplatesRepository refferedTemplatesRepository;
	
//	-------------------------  Template APIs  ------------------------------------------------------
	@PostMapping(value="/template",
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Template createTemplate(@RequestBody Template template){
		return templateRepository.save(template);
	}
	
	@GetMapping(value="/templates",
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Iterable<Template> getTemplates(){
		return templateRepository.findAll();
	}
	
	@GetMapping(value="/template/{templateId}")
	public Optional<Template> getTemplateById(@PathVariable String templateId){
		return templateRepository.findById(templateId);	
	}
	
	@PostMapping(value="/templates",
			consumes= {MediaType.APPLICATION_JSON_VALUE})
	public String createTemplates(@RequestBody Template[] templates) {
		for(Template template:templates) {
			templateRepository.save(template);
		}
		return "success";	
	}
	
//	-------------------------  TyesRepo APIs  ------------------------------------------------------
	
	@PostMapping(value="/template/typesrep",
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Typesrepo createTypesrepo(@RequestBody Typesrepo typesrepo){
        UUID uuid = UUID.randomUUID();
		typesrepo.getId().setTypeId(uuid.toString());
		return typesrepoRepository.save(typesrepo);
	}
	
	@PutMapping(value="/template/typesrep",
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Typesrepo updateTypesrepo(@RequestBody Typesrepo typesrepo){
		return typesrepoRepository.save(typesrepo);
	}
	
	@GetMapping(value="/template/{templateId}/nativecomponents",
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Iterable<Typesrepo> getNativeComponents(@PathVariable String templateId){		
		return typesrepoRepository.findByTemplateId(templateId);
	}
//	-------------------------  ComplexType APIs  ------------------------------------------------------
	
	@PostMapping(value="/template/complextype",
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public ComplexType createComplexType(@RequestBody ComplexType complexType){
		return complexTypeRepository.save(complexType);
	}

//	-------------------------  SimpleType APIs  ------------------------------------------------------
	
	@PostMapping(value="/template/simpeltype",
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public SimpleType createSimpleType(@RequestBody SimpleType simpleType){
		return simpleTypeRepository.save(simpleType);
	}
	
//	-------------------------  TypeElements APIs  ------------------------------------------------------
	
	@PostMapping(value="/template/typeelements/typeId/namespaceId",
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Map<String, String> createTypeElements(@PathVariable String typeId,@PathVariable String namespaceId,@RequestBody List<TypeElements> typeElements){
		Map<String, String> response = new HashMap<>();
		for(TypeElements typeElement: typeElements) {
			typeElementsRepository.save(typeElement);
		}
		response.put("Status", "Success");
		return response;
	}
	
//	-------------------------  RefferedTemplates APIs  ------------------------------------------------------
	
	@PostMapping(value="/refferedtemplate",
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public RefferedTemplate createTypesrepo(@RequestBody RefferedTemplate refferedTemplate){
		return refferedTemplatesRepository.save(refferedTemplate);
	}
	
	@GetMapping(value="{pid}/referredtemplates/{templateId}")
	public List<Map<String, Object>> getRefferedTemplates(@PathVariable String pid, @PathVariable String templateId){
		List<Map<String, Object>> response =  new ArrayList<Map<String,Object>>();
		List<RefferedTemplate> refferedTemplates = refferedTemplatesRepository.findByIdTemplateId(templateId);
		for(RefferedTemplate refferedTemplate: refferedTemplates ) {
			Map<String, Object> templateDetails =  new HashMap<String, Object>();
			FileExplorerPK explorerPK =  new FileExplorerPK();
			explorerPK.setPid(pid);
			explorerPK.setItemId(refferedTemplate.getId().getRefferedTemplateId());
			templateDetails.put("details", fileExplorerRepository.findById(explorerPK));
			templateDetails.put("nativeComponents", getNativeComponents(refferedTemplate.getId().getRefferedTemplateId()));
			response.add(templateDetails);
		}
		return response;	
	}
	
	
}

