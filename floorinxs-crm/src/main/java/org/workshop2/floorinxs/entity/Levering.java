package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table
public class Levering implements Serializable {
       /*
    Gerbrich:
    -leverdatum
    misschien ook:
    -vloeren
    -producten
    */
    
    @Column(name = "levering_id") @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Date leverdatum;
    
    public Levering(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the leverdatum
     */
    public Date getLeverdatum() {
        return leverdatum;
    }

    /**
     * @param leverdatum the leverdatum to set
     */
    public void setLeverdatum(Date leverdatum) {
        this.leverdatum = leverdatum;
    }

}