package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Embeddable
class Planning implements Serializable {
    
    @Column
    private Date startdatum;
    @Column
    private Date einddatum;
 /*   @Column
    private String opmerkingen;
    Gerbrich: Dit is een handige toevoeging om details van de planning weer te kunnen geven*/
    
    public Planning(){}
    
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
    
}