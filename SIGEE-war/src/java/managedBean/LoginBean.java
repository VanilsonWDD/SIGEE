/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBean;

import dao.FuncionarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Funcionario;

/**
 *
 * @author Vanilson
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    @EJB
    private FuncionarioFacade funcionarioFacade;

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
            Funcionario f = new Funcionario();
            List<Funcionario> lf = funcionarioFacade.login(username, senha);
            if(!lf.isEmpty()){
                HttpSession sessao = (HttpSession) fc.getExternalContext().getSession(true);
                f.setNomeFuncionario(lf.get(0).getNomeFuncionario());
                sessao.setAttribute("sessao", f);
                fc.getExternalContext().redirect("paginas/modulos.xhtml");
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
