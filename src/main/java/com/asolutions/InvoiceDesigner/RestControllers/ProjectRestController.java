package com.asolutions.InvoiceDesigner.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.asolutions.InvoiceDesigner.Entities.Project;
import com.asolutions.InvoiceDesigner.Repositories.ProjectRepository;


@RestController
@CrossOrigin(origins = "*")
public class ProjectRestController {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@PostMapping(value="/project",
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Project  createProject(@RequestBody Project project){
		return projectRepository.save(project);
	}
	
	@GetMapping(value="/projects",
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Iterable<Project> getFiles(){
		return  projectRepository.findAll();
	}
}
