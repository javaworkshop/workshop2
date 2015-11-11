package org.workshop2.floorinxs.entity;

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
public class Autorisatieniveau {
    @Column(name = "autorisatieniveau_id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    @Column
    private AutorisatieniveauTypes autorisatieniveau;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AutorisatieniveauTypes getAutorisatieniveau() {
        return autorisatieniveau;
    }

    public void setAutorisatieniveau(AutorisatieniveauTypes autorisatieniveau) {
        this.autorisatieniveau = autorisatieniveau;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.autorisatieniveau);
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
        final Autorisatieniveau other = (Autorisatieniveau) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.autorisatieniveau != other.autorisatieniveau) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Autorisatieniveau{" + "id=" + id + ", autorisatieniveau=" + autorisatieniveau + '}';
    }
    
    
}
