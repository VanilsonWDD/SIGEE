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
public class TipoAcessoFuncionarioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_tipo_acesso_funcionario")
    private int codigoTipoAcessoFuncionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_funcionario")
    private int pkFuncionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_tipo_acesso")
    private int codigoTipoAcesso;

    public TipoAcessoFuncionarioPK() {
    }

    public TipoAcessoFuncionarioPK(int codigoTipoAcessoFuncionario, int pkFuncionario, int codigoTipoAcesso) {
        this.codigoTipoAcessoFuncionario = codigoTipoAcessoFuncionario;
        this.pkFuncionario = pkFuncionario;
        this.codigoTipoAcesso = codigoTipoAcesso;
    }

    public int getCodigoTipoAcessoFuncionario() {
        return codigoTipoAcessoFuncionario;
    }

    public void setCodigoTipoAcessoFuncionario(int codigoTipoAcessoFuncionario) {
        this.codigoTipoAcessoFuncionario = codigoTipoAcessoFuncionario;
    }

    public int getPkFuncionario() {
        return pkFuncionario;
    }

    public void setPkFuncionario(int pkFuncionario) {
        this.pkFuncionario = pkFuncionario;
    }

    public int getCodigoTipoAcesso() {
        return codigoTipoAcesso;
    }

    public void setCodigoTipoAcesso(int codigoTipoAcesso) {
        this.codigoTipoAcesso = codigoTipoAcesso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoTipoAcessoFuncionario;
        hash += (int) pkFuncionario;
        hash += (int) codigoTipoAcesso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAcessoFuncionarioPK)) {
            return false;
        }
        TipoAcessoFuncionarioPK other = (TipoAcessoFuncionarioPK) object;
        if (this.codigoTipoAcessoFuncionario != other.codigoTipoAcessoFuncionario) {
            return false;
        }
        if (this.pkFuncionario != other.pkFuncionario) {
            return false;
        }
        if (this.codigoTipoAcesso != other.codigoTipoAcesso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoAcessoFuncionarioPK[ codigoTipoAcessoFuncionario=" + codigoTipoAcessoFuncionario + ", pkFuncionario=" + pkFuncionario + ", codigoTipoAcesso=" + codigoTipoAcesso + " ]";
    }
    
}
