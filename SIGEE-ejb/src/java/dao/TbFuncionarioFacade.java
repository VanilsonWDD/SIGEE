/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Login;
import modelo.TbFuncionario;

/**
 *
 * @author Vanilson
 */
@Stateless
public class TbFuncionarioFacade extends AbstractFacade<TbFuncionario> {
    @PersistenceContext(unitName = "SIGEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbFuncionarioFacade() {
        super(TbFuncionario.class);
    }
    public TbFuncionario getFuncionarioPorCodigo(int codigoFuncionario){
        Query q = em.createQuery("SELECT f FROM TbFuncionario f WHERE f.pkFuncionario = '"+ codigoFuncionario +"'");
        return (TbFuncionario)q.getSingleResult();        
    }  
    public List<Login> login(String username, String senha){
        Query q = em.createQuery("SELECT l FROM Login l WHERE l.usernameLogin = '"+ username +"' AND l.passwordLogin = '"+ senha +"'");
        return q.getResultList();     
    }
    public String getPerfil(String username, String senha){
        Query q = em.createQuery("SELECT l.codigoPerfil.tipoPerfil FROM Login l WHERE l.usernameLogin = '"+ username +"' AND l.passwordLogin = '"+ senha +"'");
        return (String)q.getSingleResult();         
    }
    public List<TbFuncionario> getFuncionarios(){
        Query q = em.createQuery("SELECT f FROM TbFuncionario f");
        return q.getResultList();    
    }   
}
