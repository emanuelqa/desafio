package com.emanuel.cadastroCliente.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Classe que é feito a configuração da ferramenta Swagger

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiDoc(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.emanuel.cadastroCliente"))
				.paths(PathSelectors.regex("/cliente.*"))
				.build()
				.apiInfo(apiInfo());
													
	}
	
	private ApiInfo apiInfo() {
	     return new ApiInfoBuilder()
	    		 .title("Cliente REST API")
	    		 .description("API para cadastro de cliente - Desafio Conductor")
	    		 .version("1.0")
	    		 .contact(new Contact("Emanuel Queiroga Araújo", null, "emanuel.qa@gmail.com"))
	    		 .build();	       
	}
	
}
