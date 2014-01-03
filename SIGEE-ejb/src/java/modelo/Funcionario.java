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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vanilson
 */
@Entity
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByCodigoFuncionario", query = "SELECT f FROM Funcionario f WHERE f.codigoFuncionario = :codigoFuncionario"),
    @NamedQuery(name = "Funcionario.findByNomeFuncionario", query = "SELECT f FROM Funcionario f WHERE f.nomeFuncionario = :nomeFuncionario")})
public class Funcionario implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "username_funcionario")
    private String usernameFuncionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "senha_funcionario")
    private String senhaFuncionario;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_funcionario")
    private Integer codigoFuncionario;
    @Size(max = 45)
    @Column(name = "nome_funcionario")
    private String nomeFuncionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoFuncionario")
    private Collection<EquipaResponsavel> equipaResponsavelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
    private Collection<EquipaFuncionario> equipaFuncionarioCollection;
    @OneToMany(mappedBy = "codigoFuncionario")
    private Collection<Ticket> ticketCollection;

    public Funcionario() {
    }

    public Funcionario(Integer codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public Integer getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(Integer codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
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
        hash += (codigoFuncionario != null ? codigoFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.codigoFuncionario == null && other.codigoFuncionario != null) || (this.codigoFuncionario != null && !this.codigoFuncionario.equals(other.codigoFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Funcionario[ codigoFuncionario=" + codigoFuncionario + " ]";
    }

    public String getUsernameFuncionario() {
        return usernameFuncionario;
    }

    public void setUsernameFuncionario(String usernameFuncionario) {
        this.usernameFuncionario = usernameFuncionario;
    }

    public String getSenhaFuncionario() {
        return senhaFuncionario;
    }

    public void setSenhaFuncionario(String senhaFuncionario) {
        this.senhaFuncionario = senhaFuncionario;
    }
    
}
