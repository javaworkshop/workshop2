package org.workshop2.floorinxs.entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "factuur_levering")
public class FactuurLevering {
    @Column(name = "factuur_levering_id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "levering_id")
    private Levering levering;
    @Column
    private int totaalprijs;
    @Temporal(TemporalType.DATE)
    @Column(name = "uiterste_betaaldatum")
    private Date uitersteBetaaldatum;
    @Temporal(TemporalType.DATE)
    private Date betaaldatum;
    @Column
    private String opmerkingen;
    @Column
    private boolean betaald;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Levering getLevering() {
        return levering;
    }

    public void setLevering(Levering levering) {
        this.levering = levering;
    }

    public int getTotaalprijs() {
        return totaalprijs;
    }

    public void setTotaalprijs(int totaalprijs) {
        this.totaalprijs = totaalprijs;
    }

    public Date getUitersteBetaaldatum() {
        return uitersteBetaaldatum;
    }

    public void setUitersteBetaaldatum(Date uitersteBetaaldatum) {
        this.uitersteBetaaldatum = uitersteBetaaldatum;
    }

    public Date getBetaaldatum() {
        return betaaldatum;
    }

    public void setBetaaldatum(Date betaaldatum) {
        this.betaaldatum = betaaldatum;
    }

    public String getOpmerkingen() {
        return opmerkingen;
    }

    public void setOpmerkingen(String opmerkingen) {
        this.opmerkingen = opmerkingen;
    }

    public boolean isBetaald() {
        return betaald;
    }

    public void setBetaald(boolean betaald) {
        this.betaald = betaald;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 17 * hash + Objects.hashCode(this.levering);
        hash = 17 * hash + this.totaalprijs;
        hash = 17 * hash + Objects.hashCode(this.uitersteBetaaldatum);
        hash = 17 * hash + Objects.hashCode(this.betaaldatum);
        hash = 17 * hash + Objects.hashCode(this.opmerkingen);
        hash = 17 * hash + (this.betaald ? 1 : 0);
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
        final FactuurLevering other = (FactuurLevering) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.levering, other.levering)) {
            return false;
        }
        if (this.totaalprijs != other.totaalprijs) {
            return false;
        }
        if (!Objects.equals(this.uitersteBetaaldatum, other.uitersteBetaaldatum)) {
            return false;
        }
        if (!Objects.equals(this.betaaldatum, other.betaaldatum)) {
            return false;
        }
        if (!Objects.equals(this.opmerkingen, other.opmerkingen)) {
            return false;
        }
        if (this.betaald != other.betaald) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FactuurLevering{" + "id=" + id + ", levering=" + levering + ", totaalprijs=" + totaalprijs + ", uitersteBetaaldatum=" + uitersteBetaaldatum + ", betaaldatum=" + betaaldatum + ", opmerkingen=" + opmerkingen + ", betaald=" + betaald + '}';
    }       
    
}
