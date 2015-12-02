package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table
public class Vloer extends Product implements Serializable {
    /*
    • Type:
        ◦ referentietabel.
    • Materiaal
    • afmeting in vierkante meter
        ◦ totaal oppervlak 
        ◦ Dimensie- eigenschappen 
            ▪ vloer kan uit meerdere rechthoeken, Dimensies, bestaan
    • optioneel: x-, y- coördinaten per dimensiedeel zodat er later met polygonen gewerkt kan worden.
        ◦ tov. 0.0 linkerbovenkant vloer
    • prijs per vierkante meter.
    */

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vloertype_id")
    private VloerType type;
    @Column
    private String materiaal;
    
    public Vloer(){}

    public VloerType getType() {
        return type;
    }

    public void setType(VloerType type) {
        this.type = type;
    }

    public String getMateriaal() {
        return materiaal;
    }

    public void setMateriaal(String materiaal) {
        this.materiaal = materiaal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.type);
        hash = 47 * hash + Objects.hashCode(this.materiaal);
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
        final Vloer other = (Vloer) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.materiaal, other.materiaal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vloer{" + "type=" + type + ", materiaal=" + materiaal + '}';
    }

    
    
}