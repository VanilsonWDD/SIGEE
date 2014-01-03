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
@Table(name = "estado_intervencao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoIntervencao.findAll", query = "SELECT e FROM EstadoIntervencao e"),
    @NamedQuery(name = "EstadoIntervencao.findByCodigoEstadoIntervencao", query = "SELECT e FROM EstadoIntervencao e WHERE e.codigoEstadoIntervencao = :codigoEstadoIntervencao"),
    @NamedQuery(name = "EstadoIntervencao.findByTipoEstadoIntervencao", query = "SELECT e FROM EstadoIntervencao e WHERE e.tipoEstadoIntervencao = :tipoEstadoIntervencao")})
public class EstadoIntervencao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_estado_intervencao")
    private Integer codigoEstadoIntervencao;
    @Size(max = 45)
    @Column(name = "tipo_estado_intervencao")
    private String tipoEstadoIntervencao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoEstadoIntervencao")
    private Collection<Intervencao> intervencaoCollection;

    public EstadoIntervencao() {
    }

    public EstadoIntervencao(Integer codigoEstadoIntervencao) {
        this.codigoEstadoIntervencao = codigoEstadoIntervencao;
    }

    public Integer getCodigoEstadoIntervencao() {
        return codigoEstadoIntervencao;
    }

    public void setCodigoEstadoIntervencao(Integer codigoEstadoIntervencao) {
        this.codigoEstadoIntervencao = codigoEstadoIntervencao;
    }

    public String getTipoEstadoIntervencao() {
        return tipoEstadoIntervencao;
    }

    public void setTipoEstadoIntervencao(String tipoEstadoIntervencao) {
        this.tipoEstadoIntervencao = tipoEstadoIntervencao;
    }

    @XmlTransient
    public Collection<Intervencao> getIntervencaoCollection() {
        return intervencaoCollection;
    }

    public void setIntervencaoCollection(Collection<Intervencao> intervencaoCollection) {
        this.intervencaoCollection = intervencaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEstadoIntervencao != null ? codigoEstadoIntervencao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoIntervencao)) {
            return false;
        }
        EstadoIntervencao other = (EstadoIntervencao) object;
        if ((this.codigoEstadoIntervencao == null && other.codigoEstadoIntervencao != null) || (this.codigoEstadoIntervencao != null && !this.codigoEstadoIntervencao.equals(other.codigoEstadoIntervencao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EstadoIntervencao[ codigoEstadoIntervencao=" + codigoEstadoIntervencao + " ]";
    }
    
}
