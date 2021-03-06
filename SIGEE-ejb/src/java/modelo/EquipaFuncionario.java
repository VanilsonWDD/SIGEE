/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "equipa_funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipaFuncionario.findAll", query = "SELECT e FROM EquipaFuncionario e"),
    @NamedQuery(name = "EquipaFuncionario.findByCodigoEquipaFuncionario", query = "SELECT e FROM EquipaFuncionario e WHERE e.equipaFuncionarioPK.codigoEquipaFuncionario = :codigoEquipaFuncionario"),
    @NamedQuery(name = "EquipaFuncionario.findByCodigoEquipa", query = "SELECT e FROM EquipaFuncionario e WHERE e.equipaFuncionarioPK.codigoEquipa = :codigoEquipa")})
public class EquipaFuncionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EquipaFuncionarioPK equipaFuncionarioPK;
    @JoinColumn(name = "codigo_equipa", referencedColumnName = "codigo_equipa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipa equipa;
    @JoinColumn(name = "pk_funcionario", referencedColumnName = "pk_funcionario")
    @ManyToOne(optional = false)
    private TbFuncionario pkFuncionario;

    public EquipaFuncionario() {
    }

    public EquipaFuncionario(EquipaFuncionarioPK equipaFuncionarioPK) {
        this.equipaFuncionarioPK = equipaFuncionarioPK;
    }

    public EquipaFuncionario(int codigoEquipaFuncionario, int codigoEquipa) {
        this.equipaFuncionarioPK = new EquipaFuncionarioPK(codigoEquipaFuncionario, codigoEquipa);
    }

    public EquipaFuncionarioPK getEquipaFuncionarioPK() {
        return equipaFuncionarioPK;
    }

    public void setEquipaFuncionarioPK(EquipaFuncionarioPK equipaFuncionarioPK) {
        this.equipaFuncionarioPK = equipaFuncionarioPK;
    }

    public Equipa getEquipa() {
        return equipa;
    }

    public void setEquipa(Equipa equipa) {
        this.equipa = equipa;
    }

    public TbFuncionario getPkFuncionario() {
        return pkFuncionario;
    }

    public void setPkFuncionario(TbFuncionario pkFuncionario) {
        this.pkFuncionario = pkFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipaFuncionarioPK != null ? equipaFuncionarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipaFuncionario)) {
            return false;
        }
        EquipaFuncionario other = (EquipaFuncionario) object;
        if ((this.equipaFuncionarioPK == null && other.equipaFuncionarioPK != null) || (this.equipaFuncionarioPK != null && !this.equipaFuncionarioPK.equals(other.equipaFuncionarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EquipaFuncionario[ equipaFuncionarioPK=" + equipaFuncionarioPK + " ]";
    }
    
}
