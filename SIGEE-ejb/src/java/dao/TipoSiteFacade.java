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
import modelo.TipoSite;

/**
 *
 * @author Vanilson
 */
@Stateless
public class TipoSiteFacade extends AbstractFacade<TipoSite> {
    @PersistenceContext(unitName = "SIGEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoSiteFacade() {
        super(TipoSite.class);
    }
    public TipoSite getTipoSitePorCodigo(int codigoTipoSite){
        Query q = em.createQuery("SELECT ts FROM TipoSite ts WHERE ts.codigoTipoSite = '"+ codigoTipoSite +"'");
        return (TipoSite)q.getSingleResult();        
    }     
}
