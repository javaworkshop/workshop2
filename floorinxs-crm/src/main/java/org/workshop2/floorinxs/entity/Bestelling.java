package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class Bestelling implements Serializable {
    @Column(name = "klant_id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "totaalprijs_excl_btw")
    private int totaalprijsExclBtw;
    @Column(name = "totaalprijs_incl_btw")
    private int totaalprijsInclBtw;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "klant_id")
    private Klant klant;
    @Column
    private String opmerkingen;
    @Column
    private boolean voltooid;
    @Column
    @Lob
    private Blob werkbon;
    @Column
    @Lob
    private Blob bestellingbon;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="planning_id")
    private Planning planning;
    @ElementCollection
    @CollectionTable(
        name = "bestellingdetails",
        joinColumns = @JoinColumn(name = "bestelling_id")
    )
    private List<Bestellingdetails> bestellingdetails;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTotaalprijsExclBtw() {
        return totaalprijsExclBtw;
    }

    public void setTotaalprijsExclBtw(int totaalprijsExclBtw) {
        this.totaalprijsExclBtw = totaalprijsExclBtw;
    }

    public int getTotaalprijsInclBtw() {
        return totaalprijsInclBtw;
    }

    public void setTotaalprijsInclBtw(int totaalprijsInclBtw) {
        this.totaalprijsInclBtw = totaalprijsInclBtw;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public String getOpmerkingen() {
        return opmerkingen;
    }

    public void setOpmerkingen(String opmerkingen) {
        this.opmerkingen = opmerkingen;
    }

    public boolean isVoltooid() {
        return voltooid;
    }

    public void setVoltooid(boolean voltooid) {
        this.voltooid = voltooid;
    }

    public Blob getWerkbon() {
        return werkbon;
    }

    public void setWerkbon(Blob werkbon) {
        this.werkbon = werkbon;
    }

    public Blob getBestellingbon() {
        return bestellingbon;
    }

    public void setBestellingbon(Blob bestellingbon) {
        this.bestellingbon = bestellingbon;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    } 

    public List<Bestellingdetails> getBestellingdetails() {
        return bestellingdetails;
    }

    public void setBestellingdetails(List<Bestellingdetails> bestellingdetails) {
        this.bestellingdetails = bestellingdetails;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + this.totaalprijsExclBtw;
        hash = 29 * hash + this.totaalprijsInclBtw;
        hash = 29 * hash + Objects.hashCode(this.opmerkingen);
        hash = 29 * hash + (this.voltooid ? 1 : 0);
        hash = 29 * hash + Objects.hashCode(this.planning);
        hash = 29 * hash + Objects.hashCode(this.bestellingdetails);
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
        final Bestelling other = (Bestelling) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.totaalprijsExclBtw != other.totaalprijsExclBtw) {
            return false;
        }
        if (this.totaalprijsInclBtw != other.totaalprijsInclBtw) {
            return false;
        }
        if (!Objects.equals(this.opmerkingen, other.opmerkingen)) {
            return false;
        }
        if (this.voltooid != other.voltooid) {
            return false;
        }
        if (!Objects.equals(this.planning, other.planning)) {
            return false;
        }
        if (!Objects.equals(this.bestellingdetails, other.bestellingdetails)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bestelling{" + "id=" + id + ", totaalprijsExclBtw=" + totaalprijsExclBtw + ", totaalprijsInclBtw=" + totaalprijsInclBtw + ", opmerkingen=" + opmerkingen + ", voltooid=" + voltooid + ", planning=" + planning + ", bestellingdetails=" + bestellingdetails + '}';
    }
    
    
}
