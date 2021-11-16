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
import com.asolutions.InvoiceDesigner.Entities.TypeElement;
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
	private FileExplorerRestController fileExplorerRestController;
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
		List<Typesrepo> nativecomponents = typesrepoRepository.findByTemplateId(templateId);
		Optional<Template> template =  templateRepository.findById(templateId);
		if(template.isPresent() && template.get().getRoottypeId() != null) {
			Typesrepo typesrepo = new Typesrepo();  
			typesrepo = typesrepoRepository.findByIdTypeId(template.get().getRoottypeId());
			if(typesrepo != null) {
				typesrepo.setType("R");
			}
		}
		nativecomponents.addAll(typesrepoRepository.findByType("PT"));
		return nativecomponents;
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
	
	@PostMapping(value="/template/typeelements/{typeId}/{namespaceId}",
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Map<String, String> createTypeElements(@PathVariable String typeId,@PathVariable String namespaceId,@RequestBody List<TypeElement> typeElements){
		Map<String, String> response = new HashMap<>();
		for(TypeElement typeElement: typeElements) {
			typeElementsRepository.save(typeElement);
		}
		response.put("Status", "Success");
		return response;
	}
	
	
	@PutMapping(value="/template/typeelements/{typeId}",
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Map<String, String> updateTypeElements(@PathVariable String typeId,@RequestBody List<TypeElement> typeElements){
		Map<String, String> response = new HashMap<>();
		typeElementsRepository.deleteTypeElementsByTypeId(typeId);
		for(TypeElement typeElement: typeElements) {
			typeElementsRepository.save(typeElement);
		}
		response.put("Status", "Success");
		return response;
	}
	
	@PutMapping(value="/template/typeelement/{typeId}",
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public TypeElement updateTypeElement(@PathVariable String typeId,@RequestBody TypeElement typeElement){		
		return typeElementsRepository.save(typeElement);
	}
	
	@GetMapping(value="/template/typeelements/{typeId}",
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Typesrepo getTypeelementsForType(@PathVariable String typeId) {
		Typesrepo typesrepo = typesrepoRepository.findByIdTypeId(typeId);		
		return getTypeWithTypeElements(typesrepo);
	}
	
	private Typesrepo getTypeWithTypeElements(Typesrepo typesrepo) {
		if(typesrepo == null) return typesrepo;
		List<TypeElement> typeElements = typeElementsRepository.findByIdTypeIdAndId_namespaceId(typesrepo.getId().getTypeId(),typesrepo.getId().getNamespaceId() );
		for(TypeElement typeElement:typeElements) {
			typeElement.setTypesrepo(getTypesrepoFromTypeelement(typeElement));
		}
		typesrepo.setTypeelements(typeElements);
		return typesrepo;
	}
	
	private Typesrepo getTypesrepoFromTypeelement(TypeElement typeElement) {
		if(typeElement == null) return null;
		Typesrepo typesrepo = typesrepoRepository.findByIdTypeId(typeElement.getElementTypeId());
		typesrepo = getTypeWithTypeElements(typesrepo);
		return typesrepo;
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
	
	@GetMapping(value="{pid}/findByTypeNameAndType/{type}/{typeName}")
	public List<HashMap<String, Object>> findByTypeNameAndType(@PathVariable String pid, @PathVariable String type, @PathVariable String typeName){
		HashMap<String, String> templateIdWisePath =  new HashMap<>();
		List<HashMap<String, Object>> types = new ArrayList<>();
		List<Object[]> allTypes = typesrepoRepository.findByTypeNameAndType(typeName, type);
				for(Object[] typedata: allTypes) {
					HashMap<String, Object> typedetails = new HashMap<>();
					typedetails.put("id", typedata[0]);
					typedetails.put("templateId", typedata[3]);
					typedetails.put("typeName", typedata[1]);
					typedetails.put("type", typedata[2]);
					typedetails.put("templateName", "");
					if(!templateIdWisePath.containsKey(typedata[3].toString())) {
						String path = fileExplorerRestController.getFileFullPath(typedata[3].toString() ,pid);
						typedetails.put("path", path);
						templateIdWisePath.put(typedata[3].toString(), path);
					}else {
						typedetails.put("path", templateIdWisePath.get(typedata[3].toString()));
					}
					types.add(typedetails);
				}
		return types;
	}
		
	
}

