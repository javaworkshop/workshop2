package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

/*@NamedQueries({
    @NamedQuery(
    name="Klant.queryNaam", 
    query="from ? where ?"
    )
})*/
@Entity
@Table
public class Klant implements Serializable{
    /*
    • Voornaam
    • Achternaam 
    • Adres
    • E-mailadres
    • Adres(sen)
    • Rekeninggegevens
    • Opmerkingen
    • Facturen
    ◦ service bepaal: openstaand /
    betaald
    • Offertes
    ◦ service bepaal: open/ archief
    • Planning
    ◦ startdatum
    ◦ einddatum
    */
    
    @Column(name = "klant_id") @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String voornaam;
    @Column
    private String achternaam;
    //@Embedded
    //private Adres adres = new Adres();
    @Column
    private String emailadres;
    @ElementCollection @ManyToMany @CollectionTable(name = "klant_adressen", joinColumns = @JoinColumn(name = "klant_id"))
    private Set<Adres> adressen;
    @Embedded
    private Rekeninggegevens rekeninggegevens = new Rekeninggegevens();
    @Column
    private String opmerkingen;
    @OneToMany(mappedBy = "id")
    private List<Factuur> facturen;
    @OneToMany(mappedBy = "id")
    private List<Offerte> offertes;
    private Planning planning = new Planning();

    
    public Klant(){}
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the voornaam
     */
    public String getVoornaam() {
        return voornaam;
    }

    /**
     * @param voornaam the voornaam to set
     */
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    /**
     * @return the achternaam
     */
    public String getAchternaam() {
        return achternaam;
    }

    /**
     * @param achternaam the achternaam to set
     */
    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    /**
     * @return the adressen
     */
    public Set<Adres> getAdressen() {
        return adressen;
    }

    /**
     * @param adressen the adressen to set
     */
    public void setAdressen(Set<Adres> adressen) {
        this.adressen = adressen;
    }

    /**
     * @return the emailadres
     */
    public String getEmailadres() {
        return emailadres;
    }

    /**
     * @param emailadres the emailadres to set
     */
    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }

    /**
     * @return the rekeninggegevens
     */
    public Rekeninggegevens getRekeninggegevens() {
        return rekeninggegevens;
    }

    /**
     * @param rekeninggegevens the rekeninggegevens to set
     */
    public void setRekeninggegevens(Rekeninggegevens rekeninggegevens) {
        this.rekeninggegevens = rekeninggegevens;
    }

    /**
     * @return the opmerkingen
     */
    public String getOpmerkingen() {
        return opmerkingen;
    }

    /**
     * @param opmerkingen the opmerkingen to set
     */
    public void setOpmerkingen(String opmerkingen) {
        this.opmerkingen = opmerkingen;
    }

    /**
     * @return the facturen
     */
    public List<Factuur> getFacturen() {
        return facturen;
    }

    /**
     * @param facturen the facturen to set
     */
    public void setFacturen(List<Factuur> facturen) {
        this.facturen = facturen;
    }

    /**
     * @return the offertes
     */
    public List<Offerte> getOffertes() {
        return offertes;
    }

    /**
     * @param offertes the offertes to set
     */
    public void setOffertes(List<Offerte> offertes) {
        this.offertes = offertes;
    }

    /**
     * @return the planning
     */
    public Planning getPlanning() {
        return planning;
    }

    /**
     * @param planning the planning to set
     */
    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.voornaam);
        hash = 71 * hash + Objects.hashCode(this.achternaam);
        hash = 71 * hash + Objects.hashCode(this.emailadres);
        hash = 71 * hash + Objects.hashCode(this.adressen);
        hash = 71 * hash + Objects.hashCode(this.rekeninggegevens);
        hash = 71 * hash + Objects.hashCode(this.opmerkingen);
        hash = 71 * hash + Objects.hashCode(this.facturen);
        hash = 71 * hash + Objects.hashCode(this.offertes);
        hash = 71 * hash + Objects.hashCode(this.planning);
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
        final Klant other = (Klant) obj;
        if (!Objects.equals(this.voornaam, other.voornaam)) {
            return false;
        }
        if (!Objects.equals(this.achternaam, other.achternaam)) {
            return false;
        }
        if (!Objects.equals(this.emailadres, other.emailadres)) {
            return false;
        }
        if (!Objects.equals(this.adressen, other.adressen)) {
            return false;
        }
        if (!Objects.equals(this.rekeninggegevens, other.rekeninggegevens)) {
            return false;
        }
        if (!Objects.equals(this.opmerkingen, other.opmerkingen)) {
            return false;
        }
        if (!Objects.equals(this.facturen, other.facturen)) {
            return false;
        }
        if (!Objects.equals(this.offertes, other.offertes)) {
            return false;
        }
        if (!Objects.equals(this.planning, other.planning)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Klant{" + "id=" + id + ", voornaam=" + voornaam + ", achternaam=" + achternaam + ", emailadres=" + emailadres + ", adressen=" + adressen + ", rekeninggegevens=" + rekeninggegevens + ", opmerkingen=" + opmerkingen + ", facturen=" + facturen + ", offertes=" + offertes + ", planning=" + planning + '}';
    }
    
}
