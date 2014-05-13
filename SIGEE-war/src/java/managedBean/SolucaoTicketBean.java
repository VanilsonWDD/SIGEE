/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBean;

import dao.TicketFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Estado;
import modelo.SolucaoTicket;
import modelo.Ticket;
import negocio.SolucaoTicketNegocio;

/**
 *
 * @author Vanilson
 */
@ManagedBean
@RequestScoped
public class SolucaoTicketBean {
    @EJB
    private SolucaoTicketNegocio solucaoTicketNegocio;
    @EJB
    private TicketFacade ticketFacade;
    private List<SolucaoTicket> lst;
    private SolucaoTicket solucaoTicket;
    private Ticket ticket;
    private Estado estado;
    private final int ESTADO = 4;
    /**
     * Creates a new instance of SolucaoBean
     */
    public SolucaoTicketBean() {
        solucaoTicket = new SolucaoTicket();
        ticket = new Ticket();
        estado = new Estado();
    }
    public void guardar(){
        FacesContext fc = FacesContext.getCurrentInstance(); 
        int codigoTicket = ticket.getCodigoTicket();
        ticket = ticketFacade.getTicketPorCodigo(codigoTicket);
        solucaoTicket.setCodigoTicket(ticket);
        estado.setCodigoEstado(ESTADO);
        solucaoTicket.setCodigoEstado(estado);
        solucaoTicketNegocio.guardar(solucaoTicket);
        fc.addMessage(null, new FacesMessage("Solução", "A nova solução foi salva com sucesso")); 
    }
    public void eliminar(int codigoSolucaoTicket){
        FacesContext fc = FacesContext.getCurrentInstance();
        solucaoTicketNegocio.eliminar(codigoSolucaoTicket);
        fc.addMessage(null, new FacesMessage("Solução", "A solução foi eliminada com sucesso")); 
    }
    public List<SolucaoTicket> getSolucaoTickets(){
        lst = solucaoTicketNegocio.getSolucaoTickets();
        return lst;
    }   

    public SolucaoTicket getSolucaoTicket() {
        return solucaoTicket;
    }

    public void setSolucaoTicket(SolucaoTicket solucaoTicket) {
        this.solucaoTicket = solucaoTicket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

}
