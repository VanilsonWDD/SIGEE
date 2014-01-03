/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vanilson
 */
@Entity
@Table(name = "equipa_responsavel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipaResponsavel.findAll", query = "SELECT e FROM EquipaResponsavel e"),
    @NamedQuery(name = "EquipaResponsavel.findByCodigoEquipaResponsavel", query = "SELECT e FROM EquipaResponsavel e WHERE e.codigoEquipaResponsavel = :codigoEquipaResponsavel")})
public class EquipaResponsavel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_equipa_responsavel")
    private Integer codigoEquipaResponsavel;
    @JoinColumn(name = "codigo_funcionario", referencedColumnName = "codigo_funcionario")
    @ManyToOne(optional = false)
    private Funcionario codigoFuncionario;
    @JoinColumn(name = "codigo_equipa", referencedColumnName = "codigo_equipa")
    @ManyToOne(optional = false)
    private Equipa codigoEquipa;

    public EquipaResponsavel() {
    }

    public EquipaResponsavel(Integer codigoEquipaResponsavel) {
        this.codigoEquipaResponsavel = codigoEquipaResponsavel;
    }

    public Integer getCodigoEquipaResponsavel() {
        return codigoEquipaResponsavel;
    }

    public void setCodigoEquipaResponsavel(Integer codigoEquipaResponsavel) {
        this.codigoEquipaResponsavel = codigoEquipaResponsavel;
    }

    public Funcionario getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(Funcionario codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
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
        hash += (codigoEquipaResponsavel != null ? codigoEquipaResponsavel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipaResponsavel)) {
            return false;
        }
        EquipaResponsavel other = (EquipaResponsavel) object;
        if ((this.codigoEquipaResponsavel == null && other.codigoEquipaResponsavel != null) || (this.codigoEquipaResponsavel != null && !this.codigoEquipaResponsavel.equals(other.codigoEquipaResponsavel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EquipaResponsavel[ codigoEquipaResponsavel=" + codigoEquipaResponsavel + " ]";
    }
    
}
