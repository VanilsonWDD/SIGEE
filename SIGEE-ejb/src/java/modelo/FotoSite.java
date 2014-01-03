/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vanilson
 */
@Entity
@Table(name = "foto_site")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FotoSite.findAll", query = "SELECT f FROM FotoSite f"),
    @NamedQuery(name = "FotoSite.findByCodigoFotoSite", query = "SELECT f FROM FotoSite f WHERE f.codigoFotoSite = :codigoFotoSite"),
    @NamedQuery(name = "FotoSite.findByPrimeiraFotoSite", query = "SELECT f FROM FotoSite f WHERE f.primeiraFotoSite = :primeiraFotoSite"),
    @NamedQuery(name = "FotoSite.findBySegundaFotoSite", query = "SELECT f FROM FotoSite f WHERE f.segundaFotoSite = :segundaFotoSite"),
    @NamedQuery(name = "FotoSite.findByTerceiraFotoSite", query = "SELECT f FROM FotoSite f WHERE f.terceiraFotoSite = :terceiraFotoSite"),
    @NamedQuery(name = "FotoSite.findByQuartaFotoSite", query = "SELECT f FROM FotoSite f WHERE f.quartaFotoSite = :quartaFotoSite"),
    @NamedQuery(name = "FotoSite.findByQuintafotoSite", query = "SELECT f FROM FotoSite f WHERE f.quintafotoSite = :quintafotoSite")})
public class FotoSite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_foto_site")
    private Integer codigoFotoSite;
    @Size(max = 45)
    @Column(name = "primeira_foto_site")
    private String primeiraFotoSite;
    @Size(max = 45)
    @Column(name = "segunda_foto_site")
    private String segundaFotoSite;
    @Size(max = 45)
    @Column(name = "terceira_foto_site")
    private String terceiraFotoSite;
    @Size(max = 45)
    @Column(name = "quarta_foto_site")
    private String quartaFotoSite;
    @Size(max = 45)
    @Column(name = "quinta_foto_Site")
    private String quintafotoSite;
    @JoinColumn(name = "codigo_site", referencedColumnName = "codigo_site")
    @ManyToOne(optional = false)
    private Site codigoSite;

    public FotoSite() {
    }

    public FotoSite(Integer codigoFotoSite) {
        this.codigoFotoSite = codigoFotoSite;
    }

    public Integer getCodigoFotoSite() {
        return codigoFotoSite;
    }

    public void setCodigoFotoSite(Integer codigoFotoSite) {
        this.codigoFotoSite = codigoFotoSite;
    }

    public String getPrimeiraFotoSite() {
        return primeiraFotoSite;
    }

    public void setPrimeiraFotoSite(String primeiraFotoSite) {
        this.primeiraFotoSite = primeiraFotoSite;
    }

    public String getSegundaFotoSite() {
        return segundaFotoSite;
    }

    public void setSegundaFotoSite(String segundaFotoSite) {
        this.segundaFotoSite = segundaFotoSite;
    }

    public String getTerceiraFotoSite() {
        return terceiraFotoSite;
    }

    public void setTerceiraFotoSite(String terceiraFotoSite) {
        this.terceiraFotoSite = terceiraFotoSite;
    }

    public String getQuartaFotoSite() {
        return quartaFotoSite;
    }

    public void setQuartaFotoSite(String quartaFotoSite) {
        this.quartaFotoSite = quartaFotoSite;
    }

    public String getQuintafotoSite() {
        return quintafotoSite;
    }

    public void setQuintafotoSite(String quintafotoSite) {
        this.quintafotoSite = quintafotoSite;
    }

    public Site getCodigoSite() {
        return codigoSite;
    }

    public void setCodigoSite(Site codigoSite) {
        this.codigoSite = codigoSite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoFotoSite != null ? codigoFotoSite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FotoSite)) {
            return false;
        }
        FotoSite other = (FotoSite) object;
        if ((this.codigoFotoSite == null && other.codigoFotoSite != null) || (this.codigoFotoSite != null && !this.codigoFotoSite.equals(other.codigoFotoSite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.FotoSite[ codigoFotoSite=" + codigoFotoSite + " ]";
    }
    
}
