package com.asolutions.FluidWeb.RestControllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;

@RestController
@CrossOrigin(origins = "*")
public class SwaggerParser {

	
	@GetMapping(value="/swagger")
	public OpenAPI getSpecById() {	
		ParseOptions parseOptions = new ParseOptions();
		parseOptions.setResolveFully(true);
		parseOptions.setResolveCombinators(true);
		OpenAPI openAPI = new OpenAPIV3Parser().read("C:\\Users\\venkata seshu\\OneDrive\\Desktop\\sample.yaml", null, parseOptions);
		return openAPI;
		
	}
}
	