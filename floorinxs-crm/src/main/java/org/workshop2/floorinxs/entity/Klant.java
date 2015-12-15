package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@NamedQueries({
    @NamedQuery(
    name = "Klant.byAdresAndNaam", 
    query = "select klant from Klant klant join klant.adressen a where a.postcode = :postcode "
            + "and a.huisnummer = :huisnummer and klant.voornaam = :voornaam "
            + "and klant.achternaam = :achternaam"
    )
})
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
    
    @Column(name = "klant_id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;
    @Column
    private String voornaam;
    @Column
    private String achternaam;
    @Column
    private String emailadres;
    @Column
    private String telefoonnummer;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
            CascadeType.REFRESH})
    @JoinTable(name="klant_has_adres", joinColumns=@JoinColumn(name="klant_id"), 
            inverseJoinColumns=@JoinColumn(name="adres_id"))
    private Set<Adres> adressen = new LinkedHashSet<>();
    @Embedded
    private Rekeninggegevens rekeninggegevens = new Rekeninggegevens();
    @Column(length = 65535)
    private String opmerkingen;
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "klant")    
    private List<Factuur> facturen = new ArrayList<>();
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "klant")
    private List<Bestelling> bestellingen = new ArrayList<>();
    
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

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
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

    public List<Bestelling> getBestellingen() {
        return bestellingen;
    }

    public void setBestellingen(List<Bestelling> bestellingen) {
        this.bestellingen = bestellingen;
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.voornaam);
        hash = 67 * hash + Objects.hashCode(this.achternaam);
        hash = 67 * hash + Objects.hashCode(this.emailadres);
        hash = 67 * hash + Objects.hashCode(this.telefoonnummer);
        hash = 67 * hash + Objects.hashCode(this.adressen);
        hash = 67 * hash + Objects.hashCode(this.rekeninggegevens);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.voornaam, other.voornaam)) {
            return false;
        }
        if (!Objects.equals(this.achternaam, other.achternaam)) {
            return false;
        }
        if (!Objects.equals(this.emailadres, other.emailadres)) {
            return false;
        }
        if (!Objects.equals(this.telefoonnummer, other.telefoonnummer)) {
            return false;
        }
        if (!Objects.equals(this.adressen, other.adressen)) {
            return false;
        }
        if (!Objects.equals(this.rekeninggegevens, other.rekeninggegevens)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Klant{" + "id=" + id + ", voornaam=" + voornaam + ", achternaam=" + achternaam + ", emailadres=" + emailadres + ", telefoonnummer=" + telefoonnummer + ", adressen=" + adressen + ", rekeninggegevens=" + rekeninggegevens + '}';
    }  
       
    
}
