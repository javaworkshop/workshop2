package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table
public class Productgroep implements Serializable {
    /*
• Type: laminaat, massief 
• Materiaal
• afmeting in vierkante meter
    */
    
    @Column(name = "productgroep_id") @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String type;
    @Column
    private String materiaal;
    @Column
    private Integer vierkanteMeter;
    
    public Productgroep(){}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the materiaal
     */
    public String getMateriaal() {
        return materiaal;
    }

    /**
     * @param materiaal the materiaal to set
     */
    public void setMateriaal(String materiaal) {
        this.materiaal = materiaal;
    }

    /**
     * @return the afmetingInVierkanteMeter
     */
    public Integer getVierkanteMeter() {
        return vierkanteMeter;
    }

    /**
     * @param afmetingInVierkanteMeter the afmetingInVierkanteMeter to set
     */
    public void setVierkanteMeter(Integer vierkanteMeter) {
        this.vierkanteMeter = vierkanteMeter;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.type);
        hash = 37 * hash + Objects.hashCode(this.materiaal);
        hash = 37 * hash + Objects.hashCode(this.vierkanteMeter);
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
        final Productgroep other = (Productgroep) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.materiaal, other.materiaal)) {
            return false;
        }
        if (!Objects.equals(this.vierkanteMeter, other.vierkanteMeter)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Productgroep{" + "id=" + id + ", type=" + type + ", materiaal=" + materiaal + ", vierkanteMeter=" + vierkanteMeter + '}';
    }
    
}
