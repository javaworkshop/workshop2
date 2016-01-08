package org.workshop2.floorinxs.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support
        .AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author Maarten
 */
public class WebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) 
            throws ServletException {
        // Create root Spring application context
        AnnotationConfigWebApplicationContext rootContext = 
                new AnnotationConfigWebApplicationContext();
        rootContext.register(SpringConfigurer.class);
        rootContext.setServletContext(servletContext);
        
        // Manage lifecycle of rootContext
        servletContext.addListener(new ContextLoaderListener(rootContext));
        
        // Create the dispatcher servlet Spring application context
        AnnotationConfigWebApplicationContext dispatcherConfig = 
                new AnnotationConfigWebApplicationContext();
        dispatcherConfig.register(MvcConfigurer.class);
        ServletRegistration.Dynamic servletReg = servletContext.addServlet(
                "mvcDispatcher", new DispatcherServlet(dispatcherConfig));
        servletReg.setLoadOnStartup(1);
        servletReg.addMapping("/");
        
        // Create the Jersey servlet
        JerseyConfig jerseyConfig = new JerseyConfig();
        jerseyConfig.register(JerseyConfig.class);
        ServletRegistration.Dynamic jerseyReg = servletContext.addServlet(
                "jerseyServlet", new ServletContainer(jerseyConfig));
        jerseyReg.setLoadOnStartup(2);
        jerseyReg.addMapping("/webapi/*");
    }
}
