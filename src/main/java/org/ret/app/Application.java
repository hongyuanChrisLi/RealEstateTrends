package org.ret.app;

import org.ret.core.config.DatabaseConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
//@EnableJpaRepositories(basePackages="org.ret.core.dao.impl")
//@EntityScan(basePackages="org.ret.core.entity")
//@ComponentScan(basePackages={"org.ret.admin.*", "org.ret.core.*"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})

public class Application extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
 
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    
    @Bean
    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(retApiInfo());
    }
    private ApiInfo retApiInfo() {
        return new ApiInfo(
                "RET - Real Estate Trends REST API Documentation",
                "",
                "",
                "",
                new Contact("Hongyuan(Chris) Li", "", ""),
                "",
                "API License URL"
        );
    }



}