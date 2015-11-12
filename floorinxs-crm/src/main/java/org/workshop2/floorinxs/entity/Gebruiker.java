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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Gebruiker {
    @Column(name = "gebruiker_id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id")
    private Login login;
    @Column
    private String voornaam;
    @Column
    private String achternaam;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "autorisatieniveau_id")
    private Autorisatieniveau autorisatieniveau;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
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

    public Autorisatieniveau getAutorisatieniveau() {
        return autorisatieniveau;
    }

    public void setAutorisatieniveau(Autorisatieniveau autorisatieniveau) {
        this.autorisatieniveau = autorisatieniveau;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 37 * hash + Objects.hashCode(this.login);
        hash = 37 * hash + Objects.hashCode(this.voornaam);
        hash = 37 * hash + Objects.hashCode(this.achternaam);
        hash = 37 * hash + Objects.hashCode(this.autorisatieniveau);
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
        final Gebruiker other = (Gebruiker) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.voornaam, other.voornaam)) {
            return false;
        }
        if (!Objects.equals(this.achternaam, other.achternaam)) {
            return false;
        }
        if (!Objects.equals(this.autorisatieniveau, other.autorisatieniveau)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Gebruiker{" + "id=" + id + ", voornaam=" + voornaam + ", achternaam=" + achternaam + ", autorisatieniveau=" + autorisatieniveau + '}';
    }   
    
}
