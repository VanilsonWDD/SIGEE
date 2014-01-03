/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.FechoTicket;

/**
 *
 * @author Vanilson
 */
@Stateless
public class FechoTicketFacade extends AbstractFacade<FechoTicket> {
    @PersistenceContext(unitName = "SIGEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FechoTicketFacade() {
        super(FechoTicket.class);
    }
    
}
