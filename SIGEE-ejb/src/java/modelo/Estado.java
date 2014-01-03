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
@Table(name = "estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
    @NamedQuery(name = "Estado.findByCodigoEstado", query = "SELECT e FROM Estado e WHERE e.codigoEstado = :codigoEstado"),
    @NamedQuery(name = "Estado.findByTipoEstado", query = "SELECT e FROM Estado e WHERE e.tipoEstado = :tipoEstado")})
public class Estado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_estado")
    private Integer codigoEstado;
    @Size(max = 45)
    @Column(name = "tipo_estado")
    private String tipoEstado;
    @OneToMany(mappedBy = "codigoEstado")
    private Collection<Ticket> ticketCollection;

    public Estado() {
    }

    public Estado(Integer codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public Integer getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Integer codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
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
        hash += (codigoEstado != null ? codigoEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.codigoEstado == null && other.codigoEstado != null) || (this.codigoEstado != null && !this.codigoEstado.equals(other.codigoEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Estado[ codigoEstado=" + codigoEstado + " ]";
    }
    
}
