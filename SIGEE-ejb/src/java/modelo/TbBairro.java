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
@Table(name = "tb_bairro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbBairro.findAll", query = "SELECT t FROM TbBairro t"),
    @NamedQuery(name = "TbBairro.findByPkBairro", query = "SELECT t FROM TbBairro t WHERE t.pkBairro = :pkBairro"),
    @NamedQuery(name = "TbBairro.findByDescricaoBairro", query = "SELECT t FROM TbBairro t WHERE t.descricaoBairro = :descricaoBairro")})
public class TbBairro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_bairro")
    private Integer pkBairro;
    @Size(max = 45)
    @Column(name = "descricaoBairro")
    private String descricaoBairro;
    @OneToMany(mappedBy = "fkBairro")
    private Collection<TbFuncionario> tbFuncionarioCollection;
    @JoinColumn(name = "pk_municipio", referencedColumnName = "pk_Municipio")
    @ManyToOne(optional = false)
    private TbMunicipio pkMunicipio;

    public TbBairro() {
    }

    public TbBairro(Integer pkBairro) {
        this.pkBairro = pkBairro;
    }

    public Integer getPkBairro() {
        return pkBairro;
    }

    public void setPkBairro(Integer pkBairro) {
        this.pkBairro = pkBairro;
    }

    public String getDescricaoBairro() {
        return descricaoBairro;
    }

    public void setDescricaoBairro(String descricaoBairro) {
        this.descricaoBairro = descricaoBairro;
    }

    @XmlTransient
    public Collection<TbFuncionario> getTbFuncionarioCollection() {
        return tbFuncionarioCollection;
    }

    public void setTbFuncionarioCollection(Collection<TbFuncionario> tbFuncionarioCollection) {
        this.tbFuncionarioCollection = tbFuncionarioCollection;
    }

    public TbMunicipio getPkMunicipio() {
        return pkMunicipio;
    }

    public void setPkMunicipio(TbMunicipio pkMunicipio) {
        this.pkMunicipio = pkMunicipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkBairro != null ? pkBairro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbBairro)) {
            return false;
        }
        TbBairro other = (TbBairro) object;
        if ((this.pkBairro == null && other.pkBairro != null) || (this.pkBairro != null && !this.pkBairro.equals(other.pkBairro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TbBairro[ pkBairro=" + pkBairro + " ]";
    }
    
}
