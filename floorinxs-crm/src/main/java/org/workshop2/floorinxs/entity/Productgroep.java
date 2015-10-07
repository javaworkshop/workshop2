package org.workshop2.floorinxs.entity;

import java.io.Serializable;
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
    
}
