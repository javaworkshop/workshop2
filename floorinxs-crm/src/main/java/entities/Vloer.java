/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author gerbrich2
 */
@Entity
@Table
class Vloer implements Serializable{
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
    
    @Column(name = "vloer_id") @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String type;
    @Column
    private String materiaal;
    @Column
    private Integer vierkanteMeter;
    private Integer prijsInCentenPerVierkanteMeter;
    
    public Vloer(){}

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
     * @return the vierkanteMeter
     */
    public Integer getVierkanteMeter() {
        return vierkanteMeter;
    }

    /**
     * @param vierkanteMeter the vierkanteMeter to set
     */
    public void setVierkanteMeter(Integer vierkanteMeter) {
        this.vierkanteMeter = vierkanteMeter;
    }

    /**
     * @return the prijsInCentenPerVierkanteMeter
     */
    public Integer getPrijsInCentenPerVierkanteMeter() {
        return prijsInCentenPerVierkanteMeter;
    }

    /**
     * @param prijsInCentenPerVierkanteMeter the prijsInCentenPerVierkanteMeter to set
     */
    public void setPrijsInCentenPerVierkanteMeter(Integer prijsInCentenPerVierkanteMeter) {
        this.prijsInCentenPerVierkanteMeter = prijsInCentenPerVierkanteMeter;
    }
    
}
