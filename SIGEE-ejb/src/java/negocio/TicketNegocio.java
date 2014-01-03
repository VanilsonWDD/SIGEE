/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import dao.TicketFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Site;
import modelo.Ticket;

/**
 *
 * @author Vanilson
 */
@Stateless
@LocalBean
public class TicketNegocio {
    @EJB
    private TicketFacade ticketFacade;
    Ticket ticket = new Ticket();
    Site site = new Site();
    
    public void guardar(Ticket t){
        ticketFacade.create(t);
    }
    public void eliminar(int codigoTicket){
        ticket = ticketFacade.find(codigoTicket);
        ticketFacade.remove(ticket);
    }    
    public List<Ticket> getTickets(){
        return ticketFacade.findAll();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
