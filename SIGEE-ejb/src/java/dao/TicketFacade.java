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
import modelo.Ticket;

/**
 *
 * @author Vanilson
 */
@Stateless
public class TicketFacade extends AbstractFacade<Ticket> {
    @PersistenceContext(unitName = "SIGEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TicketFacade() {
        super(Ticket.class);
    }
    public Ticket getTicketPorCodigo(int codigoTicket){
        Query q = em.createQuery("SELECT t FROM Ticket t WHERE t.codigoTicket = '"+ codigoTicket +"'");
        return (Ticket)q.getSingleResult();        
    }      
}
