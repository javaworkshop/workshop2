package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Productgroep implements Serializable {
    @Column(name = "productgroep_id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    @Column
    private ProductgroepTypes groep;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }     
    
    public ProductgroepTypes getGroep() {
        return groep;
    }

    public void setGroep(ProductgroepTypes groep) {
        this.groep = groep;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.groep);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Productgroep other = (Productgroep) obj;
        if (this.groep != other.groep) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Productgroep{" + "id=" + id + ", groep=" + groep + '}';
    }
    
}