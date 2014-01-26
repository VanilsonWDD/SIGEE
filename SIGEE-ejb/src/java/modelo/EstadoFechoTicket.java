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
@Table(name = "estado_fecho_ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoFechoTicket.findAll", query = "SELECT e FROM EstadoFechoTicket e"),
    @NamedQuery(name = "EstadoFechoTicket.findByCodigoEstadoFecho", query = "SELECT e FROM EstadoFechoTicket e WHERE e.codigoEstadoFecho = :codigoEstadoFecho"),
    @NamedQuery(name = "EstadoFechoTicket.findByTipoEstadoFecho", query = "SELECT e FROM EstadoFechoTicket e WHERE e.tipoEstadoFecho = :tipoEstadoFecho")})
public class EstadoFechoTicket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_estado_fecho")
    private Integer codigoEstadoFecho;
    @Size(max = 45)
    @Column(name = "tipo_estado_fecho")
    private String tipoEstadoFecho;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoEstadoFecho")
    private Collection<FechoTicket> fechoTicketCollection;

    public EstadoFechoTicket() {
    }

    public EstadoFechoTicket(Integer codigoEstadoFecho) {
        this.codigoEstadoFecho = codigoEstadoFecho;
    }

    public Integer getCodigoEstadoFecho() {
        return codigoEstadoFecho;
    }

    public void setCodigoEstadoFecho(Integer codigoEstadoFecho) {
        this.codigoEstadoFecho = codigoEstadoFecho;
    }

    public String getTipoEstadoFecho() {
        return tipoEstadoFecho;
    }

    public void setTipoEstadoFecho(String tipoEstadoFecho) {
        this.tipoEstadoFecho = tipoEstadoFecho;
    }

    @XmlTransient
    public Collection<FechoTicket> getFechoTicketCollection() {
        return fechoTicketCollection;
    }

    public void setFechoTicketCollection(Collection<FechoTicket> fechoTicketCollection) {
        this.fechoTicketCollection = fechoTicketCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEstadoFecho != null ? codigoEstadoFecho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoFechoTicket)) {
            return false;
        }
        EstadoFechoTicket other = (EstadoFechoTicket) object;
        if ((this.codigoEstadoFecho == null && other.codigoEstadoFecho != null) || (this.codigoEstadoFecho != null && !this.codigoEstadoFecho.equals(other.codigoEstadoFecho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EstadoFechoTicket[ codigoEstadoFecho=" + codigoEstadoFecho + " ]";
    }
    
}
