package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Producttype implements Serializable {
    @Column(name = "producttype_id") @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated(EnumType.STRING)
    @Column
    private Type type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }     
    
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }    
}

enum Type {
    VLOER,
    ONDERHOUDSPRODUCT
}