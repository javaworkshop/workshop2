package org.workshop2.floorinxs.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation
        .WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author Maarten
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"org.workshop2.floorinxs.webcontrol"})
public class MvcConfigurer extends WebMvcConfigurerAdapter {
    
    private final Logger logger = LoggerFactory.getLogger(MvcConfigurer.class);
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.debug("Adding resource handlers.");
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
    
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        logger.debug("Enabling default servlet handler configurer.");
        configurer.enable();
    }   
    
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = 
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        
        return viewResolver;
    }
   
}
