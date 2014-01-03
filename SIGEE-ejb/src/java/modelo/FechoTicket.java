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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vanilson
 */
@Entity
@Table(name = "fecho_ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FechoTicket.findAll", query = "SELECT f FROM FechoTicket f"),
    @NamedQuery(name = "FechoTicket.findByCodigoFechoTicket", query = "SELECT f FROM FechoTicket f WHERE f.codigoFechoTicket = :codigoFechoTicket"),
    @NamedQuery(name = "FechoTicket.findByComentarioFechoTicket", query = "SELECT f FROM FechoTicket f WHERE f.comentarioFechoTicket = :comentarioFechoTicket"),
    @NamedQuery(name = "FechoTicket.findByDataFechoTicket", query = "SELECT f FROM FechoTicket f WHERE f.dataFechoTicket = :dataFechoTicket")})
public class FechoTicket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_fecho_ticket")
    private Integer codigoFechoTicket;
    @Size(max = 45)
    @Column(name = "comentario_fecho_ticket")
    private String comentarioFechoTicket;
    @Size(max = 45)
    @Column(name = "data_fecho_ticket")
    private String dataFechoTicket;
    @OneToMany(mappedBy = "codigoFechoTicket")
    private Collection<Ticket> ticketCollection;

    public FechoTicket() {
    }

    public FechoTicket(Integer codigoFechoTicket) {
        this.codigoFechoTicket = codigoFechoTicket;
    }

    public Integer getCodigoFechoTicket() {
        return codigoFechoTicket;
    }

    public void setCodigoFechoTicket(Integer codigoFechoTicket) {
        this.codigoFechoTicket = codigoFechoTicket;
    }

    public String getComentarioFechoTicket() {
        return comentarioFechoTicket;
    }

    public void setComentarioFechoTicket(String comentarioFechoTicket) {
        this.comentarioFechoTicket = comentarioFechoTicket;
    }

    public String getDataFechoTicket() {
        return dataFechoTicket;
    }

    public void setDataFechoTicket(String dataFechoTicket) {
        this.dataFechoTicket = dataFechoTicket;
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
        hash += (codigoFechoTicket != null ? codigoFechoTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FechoTicket)) {
            return false;
        }
        FechoTicket other = (FechoTicket) object;
        if ((this.codigoFechoTicket == null && other.codigoFechoTicket != null) || (this.codigoFechoTicket != null && !this.codigoFechoTicket.equals(other.codigoFechoTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.FechoTicket[ codigoFechoTicket=" + codigoFechoTicket + " ]";
    }
    
}
