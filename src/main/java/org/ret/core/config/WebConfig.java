/*package org.ret.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/index.htm");
    }
    
    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {

                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND,
                        "/index.html");
                container.addErrorPages(error404Page);
            }
        };
    }


    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
*/