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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_cargos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCargos.findAll", query = "SELECT t FROM TbCargos t"),
    @NamedQuery(name = "TbCargos.findByPkCargos", query = "SELECT t FROM TbCargos t WHERE t.pkCargos = :pkCargos"),
    @NamedQuery(name = "TbCargos.findByDescricaoCargos", query = "SELECT t FROM TbCargos t WHERE t.descricaoCargos = :descricaoCargos")})
public class TbCargos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_cargos")
    private Integer pkCargos;
    @Size(max = 45)
    @Column(name = "descricaoCargos")
    private String descricaoCargos;
    @OneToMany(mappedBy = "fkCargos")
    private Collection<TbFuncionario> tbFuncionarioCollection;
    @JoinColumn(name = "fk_aria", referencedColumnName = "pk_aria")
    @ManyToOne
    private TbAria fkAria;

    public TbCargos() {
    }

    public TbCargos(Integer pkCargos) {
        this.pkCargos = pkCargos;
    }

    public Integer getPkCargos() {
        return pkCargos;
    }

    public void setPkCargos(Integer pkCargos) {
        this.pkCargos = pkCargos;
    }

    public String getDescricaoCargos() {
        return descricaoCargos;
    }

    public void setDescricaoCargos(String descricaoCargos) {
        this.descricaoCargos = descricaoCargos;
    }

    @XmlTransient
    public Collection<TbFuncionario> getTbFuncionarioCollection() {
        return tbFuncionarioCollection;
    }

    public void setTbFuncionarioCollection(Collection<TbFuncionario> tbFuncionarioCollection) {
        this.tbFuncionarioCollection = tbFuncionarioCollection;
    }

    public TbAria getFkAria() {
        return fkAria;
    }

    public void setFkAria(TbAria fkAria) {
        this.fkAria = fkAria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCargos != null ? pkCargos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCargos)) {
            return false;
        }
        TbCargos other = (TbCargos) object;
        if ((this.pkCargos == null && other.pkCargos != null) || (this.pkCargos != null && !this.pkCargos.equals(other.pkCargos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TbCargos[ pkCargos=" + pkCargos + " ]";
    }
    
}
