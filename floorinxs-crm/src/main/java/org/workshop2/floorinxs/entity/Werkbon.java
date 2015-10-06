package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table
public class Werkbon implements Serializable {
    @Column(name = "werkbon_id") @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /*
    • vloer
        ◦ aantallen (aantal vloeren en aantal m2??)
    • producten
        ◦ aantallen
    • opmerkingen
    */
    /*
    Gerbrich: misschien kan een werkbon de info uit de offerte halen, behalve de opmerkingen?
    het is denk ik handig als een werkbon een offerte_id als foreign key heeft
    */
    
    @ElementCollection @ManyToMany @CollectionTable(name = "werkbon_vloeren", joinColumns = @JoinColumn(name = "werkbon_id"))
    private List<Vloer> vloeren = new ArrayList<Vloer>();
    @ElementCollection @ManyToMany @CollectionTable(name = "werkbon_producten", joinColumns = @JoinColumn(name = "werkbon_id"))
    private List<Product> producten = new ArrayList<Product>();
    @Column
    private String opmerkingen;
    
    public Werkbon(){}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the vloeren
     */
    public List<Vloer> getVloeren() {
        return vloeren;
    }

    /**
     * @param vloeren the vloeren to set
     */
    public void setVloeren(List<Vloer> vloeren) {
        this.vloeren = vloeren;
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