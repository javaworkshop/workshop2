package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table
class Offerte implements Serializable {

    /*
    • vloer
    ◦ aantallen
    ◦ prijs
    • producten
    ◦ aantallen
    ◦ prijs
    • totaalprijs
    ◦ inclusief btw
    ◦ exclusief btw • expiratiedatum
    • opmerkingen
    */
    
     /*DOE IETS MET DE PRIJZEN! DAAR WORDT NU GEEN INFO OVER OPGESLAGEN, OOK NIET IN DE PRODUCT KLASSE*/
    
    @Column(name = "offerte_id") @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @ElementCollection @ManyToMany @CollectionTable(name = "offerte_vloeren", joinColumns = @JoinColumn(name = "offerte_id"))
    private List<Vloer> vloeren = new ArrayList<Vloer>();
    @ElementCollection @ManyToMany @CollectionTable(name = "offerte_producten", joinColumns = @JoinColumn(name = "offerte_id"))
    private List<Product> producten = new ArrayList<Product>();
    @Column(name = "totaal_prijs")
    private Integer totaalPrijsInCentZonderBtw;
    @Column(name = "btw_tarief")
    private Integer btwTarief;
    @Column @Temporal(TemporalType.DATE)
    private Date vervalDatum;
    @Column
    private String opmerkingen;
    
    public Offerte(){}
    
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
     * @return the totaalPrijsInCentZonderBtw
     */
    public Integer getTotaalPrijsInCentZonderBtw() {
        return totaalPrijsInCentZonderBtw;
    }

    /**
     * @param totaalPrijsInCentZonderBtw the totaalPrijsInCentZonderBtw to set
     */
    public void setTotaalPrijsInCentZonderBtw(Integer totaalPrijsInCentZonderBtw) {
        this.totaalPrijsInCentZonderBtw = totaalPrijsInCentZonderBtw;
    }

    /**
     * @return the btwTariefInCent
     */
    public Integer getBtwTarief() {
        return btwTarief;
    }

    /**
     * @param btwTarief the btwTariefInCent to set
     */
    public void setBtwTarief(Integer btwTarief) {
        this.btwTarief = btwTarief;
    }

    /**
     * @return the vervalDatum
     */
    public Date getVervalDatum() {
        return vervalDatum;
    }

    /**
     * @param vervalDatum the vervalDatum to set
     */
    public void setVervalDatum(Date vervalDatum) {
        this.vervalDatum = vervalDatum;
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