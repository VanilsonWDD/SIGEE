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
@Table(name = "tipo_acesso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAcesso.findAll", query = "SELECT t FROM TipoAcesso t"),
    @NamedQuery(name = "TipoAcesso.findByCodigoTipoAcesso", query = "SELECT t FROM TipoAcesso t WHERE t.codigoTipoAcesso = :codigoTipoAcesso"),
    @NamedQuery(name = "TipoAcesso.findByTipoAcesso", query = "SELECT t FROM TipoAcesso t WHERE t.tipoAcesso = :tipoAcesso")})
public class TipoAcesso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_tipo_acesso")
    private Integer codigoTipoAcesso;
    @Size(max = 45)
    @Column(name = "tipo_acesso")
    private String tipoAcesso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAcesso")
    private Collection<TipoAcessoFuncionario> tipoAcessoFuncionarioCollection;

    public TipoAcesso() {
    }

    public TipoAcesso(Integer codigoTipoAcesso) {
        this.codigoTipoAcesso = codigoTipoAcesso;
    }

    public Integer getCodigoTipoAcesso() {
        return codigoTipoAcesso;
    }

    public void setCodigoTipoAcesso(Integer codigoTipoAcesso) {
        this.codigoTipoAcesso = codigoTipoAcesso;
    }

    public String getTipoAcesso() {
        return tipoAcesso;
    }

    public void setTipoAcesso(String tipoAcesso) {
        this.tipoAcesso = tipoAcesso;
    }

    @XmlTransient
    public Collection<TipoAcessoFuncionario> getTipoAcessoFuncionarioCollection() {
        return tipoAcessoFuncionarioCollection;
    }

    public void setTipoAcessoFuncionarioCollection(Collection<TipoAcessoFuncionario> tipoAcessoFuncionarioCollection) {
        this.tipoAcessoFuncionarioCollection = tipoAcessoFuncionarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTipoAcesso != null ? codigoTipoAcesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAcesso)) {
            return false;
        }
        TipoAcesso other = (TipoAcesso) object;
        if ((this.codigoTipoAcesso == null && other.codigoTipoAcesso != null) || (this.codigoTipoAcesso != null && !this.codigoTipoAcesso.equals(other.codigoTipoAcesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoAcesso[ codigoTipoAcesso=" + codigoTipoAcesso + " ]";
    }
    
}
