/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "tb_tipo_contrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTipoContrato.findAll", query = "SELECT t FROM TbTipoContrato t"),
    @NamedQuery(name = "TbTipoContrato.findByPkTipoContrato", query = "SELECT t FROM TbTipoContrato t WHERE t.pkTipoContrato = :pkTipoContrato"),
    @NamedQuery(name = "TbTipoContrato.findByTbtipoContratocol", query = "SELECT t FROM TbTipoContrato t WHERE t.tbtipoContratocol = :tbtipoContratocol")})
public class TbTipoContrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_tipo_contrato")
    private Integer pkTipoContrato;
    @Size(max = 45)
    @Column(name = "Tb_tipoContratocol")
    private String tbtipoContratocol;
    @OneToMany(mappedBy = "fkTipoContrato")
    private Collection<TbFuncionario> tbFuncionarioCollection;

    public TbTipoContrato() {
    }

    public TbTipoContrato(Integer pkTipoContrato) {
        this.pkTipoContrato = pkTipoContrato;
    }

    public Integer getPkTipoContrato() {
        return pkTipoContrato;
    }

    public void setPkTipoContrato(Integer pkTipoContrato) {
        this.pkTipoContrato = pkTipoContrato;
    }

    public String getTbtipoContratocol() {
        return tbtipoContratocol;
    }

    public void setTbtipoContratocol(String tbtipoContratocol) {
        this.tbtipoContratocol = tbtipoContratocol;
    }

    @XmlTransient
    public Collection<TbFuncionario> getTbFuncionarioCollection() {
        return tbFuncionarioCollection;
    }

    public void setTbFuncionarioCollection(Collection<TbFuncionario> tbFuncionarioCollection) {
        this.tbFuncionarioCollection = tbFuncionarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkTipoContrato != null ? pkTipoContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTipoContrato)) {
            return false;
        }
        TbTipoContrato other = (TbTipoContrato) object;
        if ((this.pkTipoContrato == null && other.pkTipoContrato != null) || (this.pkTipoContrato != null && !this.pkTipoContrato.equals(other.pkTipoContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TbTipoContrato[ pkTipoContrato=" + pkTipoContrato + " ]";
    }
    
}
