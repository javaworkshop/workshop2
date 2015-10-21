package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table
public class Factuur implements Serializable {

    /*
    • vloer
        ◦ aantallen
        ◦ prijs
    • producten
        ◦ aantallen
        ◦ prijs
    • totaalprijs
        ◦ inclusief btw
        ◦ exclusief btw
    • uiterste betaaldatum 
    • opmerkingen
    */
    
    /*DOE IETS MET DE PRIJZEN! DAAR WORDT NU GEEN INFO OVER OPGESLAGEN, OOK NIET IN DE PRODUCT KLASSE*/
    
    @Column(name = "factuur_id") @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @ElementCollection @ManyToMany @CollectionTable(name = "factuur_vloeren", joinColumns = @JoinColumn(name = "factuur_id"))
    private List<Vloer> vloeren = new ArrayList<Vloer>();
    @ElementCollection @ManyToMany @CollectionTable(name = "factuur_producten", joinColumns = @JoinColumn(name = "factuur_id"))
    private List<Product> producten = new ArrayList<Product>();
    @Column(name = "totaal_prijs")
    private Integer totaalPrijsInCentZonderBtw;
    @Column(name = "btw_tarief")
    private Integer btwTarief;
    @Column @Temporal(TemporalType.DATE)
    private Date uitersteBetaalDatum;
    @Column
    private String opmerkingen;

    public Factuur(){}
    
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
     * @param btwTariefInCent the btwTariefInCent to set
     */
    public void setBtwTarief(Integer btwTarief) {
        this.btwTarief = btwTarief;
    }

    /**
     * @return the uitersteBetaalDatum
     */
    public Date getUitersteBetaalDatum() {
        return uitersteBetaalDatum;
    }

    /**
     * @param uitersteBetaalDatum the uitersteBetaalDatum to set
     */
    public void setUitersteBetaalDatum(Date uitersteBetaalDatum) {
        this.uitersteBetaalDatum = uitersteBetaalDatum;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.vloeren);
        hash = 23 * hash + Objects.hashCode(this.producten);
        hash = 23 * hash + Objects.hashCode(this.totaalPrijsInCentZonderBtw);
        hash = 23 * hash + Objects.hashCode(this.btwTarief);
        hash = 23 * hash + Objects.hashCode(this.uitersteBetaalDatum);
        hash = 23 * hash + Objects.hashCode(this.opmerkingen);
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
        final Factuur other = (Factuur) obj;
        if (!Objects.equals(this.vloeren, other.vloeren)) {
            return false;
        }
        if (!Objects.equals(this.producten, other.producten)) {
            return false;
        }
        if (!Objects.equals(this.totaalPrijsInCentZonderBtw, other.totaalPrijsInCentZonderBtw)) {
            return false;
        }
        if (!Objects.equals(this.btwTarief, other.btwTarief)) {
            return false;
        }
        if (!Objects.equals(this.uitersteBetaalDatum, other.uitersteBetaalDatum)) {
            return false;
        }
        if (!Objects.equals(this.opmerkingen, other.opmerkingen)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Factuur{" + "id=" + id + ", vloeren=" + vloeren + ", producten=" + producten + ", totaalPrijsInCentZonderBtw=" + totaalPrijsInCentZonderBtw + ", btwTarief=" + btwTarief + ", uitersteBetaalDatum=" + uitersteBetaalDatum + ", opmerkingen=" + opmerkingen + '}';
    }
    
}