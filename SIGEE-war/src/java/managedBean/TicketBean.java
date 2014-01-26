/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBean;

import dao.EquipaFacade;
import dao.EstadoFacade;
import dao.FuncionarioFacade;
import dao.ImpactoFacade;
import dao.PrioridadeFacade;
import dao.SiteFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Equipa;
import modelo.Estado;
import modelo.Funcionario;
import modelo.Impacto;
import modelo.Prioridade;
import modelo.Site;
import modelo.Ticket;
import negocio.TicketNegocio;

/**
 *
 * @author Vanilson
 */
@ManagedBean
@RequestScoped
public class TicketBean {
    @EJB
    private EstadoFacade estadoFacade;
    @EJB
    private PrioridadeFacade prioridadeFacade;
    @EJB
    private EquipaFacade equipaFacade;
    @EJB
    private ImpactoFacade impactoFacade;
    @EJB
    private FuncionarioFacade funcionarioFacade;
    @EJB
    private SiteFacade siteFacade;
    @EJB
    private TicketNegocio ticketNegocio;
  
    private List<Ticket> lt;
    Ticket ticket;
    Site site;
    Impacto impacto;
    Equipa equipa;
    Prioridade prioridade;
    Estado estado;
    Funcionario funcionario;
    /**
     * Creates a new instance of TicketBean
     */
    public TicketBean() {
        ticket = new Ticket();
        site = new Site();
        funcionario = new Funcionario();
        impacto = new Impacto();
        estado = new Estado();
        prioridade = new Prioridade();
        equipa = new Equipa();
    }
//    public Ticket getTicketSelecionado(){
//        return ticket;
//    }
    public void guardar(){

        FacesContext fc = FacesContext.getCurrentInstance(); 
        int codigoSite = site.getCodigoSite();
        int codigoFuncionario = funcionario.getCodigoFuncionario();
        int codigoEquipa = equipa.getCodigoEquipa();
        int codigoImpacto = impacto.getCodigoImpacto();
        int codigoPrioridade = prioridade.getCodigoPrioridade();
        int codigoEstado = estado.getCodigoEstado();
        
        site = siteFacade.getSitePorCodigo(codigoSite);
        funcionario = funcionarioFacade.getFuncionarioPorCodigo(codigoFuncionario);
        equipa = equipaFacade.getEquipaPorCodigo(codigoEquipa);
        impacto = impactoFacade.getImpactoPorCodigo(codigoImpacto);
        prioridade = prioridadeFacade.getPrioridadePorCodigo(codigoPrioridade);
        estado = estadoFacade.getEstadoPorCodigo(codigoEstado);
        
        ticket.setCodigoSite(site);
        ticket.setCodigoFuncionario(funcionario);
        ticket.setCodigoEquipa(equipa);
        ticket.setCodigoImpacto(impacto);
        ticket.setCodigoPrioridade(prioridade);
        ticket.setCodigoEstado(estado);

        ticketNegocio.guardar(ticket);
        
        fc.addMessage(null, new FacesMessage("Ticket", "O novo ticket foi salvo com sucesso"));  
        
    }
    public void eliminar(int codigoTicket){
        ticketNegocio.eliminar(codigoTicket);
    }
    public List<Ticket> getTickets(){
        lt = ticketNegocio.getTickets();
        return lt;
    }
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Impacto getImpacto() {
        return impacto;
    }

    public void setImpacto(Impacto impacto) {
        this.impacto = impacto;
    }

    public Equipa getEquipa() {
        return equipa;
    }

    public void setEquipa(Equipa equipa) {
        this.equipa = equipa;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
}
