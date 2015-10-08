package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.persistence.*;

@Entity
@Table
public class Leverancier implements Serializable {
    
    /*
    • Bedrijfsnaam
    • Rekeninggegevens 
    • Contactpersoon
    • E-mailadres 
    • Facturen
        ◦ openstaand
        ◦ betaald
    • Leveringen
    • Producten
    • Opmerkingen
    */
    
    @Column(name = "leverancier_id") @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String bedrijfsnaam;
    @Embedded
    private Rekeninggegevens rekeningGegevens = new Rekeninggegevens();
    @Column
    private String contactPersoon;
    @Column
    private String emailAdres;
    @ElementCollection @ManyToMany @CollectionTable(name = "leverancier_facturen", joinColumns=@JoinColumn(name = "leverancier_id"))
    private List<Factuur> facturen = new ArrayList<Factuur>();
    @OneToMany(mappedBy = "id")
    private List<Levering> leveringen = new ArrayList<Levering>();
    @OneToMany(mappedBy = "artikelnummer")
    private List<Product> producten = new ArrayList<Product>();
    @Column
    private String opmerkingen;
    
    public Leverancier(){}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the bedrijfsnaam
     */
    public String getBedrijfsnaam() {
        return bedrijfsnaam;
    }

    /**
     * @param bedrijfsnaam the bedrijfsnaam to set
     */
    public void setBedrijfsnaam(String bedrijfsnaam) {
        this.bedrijfsnaam = bedrijfsnaam;
    }

    /**
     * @return the rekeningGegevens
     */
    public Rekeninggegevens getRekeningGegevens() {
        return rekeningGegevens;
    }

    /**
     * @param rekeningGegevens the rekeningGegevens to set
     */
    public void setRekeningGegevens(Rekeninggegevens rekeningGegevens) {
        this.rekeningGegevens = rekeningGegevens;
    }

    /**
     * @return the contactPersoon
     */
    public String getContactPersoon() {
        return contactPersoon;
    }

    /**
     * @param contactPersoon the contactPersoon to set
     */
    public void setContactPersoon(String contactPersoon) {
        this.contactPersoon = contactPersoon;
    }

    /**
     * @return the emailAdres
     */
    public String getEmailAdres() {
        return emailAdres;
    }

    /**
     * @param emailAdres the emailAdres to set
     */
    public void setEmailAdres(String emailAdres) {
        this.emailAdres = emailAdres;
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
     * @return the leveringen
     */
    public List<Levering> getLeveringen() {
        return leveringen;
    }

    /**
     * @param leveringen the leveringen to set
     */
    public void setLeveringen(List<Levering> leveringen) {
        this.leveringen = leveringen;
    }

    /**
     * @return the producten
     */
    public List<Product> getProducten() {
        return producten;
    }

    /**
     * @param producten the producten to set
     */
    public void setProducten(List<Product> producten) {
        this.producten = producten;
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
    
}