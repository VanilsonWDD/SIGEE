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
@Table(name = "tb_pais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPais.findAll", query = "SELECT t FROM TbPais t"),
    @NamedQuery(name = "TbPais.findByPkPais", query = "SELECT t FROM TbPais t WHERE t.pkPais = :pkPais"),
    @NamedQuery(name = "TbPais.findByDescricaoPais", query = "SELECT t FROM TbPais t WHERE t.descricaoPais = :descricaoPais")})
public class TbPais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_pais")
    private Integer pkPais;
    @Size(max = 45)
    @Column(name = "DescricaoPais")
    private String descricaoPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPais")
    private Collection<TbProvincia> tbProvinciaCollection;

    public TbPais() {
    }

    public TbPais(Integer pkPais) {
        this.pkPais = pkPais;
    }

    public Integer getPkPais() {
        return pkPais;
    }

    public void setPkPais(Integer pkPais) {
        this.pkPais = pkPais;
    }

    public String getDescricaoPais() {
        return descricaoPais;
    }

    public void setDescricaoPais(String descricaoPais) {
        this.descricaoPais = descricaoPais;
    }

    @XmlTransient
    public Collection<TbProvincia> getTbProvinciaCollection() {
        return tbProvinciaCollection;
    }

    public void setTbProvinciaCollection(Collection<TbProvincia> tbProvinciaCollection) {
        this.tbProvinciaCollection = tbProvinciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkPais != null ? pkPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPais)) {
            return false;
        }
        TbPais other = (TbPais) object;
        if ((this.pkPais == null && other.pkPais != null) || (this.pkPais != null && !this.pkPais.equals(other.pkPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TbPais[ pkPais=" + pkPais + " ]";
    }
    
}
