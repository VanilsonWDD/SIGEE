/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import dao.EquipaFacade;
import dao.EstadoFacade;
import dao.TbFuncionarioFacade;
import dao.ImpactoFacade;
import dao.PrioridadeFacade;
import dao.SiteFacade;
import dao.TicketFacade;
import dao.TipoAnomaliaFacade;
import dao.TipoSiteFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;
import modelo.Equipa;
import modelo.Estado;
import modelo.TbFuncionario;
import modelo.Impacto;
import modelo.Prioridade;
import modelo.Site;
import modelo.Ticket;
import modelo.TipoAnomalia;
import modelo.TipoSite;

/**
 *
 * @author Vanilson
 */
@Stateless
@LocalBean
public class ListagemNegocio {
    @EJB
    private TicketFacade ticketFacade;
    @EJB
    private TipoAnomaliaFacade tipoAnomaliaFacade;
    @EJB
    private TipoSiteFacade tipoSiteFacade;
    @EJB
    private EstadoFacade estadoFacade;
    @EJB
    private PrioridadeFacade prioridadeFacade;
    @EJB
    private EquipaFacade equipaFacade;
    @EJB
    private TbFuncionarioFacade funcionarioFacade;
    @EJB
    private SiteFacade siteFacade;
    @EJB
    private ImpactoFacade impactoFacade;
    
    public List<Site> getSites(){
        return siteFacade.findAll();
    }
    public List<TbFuncionario> getFuncionarios(){
        return funcionarioFacade.findAll();
    }
    public List<Impacto> getImpactos(){
        return impactoFacade.findAll();
    }
    public List<Equipa> getEquipas(){
        return equipaFacade.findAll();
    }  
    public List<Prioridade> getPrioridades(){
        return prioridadeFacade.findAll();
    }
    public List<Estado> getEstados(){
        return estadoFacade.findAll();
    } 
    public List<TipoSite> getTipoSites(){
        return tipoSiteFacade.findAll();
    }
    public List<TipoAnomalia> getTipoAnomalia(){
        return tipoAnomaliaFacade.findAll();
    }
    public List<Ticket> getTickets(){
        return ticketFacade.findAll();
    }
}
