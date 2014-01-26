/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import dao.EquipaFacade;
import dao.EstadoFacade;
import dao.FuncionarioFacade;
import dao.ImpactoFacade;
import dao.PrioridadeFacade;
import dao.SiteFacade;
import dao.TipoSiteFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Equipa;
import modelo.Estado;
import modelo.Funcionario;
import modelo.Impacto;
import modelo.Prioridade;
import modelo.Site;
import modelo.TipoSite;

/**
 *
 * @author Vanilson
 */
@Stateless
@LocalBean
public class ListagemNegocio {
    @EJB
    private TipoSiteFacade tipoSiteFacade;
    @EJB
    private EstadoFacade estadoFacade;
    @EJB
    private PrioridadeFacade prioridadeFacade;
    @EJB
    private EquipaFacade equipaFacade;
    @EJB
    private FuncionarioFacade funcionarioFacade;
    @EJB
    private SiteFacade siteFacade;
    @EJB
    private ImpactoFacade impactoFacade;
    
    public List<Site> getSites(){
        return siteFacade.findAll();
    }
    public List<Funcionario> getFuncionarios(){
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
}
