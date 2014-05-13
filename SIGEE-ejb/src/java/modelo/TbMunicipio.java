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
@Table(name = "tb_municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMunicipio.findAll", query = "SELECT t FROM TbMunicipio t"),
    @NamedQuery(name = "TbMunicipio.findByPkMunicipio", query = "SELECT t FROM TbMunicipio t WHERE t.pkMunicipio = :pkMunicipio"),
    @NamedQuery(name = "TbMunicipio.findByDescricaoMunicipio", query = "SELECT t FROM TbMunicipio t WHERE t.descricaoMunicipio = :descricaoMunicipio")})
public class TbMunicipio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_Municipio")
    private Integer pkMunicipio;
    @Size(max = 45)
    @Column(name = "descricaoMunicipio")
    private String descricaoMunicipio;
    @JoinColumn(name = "fk_provincia", referencedColumnName = "pk_provincia")
    @ManyToOne(optional = false)
    private TbProvincia fkProvincia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pkMunicipio")
    private Collection<TbBairro> tbBairroCollection;

    public TbMunicipio() {
    }

    public TbMunicipio(Integer pkMunicipio) {
        this.pkMunicipio = pkMunicipio;
    }

    public Integer getPkMunicipio() {
        return pkMunicipio;
    }

    public void setPkMunicipio(Integer pkMunicipio) {
        this.pkMunicipio = pkMunicipio;
    }

    public String getDescricaoMunicipio() {
        return descricaoMunicipio;
    }

    public void setDescricaoMunicipio(String descricaoMunicipio) {
        this.descricaoMunicipio = descricaoMunicipio;
    }

    public TbProvincia getFkProvincia() {
        return fkProvincia;
    }

    public void setFkProvincia(TbProvincia fkProvincia) {
        this.fkProvincia = fkProvincia;
    }

    @XmlTransient
    public Collection<TbBairro> getTbBairroCollection() {
        return tbBairroCollection;
    }

    public void setTbBairroCollection(Collection<TbBairro> tbBairroCollection) {
        this.tbBairroCollection = tbBairroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkMunicipio != null ? pkMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbMunicipio)) {
            return false;
        }
        TbMunicipio other = (TbMunicipio) object;
        if ((this.pkMunicipio == null && other.pkMunicipio != null) || (this.pkMunicipio != null && !this.pkMunicipio.equals(other.pkMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TbMunicipio[ pkMunicipio=" + pkMunicipio + " ]";
    }
    
}
