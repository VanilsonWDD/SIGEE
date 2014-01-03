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
import modelo.Funcionario;

/**
 *
 * @author Vanilson
 */
@Stateless
public class FuncionarioFacade extends AbstractFacade<Funcionario> {
    @PersistenceContext(unitName = "SIGEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FuncionarioFacade() {
        super(Funcionario.class);
    }
    public Funcionario getFuncionarioPorCodigo(int codigoFuncionario){
        Query q = em.createQuery("SELECT f FROM Funcionario f WHERE f.codigoFuncionario = '"+ codigoFuncionario +"'");
        return (Funcionario)q.getSingleResult();        
    }  
    public List<Funcionario> login(String username, String senha){
        Query q = em.createQuery("SELECT f FROM Funcionario f WHERE f.usernameFuncionario = '"+ username +"' AND f.senhaFuncionario = '"+ senha +"'");
        return q.getResultList();    
    }
}
