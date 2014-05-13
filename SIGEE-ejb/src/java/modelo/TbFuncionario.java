/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vanilson
 */
@Entity
@Table(name = "tb_funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFuncionario.findAll", query = "SELECT t FROM TbFuncionario t"),
    @NamedQuery(name = "TbFuncionario.findByPkFuncionario", query = "SELECT t FROM TbFuncionario t WHERE t.pkFuncionario = :pkFuncionario"),
    @NamedQuery(name = "TbFuncionario.findByApelido", query = "SELECT t FROM TbFuncionario t WHERE t.apelido = :apelido"),
    @NamedQuery(name = "TbFuncionario.findByNomeCompleto", query = "SELECT t FROM TbFuncionario t WHERE t.nomeCompleto = :nomeCompleto"),
    @NamedQuery(name = "TbFuncionario.findByNomePai", query = "SELECT t FROM TbFuncionario t WHERE t.nomePai = :nomePai"),
    @NamedQuery(name = "TbFuncionario.findByNomeMae", query = "SELECT t FROM TbFuncionario t WHERE t.nomeMae = :nomeMae"),
    @NamedQuery(name = "TbFuncionario.findByDataNascimento", query = "SELECT t FROM TbFuncionario t WHERE t.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "TbFuncionario.findByTelefone", query = "SELECT t FROM TbFuncionario t WHERE t.telefone = :telefone"),
    @NamedQuery(name = "TbFuncionario.findByTelemovel", query = "SELECT t FROM TbFuncionario t WHERE t.telemovel = :telemovel"),
    @NamedQuery(name = "TbFuncionario.findByEmail", query = "SELECT t FROM TbFuncionario t WHERE t.email = :email"),
    @NamedQuery(name = "TbFuncionario.findByEmailAlternativo", query = "SELECT t FROM TbFuncionario t WHERE t.emailAlternativo = :emailAlternativo"),
    @NamedQuery(name = "TbFuncionario.findBySalarioBase", query = "SELECT t FROM TbFuncionario t WHERE t.salarioBase = :salarioBase"),
    @NamedQuery(name = "TbFuncionario.findByImgFuncionario", query = "SELECT t FROM TbFuncionario t WHERE t.imgFuncionario = :imgFuncionario")})
public class TbFuncionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_funcionario")
    private Integer pkFuncionario;
    @Size(max = 45)
    @Column(name = "apelido")
    private String apelido;
    @Size(max = 45)
    @Column(name = "nome_completo")
    private String nomeCompleto;
    @Size(max = 45)
    @Column(name = "nome_pai")
    private String nomePai;
    @Size(max = 45)
    @Column(name = "nome_mae")
    private String nomeMae;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Size(max = 45)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 45)
    @Column(name = "telemovel")
    private String telemovel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "email_alternativo")
    private String emailAlternativo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salario_base")
    private Float salarioBase;
    @Size(max = 45)
    @Column(name = "img_funcionario")
    private String imgFuncionario;
    @JoinColumn(name = "fk_cargos", referencedColumnName = "pk_cargos")
    @ManyToOne
    private TbCargos fkCargos;
    @JoinColumn(name = "fk_bairro", referencedColumnName = "pk_bairro")
    @ManyToOne
    private TbBairro fkBairro;
    @JoinColumn(name = "fk_tipo_contrato", referencedColumnName = "pk_tipo_contrato")
    @ManyToOne
    private TbTipoContrato fkTipoContrato;
    @JoinColumn(name = "fk_sexo", referencedColumnName = "pk_sexo")
    @ManyToOne
    private TbSexo fkSexo;
    @JoinColumn(name = "fk_estado_civil", referencedColumnName = "pk_estado_civil")
    @ManyToOne
    private TbEstadoCivil fkEstadoCivil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pkFuncionario")
    private Collection<EquipaFuncionario> equipaFuncionarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pkFuncionario")
    private Collection<Ticket> ticketCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pkFuncionario")
    private Collection<Login> loginCollection;
    @OneToMany(mappedBy = "fkFuncionario")
    private Collection<TbAjustaSalario> tbAjustaSalarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbFuncionario")
    private Collection<TipoAcessoFuncionario> tipoAcessoFuncionarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pkFuncionario")
    private Collection<EquipaResponsavel> equipaResponsavelCollection;

    public TbFuncionario() {
    }

    public TbFuncionario(Integer pkFuncionario) {
        this.pkFuncionario = pkFuncionario;
    }

    public Integer getPkFuncionario() {
        return pkFuncionario;
    }

    public void setPkFuncionario(Integer pkFuncionario) {
        this.pkFuncionario = pkFuncionario;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAlternativo() {
        return emailAlternativo;
    }

    public void setEmailAlternativo(String emailAlternativo) {
        this.emailAlternativo = emailAlternativo;
    }

    public Float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getImgFuncionario() {
        return imgFuncionario;
    }

    public void setImgFuncionario(String imgFuncionario) {
        this.imgFuncionario = imgFuncionario;
    }

    public TbCargos getFkCargos() {
        return fkCargos;
    }

    public void setFkCargos(TbCargos fkCargos) {
        this.fkCargos = fkCargos;
    }

    public TbBairro getFkBairro() {
        return fkBairro;
    }

    public void setFkBairro(TbBairro fkBairro) {
        this.fkBairro = fkBairro;
    }

    public TbTipoContrato getFkTipoContrato() {
        return fkTipoContrato;
    }

    public void setFkTipoContrato(TbTipoContrato fkTipoContrato) {
        this.fkTipoContrato = fkTipoContrato;
    }

    public TbSexo getFkSexo() {
        return fkSexo;
    }

    public void setFkSexo(TbSexo fkSexo) {
        this.fkSexo = fkSexo;
    }

    public TbEstadoCivil getFkEstadoCivil() {
        return fkEstadoCivil;
    }

    public void setFkEstadoCivil(TbEstadoCivil fkEstadoCivil) {
        this.fkEstadoCivil = fkEstadoCivil;
    }

    @XmlTransient
    public Collection<EquipaFuncionario> getEquipaFuncionarioCollection() {
        return equipaFuncionarioCollection;
    }

    public void setEquipaFuncionarioCollection(Collection<EquipaFuncionario> equipaFuncionarioCollection) {
        this.equipaFuncionarioCollection = equipaFuncionarioCollection;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    @XmlTransient
    public Collection<Login> getLoginCollection() {
        return loginCollection;
    }

    public void setLoginCollection(Collection<Login> loginCollection) {
        this.loginCollection = loginCollection;
    }

    @XmlTransient
    public Collection<TbAjustaSalario> getTbAjustaSalarioCollection() {
        return tbAjustaSalarioCollection;
    }

    public void setTbAjustaSalarioCollection(Collection<TbAjustaSalario> tbAjustaSalarioCollection) {
        this.tbAjustaSalarioCollection = tbAjustaSalarioCollection;
    }

    @XmlTransient
    public Collection<TipoAcessoFuncionario> getTipoAcessoFuncionarioCollection() {
        return tipoAcessoFuncionarioCollection;
    }

    public void setTipoAcessoFuncionarioCollection(Collection<TipoAcessoFuncionario> tipoAcessoFuncionarioCollection) {
        this.tipoAcessoFuncionarioCollection = tipoAcessoFuncionarioCollection;
    }

    @XmlTransient
    public Collection<EquipaResponsavel> getEquipaResponsavelCollection() {
        return equipaResponsavelCollection;
    }

    public void setEquipaResponsavelCollection(Collection<EquipaResponsavel> equipaResponsavelCollection) {
        this.equipaResponsavelCollection = equipaResponsavelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkFuncionario != null ? pkFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFuncionario)) {
            return false;
        }
        TbFuncionario other = (TbFuncionario) object;
        if ((this.pkFuncionario == null && other.pkFuncionario != null) || (this.pkFuncionario != null && !this.pkFuncionario.equals(other.pkFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TbFuncionario[ pkFuncionario=" + pkFuncionario + " ]";
    }
    
}
