package com.asolutions.FluidWeb.Interceptors;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.asolutions.FluidWeb.Configurations.MultiTenantManager;
import com.asolutions.FluidWeb.Exceptions.InvalidDbPropertiesException;
import com.asolutions.FluidWeb.Exceptions.InvalidTenantIdExeption;
import com.asolutions.FluidWeb.Exceptions.TenantNotFoundException;
import com.asolutions.FluidWeb.Exceptions.TenantResolvingException;
import com.asolutions.FluidWeb.RestControllers.FileExplorerRestController;

@Component
public class PreRequestInterceptor implements HandlerInterceptor {
	
	private static final String MSG_INVALID_TENANT_ID = "[!] DataSource not found for given tenant Id '{}'!";
	private static final String MSG_INVALID_DB_PROPERTIES_ID = "[!] DataSource properties related to the given tenant ('{}') is invalid!";
	private static final String MSG_RESOLVING_TENANT_ID = "[!] Could not resolve tenant ID '{}'!";
	private static final Logger log = LoggerFactory.getLogger(FileExplorerRestController.class);
	
	private final MultiTenantManager tenantManager;
	
	public PreRequestInterceptor(MultiTenantManager tenantManager) {
		this.tenantManager = tenantManager;
	}
	   @Override
	   public boolean preHandle(
	      HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	      String tenantId = request.getHeader("tenantId");
	      log.info("tentanId assigned value :"+tenantId);
	      if(tenantId == null || tenantId == "") {
	    	  tenantId = "common";
	      }
	      setTenant(tenantId);
	      return true;
	   }
	   
		private void setTenant(String tenantId) {
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
