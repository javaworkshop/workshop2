package org.workshop2.floorinxs.dao;

import org.workshop2.floorinxs.entity.Leverancier;

public interface LeverancierDao extends Dao<Leverancier, Long> {
    void initLazyCollections(Leverancier leverancier);
}
