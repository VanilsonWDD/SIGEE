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
@Table(name = "equipa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipa.findAll", query = "SELECT e FROM Equipa e"),
    @NamedQuery(name = "Equipa.findByCodigoEquipa", query = "SELECT e FROM Equipa e WHERE e.codigoEquipa = :codigoEquipa"),
    @NamedQuery(name = "Equipa.findByNomeEquipa", query = "SELECT e FROM Equipa e WHERE e.nomeEquipa = :nomeEquipa")})
public class Equipa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_equipa")
    private Integer codigoEquipa;
    @Size(max = 45)
    @Column(name = "nome_equipa")
    private String nomeEquipa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoEquipa")
    private Collection<Intervencao> intervencaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoEquipa")
    private Collection<EquipaResponsavel> equipaResponsavelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipa")
    private Collection<EquipaFuncionario> equipaFuncionarioCollection;
    @OneToMany(mappedBy = "codigoEquipa")
    private Collection<Ticket> ticketCollection;

    public Equipa() {
    }

    public Equipa(Integer codigoEquipa) {
        this.codigoEquipa = codigoEquipa;
    }

    public Integer getCodigoEquipa() {
        return codigoEquipa;
    }

    public void setCodigoEquipa(Integer codigoEquipa) {
        this.codigoEquipa = codigoEquipa;
    }

    public String getNomeEquipa() {
        return nomeEquipa;
    }

    public void setNomeEquipa(String nomeEquipa) {
        this.nomeEquipa = nomeEquipa;
    }

    @XmlTransient
    public Collection<Intervencao> getIntervencaoCollection() {
        return intervencaoCollection;
    }

    public void setIntervencaoCollection(Collection<Intervencao> intervencaoCollection) {
        this.intervencaoCollection = intervencaoCollection;
    }

    @XmlTransient
    public Collection<EquipaResponsavel> getEquipaResponsavelCollection() {
        return equipaResponsavelCollection;
    }

    public void setEquipaResponsavelCollection(Collection<EquipaResponsavel> equipaResponsavelCollection) {
        this.equipaResponsavelCollection = equipaResponsavelCollection;
    }

    @XmlTransient
    public Collection<EquipaFuncionario> getEquipaFuncionarioCollection() {
        return equipaFuncionarioCollection;
    }

    public void setEquipaFuncionarioCollection(Collection<EquipaFuncionario> equipaFuncionarioCollection) {
        this.equipaFuncionarioCollection = equipaFuncionarioCollection;
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
        hash += (codigoEquipa != null ? codigoEquipa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipa)) {
            return false;
        }
        Equipa other = (Equipa) object;
        if ((this.codigoEquipa == null && other.codigoEquipa != null) || (this.codigoEquipa != null && !this.codigoEquipa.equals(other.codigoEquipa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Equipa[ codigoEquipa=" + codigoEquipa + " ]";
    }
    
}
