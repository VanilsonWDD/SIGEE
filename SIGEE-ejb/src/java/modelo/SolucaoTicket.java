/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vanilson
 */
@Entity
@Table(name = "solucao_ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolucaoTicket.findAll", query = "SELECT s FROM SolucaoTicket s"),
    @NamedQuery(name = "SolucaoTicket.findByCodigoSolucaoTicket", query = "SELECT s FROM SolucaoTicket s WHERE s.codigoSolucaoTicket = :codigoSolucaoTicket")})
public class SolucaoTicket implements Serializable {
    @Column(name = "data_solucao_ticket")
    @Temporal(TemporalType.DATE)
    private Date dataSolucaoTicket;
    @JoinColumn(name = "codigo_estado", referencedColumnName = "codigo_estado")
    @ManyToOne(optional = false)
    private Estado codigoEstado;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_solucao_ticket")
    private Integer codigoSolucaoTicket;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "solucao_ticket")
    private String solucaoTicket;
    @JoinColumn(name = "codigo_ticket", referencedColumnName = "codigo_ticket")
    @ManyToOne(optional = false)
    private Ticket codigoTicket;

    public SolucaoTicket() {
    }

    public SolucaoTicket(Integer codigoSolucaoTicket) {
        this.codigoSolucaoTicket = codigoSolucaoTicket;
    }

    public Integer getCodigoSolucaoTicket() {
        return codigoSolucaoTicket;
    }

    public void setCodigoSolucaoTicket(Integer codigoSolucaoTicket) {
        this.codigoSolucaoTicket = codigoSolucaoTicket;
    }

    public String getSolucaoTicket() {
        return solucaoTicket;
    }

    public void setSolucaoTicket(String solucaoTicket) {
        this.solucaoTicket = solucaoTicket;
    }

    public Ticket getCodigoTicket() {
        return codigoTicket;
    }

    public void setCodigoTicket(Ticket codigoTicket) {
        this.codigoTicket = codigoTicket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoSolucaoTicket != null ? codigoSolucaoTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolucaoTicket)) {
            return false;
        }
        SolucaoTicket other = (SolucaoTicket) object;
        if ((this.codigoSolucaoTicket == null && other.codigoSolucaoTicket != null) || (this.codigoSolucaoTicket != null && !this.codigoSolucaoTicket.equals(other.codigoSolucaoTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.SolucaoTicket[ codigoSolucaoTicket=" + codigoSolucaoTicket + " ]";
    }

    public Date getDataSolucaoTicket() {
        return dataSolucaoTicket;
    }

    public void setDataSolucaoTicket(Date dataSolucaoTicket) {
        this.dataSolucaoTicket = dataSolucaoTicket;
    }

    public Estado getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Estado codigoEstado) {
        this.codigoEstado = codigoEstado;
    }
    
}
