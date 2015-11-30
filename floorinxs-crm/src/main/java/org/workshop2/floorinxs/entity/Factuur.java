package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table
public class Factuur implements Serializable {

    /*
    • vloer
        ◦ aantallen
        ◦ prijs
    • producten
        ◦ aantallen
        ◦ prijs
    • totaalprijs
        ◦ inclusief btw
        ◦ exclusief btw
    • uiterste betaaldatum 
    • opmerkingen
    */
    
    @Column(name = "factuur_id") @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "bestelling_id")
    private Bestelling bestelling;
    @Column(name = "totaalprijs_excl_btw")
    private int totaalPrijsExclBtw;
    @Column(name = "totaalprijs_incl_btw")
    private int totaalPrijsInclBtw;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "klant_id")
    private Klant klant;
    @ElementCollection
    @CollectionTable(
        name = "factuurdetails",
        joinColumns = @JoinColumn(name = "factuur_id")
    )
    private List<Factuurdetails> factuurdetails = new ArrayList<>();
    @Column(length = 65535)
    private String opmerkingen;
    @Column
    private boolean betaald;
    @Column(name = "uiterste_betaaldatum") @Temporal(TemporalType.DATE)
    private Date uitersteBetaalDatum;
    @Column @Temporal(TemporalType.DATE)
    private Date betaalDatum;
    @Column
    @Lob
    private byte[] bestand;    

    public Factuur(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bestelling getBestelling() {
        return bestelling;
    }

    public void setBestelling(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    public int getTotaalPrijsExclBtw() {
        return totaalPrijsExclBtw;
    }

    public void setTotaalPrijsExclBtw(int totaalPrijsExclBtw) {
        this.totaalPrijsExclBtw = totaalPrijsExclBtw;
    }

    public int getTotaalPrijsInclBtw() {
        return totaalPrijsInclBtw;
    }

    public void setTotaalPrijsInclBtw(int totaalPrijsInclBtw) {
        this.totaalPrijsInclBtw = totaalPrijsInclBtw;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public List<Factuurdetails> getFactuurdetails() {
        return factuurdetails;
    }

    public void setFactuurdetails(List<Factuurdetails> factuurdetails) {
        this.factuurdetails = factuurdetails;
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

    public Date getUitersteBetaalDatum() {
        return uitersteBetaalDatum;
    }

    public void setUitersteBetaalDatum(Date uitersteBetaalDatum) {
        this.uitersteBetaalDatum = uitersteBetaalDatum;
    }

    public Date getBetaalDatum() {
        return betaalDatum;
    }

    public void setBetaalDatum(Date betaalDatum) {
        this.betaalDatum = betaalDatum;
    }

    public byte[] getBestand() {
        return bestand;
    }

    public void setBestand(byte[] bestand) {
        this.bestand = bestand;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.bestelling);
        hash = 17 * hash + this.totaalPrijsExclBtw;
        hash = 17 * hash + this.totaalPrijsInclBtw;
        hash = 17 * hash + Objects.hashCode(this.klant);
        hash = 17 * hash + Objects.hashCode(this.factuurdetails);
        hash = 17 * hash + (this.betaald ? 1 : 0);
        hash = 17 * hash + Objects.hashCode(this.uitersteBetaalDatum);
        hash = 17 * hash + Objects.hashCode(this.betaalDatum);
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
        final Factuur other = (Factuur) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.bestelling, other.bestelling)) {
            return false;
        }
        if (this.totaalPrijsExclBtw != other.totaalPrijsExclBtw) {
            return false;
        }
        if (this.totaalPrijsInclBtw != other.totaalPrijsInclBtw) {
            return false;
        }
        if (!Objects.equals(this.klant, other.klant)) {
            return false;
        }
        if (!Objects.equals(this.factuurdetails, other.factuurdetails)) {
            return false;
        }
        if (this.betaald != other.betaald) {
            return false;
        }
        if (!Objects.equals(this.uitersteBetaalDatum, other.uitersteBetaalDatum)) {
            return false;
        }
        if (!Objects.equals(this.betaalDatum, other.betaalDatum)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Factuur{" + "id=" + id + ", bestelling=" + bestelling + ", totaalPrijsExclBtw=" + totaalPrijsExclBtw + ", totaalPrijsInclBtw=" + totaalPrijsInclBtw + ", klant=" + klant + ", factuurdetails=" + factuurdetails + ", betaald=" + betaald + ", uitersteBetaalDatum=" + uitersteBetaalDatum + ", betaalDatum=" + betaalDatum + '}';
    }
    
    
}