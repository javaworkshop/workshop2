package org.workshop2.floorinxs.service;

import java.util.List;
import org.workshop2.floorinxs.entity.Klant;

// Deze ook generic maken op dezelfde manier als dao's?
public interface KlantService {
    public void save(Klant klant);
    public void delete(Klant klant);
    public Klant update(Klant klant);
    public Klant findById(int id);
    public List<Klant> findAll();
}
