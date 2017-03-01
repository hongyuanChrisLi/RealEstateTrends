package org.ret.app;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
@EnableSwagger2
@SpringBootApplication
//@PropertySource({"classpath:application.properties"})
@ComponentScan(basePackages={"org.ret.admin.*", "org.ret.core.*"})
public class Application implements WebApplicationInitializer  {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
/*        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.scan("org.ret.config");
        ctx.scan("org.ret.dao.impl");
        ctx.scan("org.ret.service.impl");
        ctx.scan("org.ret.controller");
     
        ctx.close();*/
    }
    
/*    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        return tomcat;
    }*/
    
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
                new Contact("Smart Response", "", ""),
                "",
                "API License URL"
        );
    }



}