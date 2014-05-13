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
@Table(name = "tb_sexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSexo.findAll", query = "SELECT t FROM TbSexo t"),
    @NamedQuery(name = "TbSexo.findByPkSexo", query = "SELECT t FROM TbSexo t WHERE t.pkSexo = :pkSexo"),
    @NamedQuery(name = "TbSexo.findByDescricaoSexo", query = "SELECT t FROM TbSexo t WHERE t.descricaoSexo = :descricaoSexo")})
public class TbSexo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_sexo")
    private Integer pkSexo;
    @Size(max = 45)
    @Column(name = "descricaoSexo")
    private String descricaoSexo;
    @OneToMany(mappedBy = "fkSexo")
    private Collection<TbFuncionario> tbFuncionarioCollection;

    public TbSexo() {
    }

    public TbSexo(Integer pkSexo) {
        this.pkSexo = pkSexo;
    }

    public Integer getPkSexo() {
        return pkSexo;
    }

    public void setPkSexo(Integer pkSexo) {
        this.pkSexo = pkSexo;
    }

    public String getDescricaoSexo() {
        return descricaoSexo;
    }

    public void setDescricaoSexo(String descricaoSexo) {
        this.descricaoSexo = descricaoSexo;
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
        hash += (pkSexo != null ? pkSexo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbSexo)) {
            return false;
        }
        TbSexo other = (TbSexo) object;
        if ((this.pkSexo == null && other.pkSexo != null) || (this.pkSexo != null && !this.pkSexo.equals(other.pkSexo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TbSexo[ pkSexo=" + pkSexo + " ]";
    }
    
}
