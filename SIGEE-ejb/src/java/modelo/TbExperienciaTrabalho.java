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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vanilson
 */
@Entity
@Table(name = "tb_experiencia_trabalho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbExperienciaTrabalho.findAll", query = "SELECT t FROM TbExperienciaTrabalho t"),
    @NamedQuery(name = "TbExperienciaTrabalho.findByPkExperienciaTrabalho", query = "SELECT t FROM TbExperienciaTrabalho t WHERE t.pkExperienciaTrabalho = :pkExperienciaTrabalho"),
    @NamedQuery(name = "TbExperienciaTrabalho.findByEmpresa", query = "SELECT t FROM TbExperienciaTrabalho t WHERE t.empresa = :empresa"),
    @NamedQuery(name = "TbExperienciaTrabalho.findByCargo", query = "SELECT t FROM TbExperienciaTrabalho t WHERE t.cargo = :cargo"),
    @NamedQuery(name = "TbExperienciaTrabalho.findByDataEntrada", query = "SELECT t FROM TbExperienciaTrabalho t WHERE t.dataEntrada = :dataEntrada"),
    @NamedQuery(name = "TbExperienciaTrabalho.findByDataSaida", query = "SELECT t FROM TbExperienciaTrabalho t WHERE t.dataSaida = :dataSaida"),
    @NamedQuery(name = "TbExperienciaTrabalho.findByDescricaoFuncionario", query = "SELECT t FROM TbExperienciaTrabalho t WHERE t.descricaoFuncionario = :descricaoFuncionario")})
public class TbExperienciaTrabalho implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_experiencia_trabalho")
    private Integer pkExperienciaTrabalho;
    @Size(max = 45)
    @Column(name = "empresa")
    private String empresa;
    @Size(max = 45)
    @Column(name = "cargo")
    private String cargo;
    @Size(max = 45)
    @Column(name = "data_entrada")
    private String dataEntrada;
    @Size(max = 45)
    @Column(name = "data_saida")
    private String dataSaida;
    @Size(max = 45)
    @Column(name = "descricao_funcionario")
    private String descricaoFuncionario;

    public TbExperienciaTrabalho() {
    }

    public TbExperienciaTrabalho(Integer pkExperienciaTrabalho) {
        this.pkExperienciaTrabalho = pkExperienciaTrabalho;
    }

    public Integer getPkExperienciaTrabalho() {
        return pkExperienciaTrabalho;
    }

    public void setPkExperienciaTrabalho(Integer pkExperienciaTrabalho) {
        this.pkExperienciaTrabalho = pkExperienciaTrabalho;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDescricaoFuncionario() {
        return descricaoFuncionario;
    }

    public void setDescricaoFuncionario(String descricaoFuncionario) {
        this.descricaoFuncionario = descricaoFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkExperienciaTrabalho != null ? pkExperienciaTrabalho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbExperienciaTrabalho)) {
            return false;
        }
        TbExperienciaTrabalho other = (TbExperienciaTrabalho) object;
        if ((this.pkExperienciaTrabalho == null && other.pkExperienciaTrabalho != null) || (this.pkExperienciaTrabalho != null && !this.pkExperienciaTrabalho.equals(other.pkExperienciaTrabalho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TbExperienciaTrabalho[ pkExperienciaTrabalho=" + pkExperienciaTrabalho + " ]";
    }
    
}
