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
import modelo.Funcionario;
import modelo.Impacto;

/**
 *
 * @author Vanilson
 */
@Stateless
public class ImpactoFacade extends AbstractFacade<Impacto> {
    @PersistenceContext(unitName = "SIGEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImpactoFacade() {
        super(Impacto.class);
    }
    public Impacto getImpactoPorCodigo(int codigoImpacto){
        Query q = em.createQuery("SELECT i FROM Impacto i WHERE i.codigoImpacto = '"+ codigoImpacto +"'");
        return (Impacto)q.getSingleResult();        
    }        
}
