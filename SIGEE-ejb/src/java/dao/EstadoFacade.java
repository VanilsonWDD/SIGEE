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
import modelo.Estado;

/**
 *
 * @author Vanilson
 */
@Stateless
public class EstadoFacade extends AbstractFacade<Estado> {
    @PersistenceContext(unitName = "SIGEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoFacade() {
        super(Estado.class);
    }
    public Estado getEstadoPorCodigo(int codigoEstado){
        Query q = em.createQuery("SELECT e FROM Estado e WHERE e.codigoEstado = '"+ codigoEstado +"'");
        return (Estado)q.getSingleResult();        
    }     
}
