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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
    @NamedQuery(name = "Login.findByCodigoLogin", query = "SELECT l FROM Login l WHERE l.codigoLogin = :codigoLogin"),
    @NamedQuery(name = "Login.findByUsernameLogin", query = "SELECT l FROM Login l WHERE l.usernameLogin = :usernameLogin")})
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_login")
    private Integer codigoLogin;
    @Size(max = 45)
    @Column(name = "username_login")
    private String usernameLogin;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "password_login")
    private String passwordLogin;
    @JoinColumn(name = "codigo_perfil", referencedColumnName = "codigo_perfil")
    @ManyToOne(optional = false)
    private Perfil codigoPerfil;
    @JoinColumn(name = "pk_funcionario", referencedColumnName = "pk_funcionario")
    @ManyToOne(optional = false)
    private TbFuncionario pkFuncionario;

    public Login() {
    }

    public Login(Integer codigoLogin) {
        this.codigoLogin = codigoLogin;
    }

    public Integer getCodigoLogin() {
        return codigoLogin;
    }

    public void setCodigoLogin(Integer codigoLogin) {
        this.codigoLogin = codigoLogin;
    }

    public String getUsernameLogin() {
        return usernameLogin;
    }

    public void setUsernameLogin(String usernameLogin) {
        this.usernameLogin = usernameLogin;
    }

    public String getPasswordLogin() {
        return passwordLogin;
    }

    public void setPasswordLogin(String passwordLogin) {
        this.passwordLogin = passwordLogin;
    }

    public Perfil getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(Perfil codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

    public TbFuncionario getPkFuncionario() {
        return pkFuncionario;
    }

    public void setPkFuncionario(TbFuncionario pkFuncionario) {
        this.pkFuncionario = pkFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoLogin != null ? codigoLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.codigoLogin == null && other.codigoLogin != null) || (this.codigoLogin != null && !this.codigoLogin.equals(other.codigoLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Login[ codigoLogin=" + codigoLogin + " ]";
    }
    
}
