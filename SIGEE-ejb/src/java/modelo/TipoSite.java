/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vanilson
 */
@Entity
@Table(name = "tipo_site")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoSite.findAll", query = "SELECT t FROM TipoSite t"),
    @NamedQuery(name = "TipoSite.findByCodigoTipoSite", query = "SELECT t FROM TipoSite t WHERE t.codigoTipoSite = :codigoTipoSite"),
    @NamedQuery(name = "TipoSite.findByTipoSite", query = "SELECT t FROM TipoSite t WHERE t.tipoSite = :tipoSite")})
public class TipoSite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_tipo_site")
    private Integer codigoTipoSite;
    @Size(max = 45)
    @Column(name = "tipo_site")
    private String tipoSite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTipoSite")
    private Collection<Site> siteCollection;

    public TipoSite() {
    }

    public TipoSite(Integer codigoTipoSite) {
        this.codigoTipoSite = codigoTipoSite;
    }

    public Integer getCodigoTipoSite() {
        return codigoTipoSite;
    }

    public void setCodigoTipoSite(Integer codigoTipoSite) {
        this.codigoTipoSite = codigoTipoSite;
    }

    public String getTipoSite() {
        return tipoSite;
    }

    public void setTipoSite(String tipoSite) {
        this.tipoSite = tipoSite;
    }

    @XmlTransient
    public Collection<Site> getSiteCollection() {
        return siteCollection;
    }

    public void setSiteCollection(Collection<Site> siteCollection) {
        this.siteCollection = siteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTipoSite != null ? codigoTipoSite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSite)) {
            return false;
        }
        TipoSite other = (TipoSite) object;
        if ((this.codigoTipoSite == null && other.codigoTipoSite != null) || (this.codigoTipoSite != null && !this.codigoTipoSite.equals(other.codigoTipoSite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoSite[ codigoTipoSite=" + codigoTipoSite + " ]";
    }
    
}
