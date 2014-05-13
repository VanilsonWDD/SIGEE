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
@Table(name = "tb_estado_civil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEstadoCivil.findAll", query = "SELECT t FROM TbEstadoCivil t"),
    @NamedQuery(name = "TbEstadoCivil.findByPkEstadoCivil", query = "SELECT t FROM TbEstadoCivil t WHERE t.pkEstadoCivil = :pkEstadoCivil"),
    @NamedQuery(name = "TbEstadoCivil.findByDescricaoEstadoCivil", query = "SELECT t FROM TbEstadoCivil t WHERE t.descricaoEstadoCivil = :descricaoEstadoCivil")})
public class TbEstadoCivil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_estado_civil")
    private Integer pkEstadoCivil;
    @Size(max = 45)
    @Column(name = "descricaoEstadoCivil")
    private String descricaoEstadoCivil;
    @OneToMany(mappedBy = "fkEstadoCivil")
    private Collection<TbFuncionario> tbFuncionarioCollection;

    public TbEstadoCivil() {
    }

    public TbEstadoCivil(Integer pkEstadoCivil) {
        this.pkEstadoCivil = pkEstadoCivil;
    }

    public Integer getPkEstadoCivil() {
        return pkEstadoCivil;
    }

    public void setPkEstadoCivil(Integer pkEstadoCivil) {
        this.pkEstadoCivil = pkEstadoCivil;
    }

    public String getDescricaoEstadoCivil() {
        return descricaoEstadoCivil;
    }

    public void setDescricaoEstadoCivil(String descricaoEstadoCivil) {
        this.descricaoEstadoCivil = descricaoEstadoCivil;
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
        hash += (pkEstadoCivil != null ? pkEstadoCivil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEstadoCivil)) {
            return false;
        }
        TbEstadoCivil other = (TbEstadoCivil) object;
        if ((this.pkEstadoCivil == null && other.pkEstadoCivil != null) || (this.pkEstadoCivil != null && !this.pkEstadoCivil.equals(other.pkEstadoCivil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TbEstadoCivil[ pkEstadoCivil=" + pkEstadoCivil + " ]";
    }
    
}
