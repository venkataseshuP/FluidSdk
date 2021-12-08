package com.asolutions.FluidWeb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.asolutions.FluidWeb.Configurations.MultiTenantManager;
import com.asolutions.FluidWeb.Entities.Project;
import com.asolutions.FluidWeb.Entities.ProjectProperties;
import com.asolutions.FluidWeb.Exceptions.TenantNotFoundException;
import com.asolutions.FluidWeb.Exceptions.TenantResolvingException;
import com.asolutions.FluidWeb.Repositories.ProjectRepository;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class FluidWebApplication {

	private static final Logger log = LoggerFactory.getLogger(FluidWebApplication.class);
	
	private final MultiTenantManager tenantManager;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public FluidWebApplication(MultiTenantManager tenantManager) {
		this.tenantManager = tenantManager;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FluidWebApplication.class, args);
	}
	
	@SneakyThrows(IOException.class)
	@EventListener
	public void onReady(ApplicationReadyEvent event) throws FileNotFoundException, IOException {

		File[] files = Paths.get("tenants/onStartUp").toFile().listFiles();

		if (files == null) {
			log.warn("[!] Tenant property files not found at ./tenants/onStartUp folder!");
			return;
		}

		for (File propertyFile : files) {
			Properties tenantProperties = new Properties();
			tenantProperties.load(new FileInputStream(propertyFile));

			String tenantId = tenantProperties.getProperty("id");
			String url = tenantProperties.getProperty("url");
			String username = tenantProperties.getProperty("username");
			String password = tenantProperties.getProperty("password");

			try {
				tenantManager.addTenant(tenantId, url, username, password);
				log.info("[i] Loaded DataSource for tenant '{}'.", tenantId);
			} catch (SQLException e) {
				log.error("[!] Could not load DataSource for tenant '%s'!", tenantId, e);
			}
		}
		try {
			tenantManager.setCurrentTenant("common");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TenantNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TenantResolvingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Iterable<Project> projects =  projectRepository.findAll();
		for(Project project:projects) {
			ProjectProperties tenantProperties = project.getProperties();
			String tenantId = tenantProperties.getPid();
			String url = tenantProperties.getUrl();
			String username = tenantProperties.getUserName();
			String password = tenantProperties.getPassword();
			
			try {
				tenantManager.addTenant(tenantId, url, username, password);
				log.info("[i] Loaded DataSource for tenant '{}'.", project.getProjectName());
			} catch (SQLException e) {
				log.error("[!] Could not load DataSource for tenant '%s'!", project.getProjectName(), e);
			}
		}
	}

}
