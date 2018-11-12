package com.spring.boom.credit.homework.tools;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class DocumentationConfig {
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Boom Credit Homework",
                "Boom Credit Homework",
                "0.0.1",
                "Terms of use",
                new Contact("Alberto Hernandez","https://alberto.com","josealbertohm@gmail.com"),
                "License",
                "https://alberto.com/license",
                Collections.emptyList()
        );
    }
}
