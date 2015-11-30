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
public class Eenheid implements Serializable {
    @Column(name = "eenheid_id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    @Column
    private EenheidTypes eenheid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EenheidTypes getEenheid() {
        return eenheid;
    }

    public void setEenheid(EenheidTypes eenheid) {
        this.eenheid = eenheid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + Objects.hashCode(this.eenheid);
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
        final Eenheid other = (Eenheid) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.eenheid != other.eenheid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Eenheid{" + "id=" + id + ", eenheid=" + eenheid + '}';
    }   
    
}
