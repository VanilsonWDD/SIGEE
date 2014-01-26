/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vanilson
 */
@Entity
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findByCodigoTicket", query = "SELECT t FROM Ticket t WHERE t.codigoTicket = :codigoTicket"),
    @NamedQuery(name = "Ticket.findByDataProblemaTicket", query = "SELECT t FROM Ticket t WHERE t.dataProblemaTicket = :dataProblemaTicket")})
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_ticket")
    private Integer codigoTicket;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "descricao_ticket")
    private String descricaoTicket;
    @Column(name = "data_problema_ticket")
    @Temporal(TemporalType.DATE)
    private Date dataProblemaTicket;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTicket")
    private Collection<FechoTicket> fechoTicketCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTicket")
    private Collection<Intervencao> intervencaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTicket")
    private Collection<SolucaoTicket> solucaoTicketCollection;
    @JoinColumn(name = "codigo_site", referencedColumnName = "codigo_site")
    @ManyToOne
    private Site codigoSite;
    @JoinColumn(name = "codigo_prioridade", referencedColumnName = "codigo_prioridade")
    @ManyToOne
    private Prioridade codigoPrioridade;
    @JoinColumn(name = "codigo_impacto", referencedColumnName = "codigo_impacto")
    @ManyToOne
    private Impacto codigoImpacto;
    @JoinColumn(name = "codigo_funcionario", referencedColumnName = "codigo_funcionario")
    @ManyToOne
    private Funcionario codigoFuncionario;
    @JoinColumn(name = "codigo_estado", referencedColumnName = "codigo_estado")
    @ManyToOne
    private Estado codigoEstado;
    @JoinColumn(name = "codigo_equipa", referencedColumnName = "codigo_equipa")
    @ManyToOne
    private Equipa codigoEquipa;

    public Ticket() {
    }

    public Ticket(Integer codigoTicket) {
        this.codigoTicket = codigoTicket;
    }

    public Integer getCodigoTicket() {
        return codigoTicket;
    }

    public void setCodigoTicket(Integer codigoTicket) {
        this.codigoTicket = codigoTicket;
    }

    public String getDescricaoTicket() {
        return descricaoTicket;
    }

    public void setDescricaoTicket(String descricaoTicket) {
        this.descricaoTicket = descricaoTicket;
    }

    public Date getDataProblemaTicket() {
        return dataProblemaTicket;
    }

    public void setDataProblemaTicket(Date dataProblemaTicket) {
        this.dataProblemaTicket = dataProblemaTicket;
    }

    @XmlTransient
    public Collection<FechoTicket> getFechoTicketCollection() {
        return fechoTicketCollection;
    }

    public void setFechoTicketCollection(Collection<FechoTicket> fechoTicketCollection) {
        this.fechoTicketCollection = fechoTicketCollection;
    }

    @XmlTransient
    public Collection<Intervencao> getIntervencaoCollection() {
        return intervencaoCollection;
    }

    public void setIntervencaoCollection(Collection<Intervencao> intervencaoCollection) {
        this.intervencaoCollection = intervencaoCollection;
    }

    @XmlTransient
    public Collection<SolucaoTicket> getSolucaoTicketCollection() {
        return solucaoTicketCollection;
    }

    public void setSolucaoTicketCollection(Collection<SolucaoTicket> solucaoTicketCollection) {
        this.solucaoTicketCollection = solucaoTicketCollection;
    }

    public Site getCodigoSite() {
        return codigoSite;
    }

    public void setCodigoSite(Site codigoSite) {
        this.codigoSite = codigoSite;
    }

    public Prioridade getCodigoPrioridade() {
        return codigoPrioridade;
    }

    public void setCodigoPrioridade(Prioridade codigoPrioridade) {
        this.codigoPrioridade = codigoPrioridade;
    }

    public Impacto getCodigoImpacto() {
        return codigoImpacto;
    }

    public void setCodigoImpacto(Impacto codigoImpacto) {
        this.codigoImpacto = codigoImpacto;
    }

    public Funcionario getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(Funcionario codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public Estado getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Estado codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public Equipa getCodigoEquipa() {
        return codigoEquipa;
    }

    public void setCodigoEquipa(Equipa codigoEquipa) {
        this.codigoEquipa = codigoEquipa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTicket != null ? codigoTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.codigoTicket == null && other.codigoTicket != null) || (this.codigoTicket != null && !this.codigoTicket.equals(other.codigoTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ticket[ codigoTicket=" + codigoTicket + " ]";
    }
    
}
