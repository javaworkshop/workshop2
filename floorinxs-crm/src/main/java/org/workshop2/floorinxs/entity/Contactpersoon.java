package org.workshop2.floorinxs.entity;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Contactpersoon {
    @Column(name = "contactpersoon_id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "leverancier_id")
    private Leverancier leverancier;
    @Column
    private String voornaam;
    @Column
    private String achternaam;
    @Column
    private String emailadres;
    @Column
    private String telefoonnummer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Leverancier getLeverancier() {
        return leverancier;
    }

    public void setLeverancier(Leverancier leverancier) {
        this.leverancier = leverancier;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getEmailadres() {
        return emailadres;
    }

    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + Objects.hashCode(this.voornaam);
        hash = 29 * hash + Objects.hashCode(this.achternaam);
        hash = 29 * hash + Objects.hashCode(this.emailadres);
        hash = 29 * hash + Objects.hashCode(this.telefoonnummer);
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
        final Contactpersoon other = (Contactpersoon) obj;
        if (this.id != other.id) {
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
        return true;
    }

    @Override
    public String toString() {
        return "Contactpersoon{" + "id=" + id + ", voornaam=" + voornaam + ", achternaam=" + achternaam + ", emailadres=" + emailadres + ", telefoonnummer=" + telefoonnummer + '}';
    }
    
    
}
