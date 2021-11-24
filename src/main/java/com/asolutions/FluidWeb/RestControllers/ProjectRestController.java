package com.asolutions.FluidWeb.RestControllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asolutions.FluidWeb.Entities.Project;
import com.asolutions.FluidWeb.Entities.ProjectProperties;
import com.asolutions.FluidWeb.Repositories.ProjectRepository;


@RestController
@CrossOrigin(origins = "*")
public class ProjectRestController {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@PostMapping(value="/project/init",
			consumes= {MediaType.APPLICATION_JSON_VALUE})
	public boolean  runScripts(@RequestBody Project project) throws SQLException{
		if(project.getPid() == null || project.getProjectName() == null || project.getProperties().getUrl() == null ||
				project.getProperties().getDriverClass() == null || project.getProperties().getPassword() == null ||project.getProperties().getUserName() == null ) {
			return false;
		}
		return validateDBConnectionAndRunScripts(project);
	}
	
	private boolean validateDBConnectionAndRunScripts(Project project) throws SQLException {
		ProjectProperties properties =  project.getProperties();
		if(properties != null) {
			String url = properties.getUrl()+";DB_CLOSE_ON_EXIT=FALSE;INIT=RUNSCRIPT FROM 'D:/FluidWeb/src/main/resources/insertScripts/insert.sql';" ;
			DataSource dataSource = DataSourceBuilder.create()
					.driverClassName(properties.getDriverClass())
					.url(url)
					.username(properties.getUserName())
					.password(properties.getPassword())
					.build();

			// Check that new connection is 'live'. If not - throw exception
			Connection con = null;
			try {
				con = dataSource.getConnection();
				UUID uuid = UUID.randomUUID();
				String uuidNo = uuid.toString();
				if(project.getPid() == null) {
					project.setPid(uuidNo);
					project.getProperties().setPid(uuidNo);
				}
				project.setInit(true);
				projectRepository.save(project);
			}catch (Exception e) {
				return false;
			}finally {
				if(con != null) {
					con.close();
				}
			}
		}
		return true;		
	}
	
	@GetMapping(value="/projects",
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Iterable<Project> getProjects(){
		return  projectRepository.findAll();
	}
	
	@PutMapping(value="/project",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Project updateProject(@RequestBody Project project){
		UUID uuid = UUID.randomUUID();
		String uuidNo = uuid.toString();
		if(project.getPid() == null) {
			project.setPid(uuidNo);
			project.getProperties().setPid(uuidNo);
		}
		return  projectRepository.save(project);
	}
}
