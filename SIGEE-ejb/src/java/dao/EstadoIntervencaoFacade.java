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
import modelo.EstadoIntervencao;

/**
 *
 * @author Vanilson
 */
@Stateless
public class EstadoIntervencaoFacade extends AbstractFacade<EstadoIntervencao> {
    @PersistenceContext(unitName = "SIGEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoIntervencaoFacade() {
        super(EstadoIntervencao.class);
    }
    
    public EstadoIntervencao getEstadoIntervencaoPorCodigo(int codigoEstadoIntervencao){
        Query q = em.createQuery("SELECT ei FROM EstadoIntervencao ei WHERE ei.codigoEstadoIntervencao = '"+ codigoEstadoIntervencao +"'");
        return (EstadoIntervencao)q.getSingleResult();        
    }      
}
