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
@Table(name = "impacto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Impacto.findAll", query = "SELECT i FROM Impacto i"),
    @NamedQuery(name = "Impacto.findByCodigoImpacto", query = "SELECT i FROM Impacto i WHERE i.codigoImpacto = :codigoImpacto"),
    @NamedQuery(name = "Impacto.findByTipoImpacto", query = "SELECT i FROM Impacto i WHERE i.tipoImpacto = :tipoImpacto")})
public class Impacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_impacto")
    private Integer codigoImpacto;
    @Size(max = 45)
    @Column(name = "tipo_impacto")
    private String tipoImpacto;
    @OneToMany(mappedBy = "codigoImpacto")
    private Collection<Ticket> ticketCollection;

    public Impacto() {
    }

    public Impacto(Integer codigoImpacto) {
        this.codigoImpacto = codigoImpacto;
    }

    public Integer getCodigoImpacto() {
        return codigoImpacto;
    }

    public void setCodigoImpacto(Integer codigoImpacto) {
        this.codigoImpacto = codigoImpacto;
    }

    public String getTipoImpacto() {
        return tipoImpacto;
    }

    public void setTipoImpacto(String tipoImpacto) {
        this.tipoImpacto = tipoImpacto;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoImpacto != null ? codigoImpacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Impacto)) {
            return false;
        }
        Impacto other = (Impacto) object;
        if ((this.codigoImpacto == null && other.codigoImpacto != null) || (this.codigoImpacto != null && !this.codigoImpacto.equals(other.codigoImpacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Impacto[ codigoImpacto=" + codigoImpacto + " ]";
    }
    
}
