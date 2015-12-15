package org.workshop2.floorinxs.webapi;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    
    @GET
    @Path("/{klantId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Klant getKlantById(@PathParam("klantId") long id) {
        return klantService.findById(id, FetchMode.FORCE_EAGER);
    }
    
    @GET
    @Path("/postcode/{postcode}/huisnummer/{huisnummer}/voornaam/{voornaam}/achternaam"
            + "/{achternaam}")
    @Produces(MediaType.APPLICATION_JSON)
    public Klant getKlantByAdresAndNaam(@PathParam("postcode") String postcode, 
            @PathParam("huisnummer") String huisnummer, 
            @PathParam("voornaam") String voornaam, 
            @PathParam("achternaam") String achternaam) {
        // Todo: eigenlijk is authenticatie vereist        
        return klantService.findByAdresAndNaam(postcode, huisnummer, voornaam, achternaam, 
                FetchMode.FORCE_EAGER);
    }
}
