package org.workshop2.floorinxs.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.workshop2.floorinxs.dao.KlantDao;
import org.workshop2.floorinxs.entity.Klant;

// TODO: eventuele bewerkingen en checks van data uitvoeren
@Service
@Transactional
public class KlantServiceImpl implements KlantService {
    @Autowired
    private KlantDao klantDao;

    @Override
    public void delete(Klant klant) {
        klantDao.delete(klant);
    }

    @Override
    public List<Klant> findAll() {
        return klantDao.readAll();
    }

    @Override
    public Klant findById(int id) {
        return klantDao.readById(id);
    }

    @Override
    public void save(Klant klant) {
        // TODO: klantgegevens valideren
        klantDao.create(klant);
    }

    @Override
    public Klant update(Klant klant) {
        // TODO: klantgegevens valideren
        return klantDao.update(klant);
    }   
}
