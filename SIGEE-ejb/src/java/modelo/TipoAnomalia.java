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
@Table(name = "tipo_anomalia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAnomalia.findAll", query = "SELECT t FROM TipoAnomalia t"),
    @NamedQuery(name = "TipoAnomalia.findByCodigoTipoAnomalia", query = "SELECT t FROM TipoAnomalia t WHERE t.codigoTipoAnomalia = :codigoTipoAnomalia"),
    @NamedQuery(name = "TipoAnomalia.findByTipoAnomalia", query = "SELECT t FROM TipoAnomalia t WHERE t.tipoAnomalia = :tipoAnomalia")})
public class TipoAnomalia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_tipo_anomalia")
    private Integer codigoTipoAnomalia;
    @Size(max = 45)
    @Column(name = "tipo_anomalia")
    private String tipoAnomalia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTipoAnomalia")
    private Collection<Site> siteCollection;

    public TipoAnomalia() {
    }

    public TipoAnomalia(Integer codigoTipoAnomalia) {
        this.codigoTipoAnomalia = codigoTipoAnomalia;
    }

    public Integer getCodigoTipoAnomalia() {
        return codigoTipoAnomalia;
    }

    public void setCodigoTipoAnomalia(Integer codigoTipoAnomalia) {
        this.codigoTipoAnomalia = codigoTipoAnomalia;
    }

    public String getTipoAnomalia() {
        return tipoAnomalia;
    }

    public void setTipoAnomalia(String tipoAnomalia) {
        this.tipoAnomalia = tipoAnomalia;
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
        hash += (codigoTipoAnomalia != null ? codigoTipoAnomalia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAnomalia)) {
            return false;
        }
        TipoAnomalia other = (TipoAnomalia) object;
        if ((this.codigoTipoAnomalia == null && other.codigoTipoAnomalia != null) || (this.codigoTipoAnomalia != null && !this.codigoTipoAnomalia.equals(other.codigoTipoAnomalia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoAnomalia[ codigoTipoAnomalia=" + codigoTipoAnomalia + " ]";
    }
    
}
