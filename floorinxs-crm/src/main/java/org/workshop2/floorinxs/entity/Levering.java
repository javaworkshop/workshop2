package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table
public class Levering implements Serializable {
       /*
    Gerbrich:
    -leverdatum
    misschien ook:
    -vloeren
    -producten
    */
    
    @Column(name = "levering_id") @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Date leverdatum;
    
    public Levering(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the leverdatum
     */
    public Date getLeverdatum() {
        return leverdatum;
    }

    /**
     * @param leverdatum the leverdatum to set
     */
    public void setLeverdatum(Date leverdatum) {
        this.leverdatum = leverdatum;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.leverdatum);
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
        final Levering other = (Levering) obj;
        if (!Objects.equals(this.leverdatum, other.leverdatum)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Levering{" + "id=" + id + ", leverdatum=" + leverdatum + '}';
    }

}