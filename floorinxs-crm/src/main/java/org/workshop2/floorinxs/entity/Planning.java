package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table
public class Planning implements Serializable {
    @Column(name = "planning_id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdatum;
    @Temporal(TemporalType.TIMESTAMP)
    private Date einddatum;
 /*   @Column
    private String opmerkingen;
    Gerbrich: Dit is een handige toevoeging om details van de planning weer te kunnen geven*/
    
    public Planning(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }    
    
    /**
     * @return the startdatum
     */
    public Date getStartdatum() {
        return startdatum;
    }

    /**
     * @param startdatum the startDatum to set
     */
    public void setStartdatum(Date startdatum) {
        this.startdatum = startdatum;
    }

    /**
     * @return the einddatum
     */
    public Date getEinddatum() {
        return einddatum;
    }

    /**
     * @param einddatum the einddatum to set
     */
    public void setEinddatum(Date einddatum) {
        this.einddatum = einddatum;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 73 * hash + Objects.hashCode(this.startdatum);
        hash = 73 * hash + Objects.hashCode(this.einddatum);
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
        final Planning other = (Planning) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.startdatum, other.startdatum)) {
            return false;
        }
        if (!Objects.equals(this.einddatum, other.einddatum)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Planning{" + "id=" + id + ", startdatum=" + startdatum + ", einddatum=" + einddatum + '}';
    }
      
    
}