package org.workshop2.floorinxs.webapi;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.workshop2.floorinxs.entity.Klant;
import org.workshop2.floorinxs.service.FetchMode;
import org.workshop2.floorinxs.service.KlantService;

@Component
@Path("/klanten")
public class KlantEndPoint {
    @Autowired
    private KlantService klantService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Klant> getAllKlanten() {
        return klantService.findAll(FetchMode.FORCE_EAGER);
    }
}
