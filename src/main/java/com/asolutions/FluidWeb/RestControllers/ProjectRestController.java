package com.asolutions.FluidWeb.RestControllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asolutions.FluidWeb.Configurations.MultiTenantManager;
import com.asolutions.FluidWeb.Entities.Project;
import com.asolutions.FluidWeb.Entities.ProjectProperties;
import com.asolutions.FluidWeb.Repositories.ProjectRepository;


@RestController
@CrossOrigin(origins = "*")
public class ProjectRestController extends AbstractController {
	
	private static final Logger log = LoggerFactory.getLogger(ProjectRestController.class);
	
	public ProjectRestController(MultiTenantManager tenantManager) {
		super(tenantManager); 
	}

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
			ProjectProperties tenantProperties = project.getProperties();
			String tenantId = tenantProperties.getPid();
			String url = tenantProperties.getUrl();
			String username = tenantProperties.getUserName();
			String password = tenantProperties.getPassword();
			
			String finalurl = url+";DB_CLOSE_ON_EXIT=FALSE;INIT=RUNSCRIPT FROM 'D:/FluidWeb/src/main/resources/insertScripts/insert.sql';" ;
			DataSource dataSource = DataSourceBuilder.create()
					.driverClassName(properties.getDriverClass())
					.url(finalurl)
					.username(properties.getUserName())
					.password(properties.getPassword())
					.build();

			// Check that new connection is 'live'. If not - throw exception
			Connection con = null;
			try {
				con = dataSource.getConnection();
				UUID uuid = UUID.randomUUID();
				String uuidNo = uuid.toString();
				Statement statement = con.createStatement();
				String query = "INSERT INTO FILE_EXPLORER(ID,PID,NAME,PARENT_ID,TYPE,PATH) VALUES('FE_0000001','"+uuidNo+"','Home','','1','/Home')";
				statement.execute(query);
				if(project.getPid() == null) {
					project.setPid(uuidNo);
					project.getProperties().setPid(uuidNo);
				}
				project.setInit(true);
				projectRepository.save(project);
				try {
					tenantManager.addTenant(tenantId, url, username, password);
					log.info("[i] Loaded DataSource for tenant '{}'.", tenantId);
				} catch (SQLException e) {
					log.error("[!] Could not load DataSource for tenant '%s'!", tenantId, e);
				}
			}catch (Exception e) {
				System.out.println(e);
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
