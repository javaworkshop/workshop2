package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class VloerType implements Serializable {
    @Column(name = "vloertype_id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    @Column
    private VloerTypeTypes type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public VloerTypeTypes getType() {
        return type;
    }

    public void setType(VloerTypeTypes type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 23 * hash + Objects.hashCode(this.type);
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
        final VloerType other = (VloerType) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VloerType{" + "id=" + id + ", type=" + type + '}';
    }
    
    
}
