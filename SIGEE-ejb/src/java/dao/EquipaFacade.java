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
import modelo.Equipa;

/**
 *
 * @author Vanilson
 */
@Stateless
public class EquipaFacade extends AbstractFacade<Equipa> {
    @PersistenceContext(unitName = "SIGEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipaFacade() {
        super(Equipa.class);
    }
    
    public Equipa getEquipaPorCodigo(int codigoEquipa){
        Query q = em.createQuery("SELECT e FROM Equipa e WHERE e.codigoEquipa = '"+ codigoEquipa +"'");
        return (Equipa)q.getSingleResult();        
    }    
}
