/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "site")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Site.findAll", query = "SELECT s FROM Site s"),
    @NamedQuery(name = "Site.findByCodigoSite", query = "SELECT s FROM Site s WHERE s.codigoSite = :codigoSite"),
    @NamedQuery(name = "Site.findByNomeSite", query = "SELECT s FROM Site s WHERE s.nomeSite = :nomeSite"),
    @NamedQuery(name = "Site.findByLatitude", query = "SELECT s FROM Site s WHERE s.latitude = :latitude"),
    @NamedQuery(name = "Site.findByLongitude", query = "SELECT s FROM Site s WHERE s.longitude = :longitude")})
public class Site implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_site")
    private Integer codigoSite;
    @Size(max = 45)
    @Column(name = "nome_site")
    private String nomeSite;
    @Column(name = "latitude")
    private Integer latitude;
    @Column(name = "longitude")
    private Integer longitude;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "caminho_foto_site")
    private String caminhoFotoSite;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "nome_foto_site")
    private String nomeFotoSite;
    @OneToMany(mappedBy = "codigoSite")
    private Collection<Ticket> ticketCollection;
    @JoinColumn(name = "codigo_tipo_site", referencedColumnName = "codigo_tipo_site")
    @ManyToOne(optional = false)
    private TipoSite codigoTipoSite;
    @JoinColumn(name = "codigo_tipo_anomalia", referencedColumnName = "codigo_tipo_anomalia")
    @ManyToOne(optional = false)
    private TipoAnomalia codigoTipoAnomalia;

    public Site() {
    }

    public Site(Integer codigoSite) {
        this.codigoSite = codigoSite;
    }

    public Integer getCodigoSite() {
        return codigoSite;
    }

    public void setCodigoSite(Integer codigoSite) {
        this.codigoSite = codigoSite;
    }

    public String getNomeSite() {
        return nomeSite;
    }

    public void setNomeSite(String nomeSite) {
        this.nomeSite = nomeSite;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public String getCaminhoFotoSite() {
        return caminhoFotoSite;
    }

    public void setCaminhoFotoSite(String caminhoFotoSite) {
        this.caminhoFotoSite = caminhoFotoSite;
    }

    public String getNomeFotoSite() {
        return nomeFotoSite;
    }

    public void setNomeFotoSite(String nomeFotoSite) {
        this.nomeFotoSite = nomeFotoSite;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    public TipoSite getCodigoTipoSite() {
        return codigoTipoSite;
    }

    public void setCodigoTipoSite(TipoSite codigoTipoSite) {
        this.codigoTipoSite = codigoTipoSite;
    }

    public TipoAnomalia getCodigoTipoAnomalia() {
        return codigoTipoAnomalia;
    }

    public void setCodigoTipoAnomalia(TipoAnomalia codigoTipoAnomalia) {
        this.codigoTipoAnomalia = codigoTipoAnomalia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoSite != null ? codigoSite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Site)) {
            return false;
        }
        Site other = (Site) object;
        if ((this.codigoSite == null && other.codigoSite != null) || (this.codigoSite != null && !this.codigoSite.equals(other.codigoSite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Site[ codigoSite=" + codigoSite + " ]";
    }
    
}
