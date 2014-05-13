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
import modelo.TipoAnomalia;

/**
 *
 * @author Vanilson
 */
@Stateless
public class TipoAnomaliaFacade extends AbstractFacade<TipoAnomalia> {
    @PersistenceContext(unitName = "SIGEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoAnomaliaFacade() {
        super(TipoAnomalia.class);
    }
    public TipoAnomalia getTipoAnomaliaPorCodigo(int codigoTipoAnomalia){
        Query q = em.createQuery("SELECT ta FROM TipoAnomalia ta WHERE ta.codigoTipoAnomalia = '"+ codigoTipoAnomalia +"'");
        return (TipoAnomalia)q.getSingleResult();        
    }        
}
