/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vanilson
 */
@Entity
@Table(name = "tb_ajusta_salario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAjustaSalario.findAll", query = "SELECT t FROM TbAjustaSalario t"),
    @NamedQuery(name = "TbAjustaSalario.findByPkAjustaSalario", query = "SELECT t FROM TbAjustaSalario t WHERE t.pkAjustaSalario = :pkAjustaSalario"),
    @NamedQuery(name = "TbAjustaSalario.findByNumeroFalta", query = "SELECT t FROM TbAjustaSalario t WHERE t.numeroFalta = :numeroFalta")})
public class TbAjustaSalario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_ajusta_salario")
    private Integer pkAjustaSalario;
    @Column(name = "numeroFalta")
    private Integer numeroFalta;
    @JoinColumn(name = "fk_funcionario", referencedColumnName = "pk_funcionario")
    @ManyToOne
    private TbFuncionario fkFuncionario;

    public TbAjustaSalario() {
    }

    public TbAjustaSalario(Integer pkAjustaSalario) {
        this.pkAjustaSalario = pkAjustaSalario;
    }

    public Integer getPkAjustaSalario() {
        return pkAjustaSalario;
    }

    public void setPkAjustaSalario(Integer pkAjustaSalario) {
        this.pkAjustaSalario = pkAjustaSalario;
    }

    public Integer getNumeroFalta() {
        return numeroFalta;
    }

    public void setNumeroFalta(Integer numeroFalta) {
        this.numeroFalta = numeroFalta;
    }

    public TbFuncionario getFkFuncionario() {
        return fkFuncionario;
    }

    public void setFkFuncionario(TbFuncionario fkFuncionario) {
        this.fkFuncionario = fkFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkAjustaSalario != null ? pkAjustaSalario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAjustaSalario)) {
            return false;
        }
        TbAjustaSalario other = (TbAjustaSalario) object;
        if ((this.pkAjustaSalario == null && other.pkAjustaSalario != null) || (this.pkAjustaSalario != null && !this.pkAjustaSalario.equals(other.pkAjustaSalario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TbAjustaSalario[ pkAjustaSalario=" + pkAjustaSalario + " ]";
    }
    
}
