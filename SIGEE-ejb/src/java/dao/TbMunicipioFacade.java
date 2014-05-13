/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.TbMunicipio;

/**
 *
 * @author Vanilson
 */
@Stateless
public class TbMunicipioFacade extends AbstractFacade<TbMunicipio> {
    @PersistenceContext(unitName = "SIGEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbMunicipioFacade() {
        super(TbMunicipio.class);
    }
    
}
