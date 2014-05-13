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
@Table(name = "tipo_acesso_funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAcessoFuncionario.findAll", query = "SELECT t FROM TipoAcessoFuncionario t"),
    @NamedQuery(name = "TipoAcessoFuncionario.findByCodigoTipoAcessoFuncionario", query = "SELECT t FROM TipoAcessoFuncionario t WHERE t.tipoAcessoFuncionarioPK.codigoTipoAcessoFuncionario = :codigoTipoAcessoFuncionario"),
    @NamedQuery(name = "TipoAcessoFuncionario.findByPkFuncionario", query = "SELECT t FROM TipoAcessoFuncionario t WHERE t.tipoAcessoFuncionarioPK.pkFuncionario = :pkFuncionario"),
    @NamedQuery(name = "TipoAcessoFuncionario.findByCodigoTipoAcesso", query = "SELECT t FROM TipoAcessoFuncionario t WHERE t.tipoAcessoFuncionarioPK.codigoTipoAcesso = :codigoTipoAcesso")})
public class TipoAcessoFuncionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoAcessoFuncionarioPK tipoAcessoFuncionarioPK;
    @JoinColumn(name = "codigo_tipo_acesso", referencedColumnName = "codigo_tipo_acesso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoAcesso tipoAcesso;
    @JoinColumn(name = "pk_funcionario", referencedColumnName = "pk_funcionario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbFuncionario tbFuncionario;

    public TipoAcessoFuncionario() {
    }

    public TipoAcessoFuncionario(TipoAcessoFuncionarioPK tipoAcessoFuncionarioPK) {
        this.tipoAcessoFuncionarioPK = tipoAcessoFuncionarioPK;
    }

    public TipoAcessoFuncionario(int codigoTipoAcessoFuncionario, int pkFuncionario, int codigoTipoAcesso) {
        this.tipoAcessoFuncionarioPK = new TipoAcessoFuncionarioPK(codigoTipoAcessoFuncionario, pkFuncionario, codigoTipoAcesso);
    }

    public TipoAcessoFuncionarioPK getTipoAcessoFuncionarioPK() {
        return tipoAcessoFuncionarioPK;
    }

    public void setTipoAcessoFuncionarioPK(TipoAcessoFuncionarioPK tipoAcessoFuncionarioPK) {
        this.tipoAcessoFuncionarioPK = tipoAcessoFuncionarioPK;
    }

    public TipoAcesso getTipoAcesso() {
        return tipoAcesso;
    }

    public void setTipoAcesso(TipoAcesso tipoAcesso) {
        this.tipoAcesso = tipoAcesso;
    }

    public TbFuncionario getTbFuncionario() {
        return tbFuncionario;
    }

    public void setTbFuncionario(TbFuncionario tbFuncionario) {
        this.tbFuncionario = tbFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoAcessoFuncionarioPK != null ? tipoAcessoFuncionarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAcessoFuncionario)) {
            return false;
        }
        TipoAcessoFuncionario other = (TipoAcessoFuncionario) object;
        if ((this.tipoAcessoFuncionarioPK == null && other.tipoAcessoFuncionarioPK != null) || (this.tipoAcessoFuncionarioPK != null && !this.tipoAcessoFuncionarioPK.equals(other.tipoAcessoFuncionarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoAcessoFuncionario[ tipoAcessoFuncionarioPK=" + tipoAcessoFuncionarioPK + " ]";
    }
    
}
