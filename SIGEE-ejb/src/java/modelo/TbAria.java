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
@Table(name = "tb_aria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAria.findAll", query = "SELECT t FROM TbAria t"),
    @NamedQuery(name = "TbAria.findByPkAria", query = "SELECT t FROM TbAria t WHERE t.pkAria = :pkAria"),
    @NamedQuery(name = "TbAria.findByNomeArea", query = "SELECT t FROM TbAria t WHERE t.nomeArea = :nomeArea")})
public class TbAria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_aria")
    private Integer pkAria;
    @Size(max = 45)
    @Column(name = "nomeArea")
    private String nomeArea;
    @OneToMany(mappedBy = "fkAria")
    private Collection<TbCargos> tbCargosCollection;

    public TbAria() {
    }

    public TbAria(Integer pkAria) {
        this.pkAria = pkAria;
    }

    public Integer getPkAria() {
        return pkAria;
    }

    public void setPkAria(Integer pkAria) {
        this.pkAria = pkAria;
    }

    public String getNomeArea() {
        return nomeArea;
    }

    public void setNomeArea(String nomeArea) {
        this.nomeArea = nomeArea;
    }

    @XmlTransient
    public Collection<TbCargos> getTbCargosCollection() {
        return tbCargosCollection;
    }

    public void setTbCargosCollection(Collection<TbCargos> tbCargosCollection) {
        this.tbCargosCollection = tbCargosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkAria != null ? pkAria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAria)) {
            return false;
        }
        TbAria other = (TbAria) object;
        if ((this.pkAria == null && other.pkAria != null) || (this.pkAria != null && !this.pkAria.equals(other.pkAria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TbAria[ pkAria=" + pkAria + " ]";
    }
    
}
