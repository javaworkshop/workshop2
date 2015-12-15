package org.workshop2.floorinxs.dao;

import org.workshop2.floorinxs.entity.Klant;

public interface KlantDao extends Dao<Klant, Long> {
    void initLazyCollections(Klant klant);
    Klant findByAdresAndNaam(String postcode, String huisnummer, String voornaam, 
            String achternaam);
}
