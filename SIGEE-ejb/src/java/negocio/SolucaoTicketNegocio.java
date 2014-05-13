/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import dao.SolucaoTicketFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Intervencao;
import modelo.SolucaoTicket;

/**
 *
 * @author Vanilson
 */
@Stateless
@LocalBean
public class SolucaoTicketNegocio {
    @EJB
    private SolucaoTicketFacade solucaoTicketFacade;
    SolucaoTicket solucaoTicket = new SolucaoTicket();
    public List<SolucaoTicket> getSolucaoTickets(){
        return solucaoTicketFacade.findAll();
    }
    public void guardar(SolucaoTicket solucaoTicket){
        solucaoTicketFacade.create(solucaoTicket);
    }
    public void eliminar(int codigoSolucao){
        solucaoTicket = solucaoTicketFacade.find(codigoSolucao);
        solucaoTicketFacade.remove(solucaoTicket);
    } 
}
