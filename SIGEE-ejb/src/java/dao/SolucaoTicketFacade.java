/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.SolucaoTicket;

/**
 *
 * @author Vanilson
 */
@Stateless
public class SolucaoTicketFacade extends AbstractFacade<SolucaoTicket> {
    @PersistenceContext(unitName = "SIGEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolucaoTicketFacade() {
        super(SolucaoTicket.class);
    }
    
}
