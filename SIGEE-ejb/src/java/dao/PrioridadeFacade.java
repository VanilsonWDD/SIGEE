/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Prioridade;

/**
 *
 * @author Vanilson
 */
@Stateless
public class PrioridadeFacade extends AbstractFacade<Prioridade> {
    @PersistenceContext(unitName = "SIGEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrioridadeFacade() {
        super(Prioridade.class);
    }
    
    public Prioridade getPrioridadePorCodigo(int codigoPrioridade){
        Query q = em.createQuery("SELECT p FROM Prioridade p WHERE p.codigoPrioridade = '"+ codigoPrioridade +"'");
        return (Prioridade)q.getSingleResult();        
    }      
}
