package com.asolutions.FluidWeb.RestControllers;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import com.asolutions.FluidWeb.Configurations.MultiTenantManager;
import com.asolutions.FluidWeb.Exceptions.InvalidDbPropertiesException;
import com.asolutions.FluidWeb.Exceptions.InvalidTenantIdExeption;
import com.asolutions.FluidWeb.Exceptions.TenantNotFoundException;
import com.asolutions.FluidWeb.Exceptions.TenantResolvingException;

@RestController
public class AbstractController {

	private static final String MSG_INVALID_TENANT_ID = "[!] DataSource not found for given tenant Id '{}'!";
	private static final String MSG_INVALID_DB_PROPERTIES_ID = "[!] DataSource properties related to the given tenant ('{}') is invalid!";
	private static final String MSG_RESOLVING_TENANT_ID = "[!] Could not resolve tenant ID '{}'!";
	private static final Logger log = LoggerFactory.getLogger(AbstractController.class);
	protected final MultiTenantManager tenantManager;
	
	public AbstractController(MultiTenantManager tenantManager) {
		this.tenantManager = tenantManager;
	}
	
	public void setTenant(String tenantId) {
		try {
			tenantManager.setCurrentTenant(tenantId);
		} catch (SQLException e) {
			log.error(MSG_INVALID_DB_PROPERTIES_ID, tenantId);
			throw new InvalidDbPropertiesException();
		} catch (TenantNotFoundException e) {
			log.error(MSG_INVALID_TENANT_ID, tenantId);
			throw new InvalidTenantIdExeption();
		} catch (TenantResolvingException e) {
			log.error(MSG_RESOLVING_TENANT_ID, tenantId);
			throw new InvalidTenantIdExeption();
		}
	}
}
