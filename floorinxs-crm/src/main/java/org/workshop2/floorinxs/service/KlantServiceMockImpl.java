package org.workshop2.floorinxs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.workshop2.floorinxs.entity.Klant;
import org.workshop2.floorinxs.service.KlantService;

@Service
public class KlantServiceMockImpl implements KlantService {
    
    private List<Klant> klanten = new ArrayList<>();
    private long nextId = 1;
    private boolean eagerFetch;

    @Override
    public void delete(Klant klant) {
        klanten.remove(klant);
    }

    @Override
    public List<Klant> findAll() {
        return klanten;
    }

    @Override
    public Klant findById(long id) {
        for(Klant k : klanten) {
            if(k.getId() == id)
                return k;
        }
        return null;
    }

    @Override
    public boolean isEagerFetch() {
        return eagerFetch;
    }

    @Override
    public void save(Klant klant) {
        if(klant.getId() != 0L)
            throw new RuntimeException("Klant id mag niet al gedefinieerd zijn");
        
        klant.setId(nextId);
        nextId++;
        klanten.add(klant);
    }

    @Override
    public List<Klant> find(Map<String, String> searchParam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEagerFetch(boolean eagerFetch) {
        this.eagerFetch = eagerFetch;
    }

    @Override
    public Klant update(Klant klant) {
        for(int i = 0; i < klanten.size(); i++) {
            if(klanten.get(i).getId() == klant.getId()) {
                klanten.set(i, klant);
                return klant;
            }
        }
        throw new RuntimeException("Klant id bevindt zich nog niet in de database");
    }
    
}
