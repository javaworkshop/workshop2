package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table
public class Levering implements Serializable {    
    @Column(name = "levering_id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "leverancier_id")
    private Leverancier leverancier;
    @Temporal(TemporalType.TIMESTAMP)
    private Date leverdatum;
    @Column
    private boolean geleverd;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "leveradres")
    private Adres leveradres;
    @ElementCollection
    @CollectionTable(
        name = "leveringdetails",
        joinColumns = @JoinColumn(name = "levering_id")
    )
    private List<Leveringdetails> leveringdetails;
    @OneToOne(mappedBy = "levering", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FactuurLevering factuur;
    
    public Levering(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Leverancier getLeverancier() {
        return leverancier;
    }

    public void setLeverancier(Leverancier leverancier) {
        this.leverancier = leverancier;
    }

    public Date getLeverdatum() {
        return leverdatum;
    }

    public void setLeverdatum(Date leverdatum) {
        this.leverdatum = leverdatum;
    }

    public boolean isGeleverd() {
        return geleverd;
    }

    public void setGeleverd(boolean geleverd) {
        this.geleverd = geleverd;
    }

    public Adres getLeveradres() {
        return leveradres;
    }

    public void setLeveradres(Adres leveradres) {
        this.leveradres = leveradres;
    }

    public List<Leveringdetails> getLeveringdetails() {
        return leveringdetails;
    }

    public void setLeveringdetails(List<Leveringdetails> leveringdetails) {
        this.leveringdetails = leveringdetails;
    }

    public FactuurLevering getFactuur() {
        return factuur;
    }

    public void setFactuur(FactuurLevering factuur) {
        this.factuur = factuur;
    }   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.leverancier);
        hash = 67 * hash + Objects.hashCode(this.leverdatum);
        hash = 67 * hash + (this.geleverd ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.leveradres);
        hash = 67 * hash + Objects.hashCode(this.leveringdetails);
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
        final Levering other = (Levering) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.leverancier, other.leverancier)) {
            return false;
        }
        if (!Objects.equals(this.leverdatum, other.leverdatum)) {
            return false;
        }
        if (this.geleverd != other.geleverd) {
            return false;
        }
        if (!Objects.equals(this.leveradres, other.leveradres)) {
            return false;
        }
        if (!Objects.equals(this.leveringdetails, other.leveringdetails)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Levering{" + "id=" + id + ", leverancier=" + leverancier + ", leverdatum=" + leverdatum + ", geleverd=" + geleverd + ", leveradres=" + leveradres + ", leveringdetails=" + leveringdetails + '}';
    }
    

}