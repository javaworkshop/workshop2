package org.workshop2.floorinxs.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.workshop2.floorinxs.webapi.KlantEndPoint;

public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        registerEndPoints();
    }
    
    private void registerEndPoints() {
        register(KlantEndPoint.class);
    }
}
