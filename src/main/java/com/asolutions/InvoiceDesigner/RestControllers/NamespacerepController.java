package com.asolutions.InvoiceDesigner.RestControllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.asolutions.InvoiceDesigner.Entities.Namespacerep;
import com.asolutions.InvoiceDesigner.Repositories.NamespacerepRepository;

@RestController
@CrossOrigin(origins = "*")
public class NamespacerepController {

	@Autowired
	private NamespacerepRepository namespacerepRepository;
	
	@GetMapping(value="/namespace/{namespaceId}",
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Optional<Namespacerep> getNamespace(@PathVariable String namespaceId){
		return  namespacerepRepository.findById(namespaceId);	
	}
	
	@GetMapping(value="/namespaces",
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Iterable<Namespacerep> getNamespaces(){
		return  namespacerepRepository.findAll();	
	}
}
