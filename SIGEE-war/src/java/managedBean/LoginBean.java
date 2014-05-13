/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBean;

import dao.TbFuncionarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Login;
import modelo.Perfil;
import modelo.TbFuncionario;
import util.Criptografia;

/**
 *
 * @author Vanilson
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    @EJB
    private TbFuncionarioFacade funcionarioFacade;

    /**
     * Creates a new instance of LoginBean
     */
    private String username;
    private String senha;
    
    public LoginBean() {
    }
    
    public void login(){
        try{
            FacesContext fc = FacesContext.getCurrentInstance();
            TbFuncionario f = new TbFuncionario();
            Login l = new Login();
            Perfil p = new Perfil();
            
            List<Login> lf = funcionarioFacade.login(username, Criptografia.encriptar(senha));
            if(!lf.isEmpty()){
                String perfil = funcionarioFacade.getPerfil(username, Criptografia.encriptar(senha));
                if(perfil.equals("Administrador(a)")){
                    
                    HttpSession sessaoAdministrador = (HttpSession) fc.getExternalContext().getSession(true);
                    f.setNomeCompleto(lf.get(0).getPkFuncionario().getNomeCompleto());
                    l.setPkFuncionario(f);
                    p.setTipoPerfil("Administrador(a)");
                    l.setCodigoPerfil(p);
                    sessaoAdministrador.setAttribute("sessao", l);
                    fc.getExternalContext().redirect("paginas/modulos.xhtml");
                }
                else if(perfil.equals("Funcionário(a)")){
                    HttpSession sessaoAdministrador = (HttpSession) fc.getExternalContext().getSession(true);
                    f.setNomeCompleto(lf.get(0).getPkFuncionario().getNomeCompleto());
                    l.setPkFuncionario(f);
                    p.setTipoPerfil("Funcionário(a)");
                    l.setCodigoPerfil(p);
                    sessaoAdministrador.setAttribute("sessao", l);
                    fc.getExternalContext().redirect("paginas/modulos.xhtml");                   
                }
            }
            else
                fc.addMessage(null, new FacesMessage("Login", "Login errado, verifique o username e senha"));
        }
        catch(Exception e){
            System.out.println("Erro no bean do login no metodo login: " + e.getMessage());
        }
    }
    
    public void logout(){
        try{
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession sessao = (HttpSession) fc.getExternalContext().getSession(true);
            sessao.removeAttribute("sessao");
            fc.getExternalContext().redirect("modulos.xhtml");
        }
        catch(Exception e){
            System.out.println("Erro no bean do login no metodo logout: " + e.getMessage());
        }
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
