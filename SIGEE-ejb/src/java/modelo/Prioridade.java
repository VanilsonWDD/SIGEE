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
@Table(name = "prioridade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prioridade.findAll", query = "SELECT p FROM Prioridade p"),
    @NamedQuery(name = "Prioridade.findByCodigoPrioridade", query = "SELECT p FROM Prioridade p WHERE p.codigoPrioridade = :codigoPrioridade"),
    @NamedQuery(name = "Prioridade.findByTipoPrioridade", query = "SELECT p FROM Prioridade p WHERE p.tipoPrioridade = :tipoPrioridade")})
public class Prioridade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_prioridade")
    private Integer codigoPrioridade;
    @Size(max = 45)
    @Column(name = "tipo_prioridade")
    private String tipoPrioridade;
    @OneToMany(mappedBy = "codigoPrioridade")
    private Collection<Ticket> ticketCollection;

    public Prioridade() {
    }

    public Prioridade(Integer codigoPrioridade) {
        this.codigoPrioridade = codigoPrioridade;
    }

    public Integer getCodigoPrioridade() {
        return codigoPrioridade;
    }

    public void setCodigoPrioridade(Integer codigoPrioridade) {
        this.codigoPrioridade = codigoPrioridade;
    }

    public String getTipoPrioridade() {
        return tipoPrioridade;
    }

    public void setTipoPrioridade(String tipoPrioridade) {
        this.tipoPrioridade = tipoPrioridade;
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
        hash += (codigoPrioridade != null ? codigoPrioridade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prioridade)) {
            return false;
        }
        Prioridade other = (Prioridade) object;
        if ((this.codigoPrioridade == null && other.codigoPrioridade != null) || (this.codigoPrioridade != null && !this.codigoPrioridade.equals(other.codigoPrioridade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Prioridade[ codigoPrioridade=" + codigoPrioridade + " ]";
    }
    
}
