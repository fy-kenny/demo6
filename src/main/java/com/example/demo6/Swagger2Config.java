package com.example.demo6;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
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

/**
 * @author Kenny Fang
 * @since 1.0
 */
@ConfigurationProperties("api")
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Value("${api.version:1.0}")
    private String apiVersion;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo6"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot with Swagger2 build RESTful APIs")
                .description("Spring boot with Swagger2")
                .termsOfServiceUrl("/v2/api-docs")
                .contact(new Contact("Kenny Fang", "", "fy_kenny@163.com"))
                .version(apiVersion)
                .build();
    }
}
