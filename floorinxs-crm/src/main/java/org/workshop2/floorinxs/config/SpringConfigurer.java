package org.workshop2.floorinxs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author Maarten
 */
@Configuration
@ComponentScan(basePackages = { "org.workshop2.floorinxs.dao", 
                                "org.workshop2.floorinxs.service",
                                "org.workshop2.floorinxs.webapi"    })
@Import(DatabaseConfigurer.class)
public class SpringConfigurer {}
