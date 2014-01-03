/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBean;

import dao.EquipaFacade;
import dao.EstadoIntervencaoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Equipa;
import modelo.EstadoIntervencao;
import modelo.Intervencao;
import negocio.IntervencaoNegocio;

/**
 *
 * @author Vanilson
 */
@ManagedBean
@SessionScoped
public class IntervencaoBean {
    @EJB
    private EstadoIntervencaoFacade estadoIntervencaoFacade;
    @EJB
    private EquipaFacade equipaFacade;
    @EJB
    private IntervencaoNegocio intervencaoNegocio;
    
    private List<Intervencao> li;
    private Equipa equipa;
    private EstadoIntervencao estadoIntervencao;
    private Intervencao intervencao;
    /**
     * Creates a new instance of IntervencaoBean
     */
    public IntervencaoBean() {
        intervencao = new Intervencao();
        equipa = new Equipa();
        estadoIntervencao = new EstadoIntervencao();
    }
    public void guardar(){
        FacesContext fc = FacesContext.getCurrentInstance(); 
        int codigoEquipa = equipa.getCodigoEquipa();
        int codigoEstadoIntervencao = estadoIntervencao.getCodigoEstadoIntervencao();
        
        equipa = equipaFacade.getEquipaPorCodigo(codigoEquipa);
        estadoIntervencao = estadoIntervencaoFacade.getEstadoIntervencaoPorCodigo(codigoEstadoIntervencao);
        
        intervencao.setCodigoEquipa(equipa);
        intervencao.setCodigoEstadoIntervencao(estadoIntervencao);
        intervencaoNegocio.guardar(intervencao);
        fc.addMessage(null, new FacesMessage("Intervenção", "A nova intervenção foi salva com sucesso"));  

    }
    public List<Intervencao> getIntervencoes(){
        li = intervencaoNegocio.getIntervencoes();
        return li;
    }
    public void eliminar(int codigoIntervencao){
        intervencaoNegocio.eliminar(codigoIntervencao);
    }

    public Equipa getEquipa() {
        return equipa;
    }

    public void setEquipa(Equipa equipa) {
        this.equipa = equipa;
    }

    public EstadoIntervencao getEstadoIntervencao() {
        return estadoIntervencao;
    }

    public void setEstadoIntervencao(EstadoIntervencao estadoIntervencao) {
        this.estadoIntervencao = estadoIntervencao;
    }

    public Intervencao getIntervencao() {
        return intervencao;
    }

    public void setIntervencao(Intervencao intervencao) {
        this.intervencao = intervencao;
    }
    
}