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
import modelo.Site;

/**
 *
 * @author Vanilson
 */
@Stateless
public class SiteFacade extends AbstractFacade<Site> {
    @PersistenceContext(unitName = "SIGEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SiteFacade() {
        super(Site.class);
    }

    public Site getSitePorCodigo(int codigoSite){
        Query q = em.createQuery("SELECT s FROM Site s WHERE s.codigoSite = '"+ codigoSite +"'");
        return (Site)q.getSingleResult();        
    }  
}
