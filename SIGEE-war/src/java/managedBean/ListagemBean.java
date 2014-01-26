/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Equipa;
import modelo.Estado;
import modelo.Funcionario;
import modelo.Impacto;
import modelo.Prioridade;
import modelo.Site;
import modelo.Ticket;
import modelo.TipoSite;
import negocio.ListagemNegocio;


/**
 *
 * @author Vanilson
 */
@ManagedBean
@SessionScoped
public class ListagemBean {
    @EJB
    private ListagemNegocio listagemNegocio;
    private List<Site> ls;
    private List<Funcionario> lf;
    private List<Impacto> li;
    private List<Equipa> le;
    private List<Prioridade> lp;
    private List<Estado> les;
    private List<TipoSite> lts;
    private Site site;
    private Ticket ticket;
    private Funcionario funcionario;
    private Impacto impacto;
    private Equipa equipa;
    private Prioridade prioridade;
    private Estado estado;
    private TipoSite tipoSite;
    /**
     * Creates a new instance of Ticket
     */
    public ListagemBean() {
        site = new Site();
    }
    public List<TipoSite> getTipoSites(){
        lts = listagemNegocio.getTipoSites();
        return lts;
    }
    public List<Site> getSites(){
        ls = listagemNegocio.getSites();
        return ls;
    }

    public List<Funcionario> getFuncionarios(){
        lf = listagemNegocio.getFuncionarios();
        return lf;
    }
    public List<Impacto> getImpactos(){
        li = listagemNegocio.getImpactos();
        return li;
    }
    public List<Equipa> getEquipas(){
        le = listagemNegocio.getEquipas();
        return le;
    }
    public List<Prioridade> getPrioridades(){
        lp = listagemNegocio.getPrioridades();
        return lp;
    }
    public List<Estado> getEstados(){
        les = listagemNegocio.getEstados();
        return les;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public TipoSite getTipoSite() {
        return tipoSite;
    }

    public void setTipoSite(TipoSite tipoSite) {
        this.tipoSite = tipoSite;
    }

}
