package com.ppcpix.springbootneo4jDemo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {


    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ppcpix.springbootneo4jDemo"))
                .paths(regex("/rest.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "SpringBoot Neo4j API",
                "Spring Boot Neo4j API ",
                "1.0",
                "Terms of Service",
                new Contact("ppcpix", "https://www.ppcpix.com/",
                        "crazy@ppcpix.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html"
        );

        return apiInfo;
    }
}
