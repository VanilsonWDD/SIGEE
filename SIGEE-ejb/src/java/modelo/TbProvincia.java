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
@Table(name = "tb_provincia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProvincia.findAll", query = "SELECT t FROM TbProvincia t"),
    @NamedQuery(name = "TbProvincia.findByPkProvincia", query = "SELECT t FROM TbProvincia t WHERE t.pkProvincia = :pkProvincia"),
    @NamedQuery(name = "TbProvincia.findByDescricaoProvincia", query = "SELECT t FROM TbProvincia t WHERE t.descricaoProvincia = :descricaoProvincia")})
public class TbProvincia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_provincia")
    private Integer pkProvincia;
    @Size(max = 45)
    @Column(name = "descricaoProvincia")
    private String descricaoProvincia;
    @JoinColumn(name = "fk_pais", referencedColumnName = "pk_pais")
    @ManyToOne(optional = false)
    private TbPais fkPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProvincia")
    private Collection<TbMunicipio> tbMunicipioCollection;

    public TbProvincia() {
    }

    public TbProvincia(Integer pkProvincia) {
        this.pkProvincia = pkProvincia;
    }

    public Integer getPkProvincia() {
        return pkProvincia;
    }

    public void setPkProvincia(Integer pkProvincia) {
        this.pkProvincia = pkProvincia;
    }

    public String getDescricaoProvincia() {
        return descricaoProvincia;
    }

    public void setDescricaoProvincia(String descricaoProvincia) {
        this.descricaoProvincia = descricaoProvincia;
    }

    public TbPais getFkPais() {
        return fkPais;
    }

    public void setFkPais(TbPais fkPais) {
        this.fkPais = fkPais;
    }

    @XmlTransient
    public Collection<TbMunicipio> getTbMunicipioCollection() {
        return tbMunicipioCollection;
    }

    public void setTbMunicipioCollection(Collection<TbMunicipio> tbMunicipioCollection) {
        this.tbMunicipioCollection = tbMunicipioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkProvincia != null ? pkProvincia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProvincia)) {
            return false;
        }
        TbProvincia other = (TbProvincia) object;
        if ((this.pkProvincia == null && other.pkProvincia != null) || (this.pkProvincia != null && !this.pkProvincia.equals(other.pkProvincia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TbProvincia[ pkProvincia=" + pkProvincia + " ]";
    }
    
}
