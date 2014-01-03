/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Vanilson
 */
@Embeddable
public class EquipaFuncionarioPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "codigo_equipa_funcionario")
    private int codigoEquipaFuncionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_funcionario")
    private int codigoFuncionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_equipa")
    private int codigoEquipa;

    public EquipaFuncionarioPK() {
    }

    public EquipaFuncionarioPK(int codigoEquipaFuncionario, int codigoFuncionario, int codigoEquipa) {
        this.codigoEquipaFuncionario = codigoEquipaFuncionario;
        this.codigoFuncionario = codigoFuncionario;
        this.codigoEquipa = codigoEquipa;
    }

    public int getCodigoEquipaFuncionario() {
        return codigoEquipaFuncionario;
    }

    public void setCodigoEquipaFuncionario(int codigoEquipaFuncionario) {
        this.codigoEquipaFuncionario = codigoEquipaFuncionario;
    }

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public int getCodigoEquipa() {
        return codigoEquipa;
    }

    public void setCodigoEquipa(int codigoEquipa) {
        this.codigoEquipa = codigoEquipa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoEquipaFuncionario;
        hash += (int) codigoFuncionario;
        hash += (int) codigoEquipa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipaFuncionarioPK)) {
            return false;
        }
        EquipaFuncionarioPK other = (EquipaFuncionarioPK) object;
        if (this.codigoEquipaFuncionario != other.codigoEquipaFuncionario) {
            return false;
        }
        if (this.codigoFuncionario != other.codigoFuncionario) {
            return false;
        }
        if (this.codigoEquipa != other.codigoEquipa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EquipaFuncionarioPK[ codigoEquipaFuncionario=" + codigoEquipaFuncionario + ", codigoFuncionario=" + codigoFuncionario + ", codigoEquipa=" + codigoEquipa + " ]";
    }
    
}
