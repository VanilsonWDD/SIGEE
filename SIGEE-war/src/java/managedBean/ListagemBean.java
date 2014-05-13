/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Equipa;
import modelo.Estado;
import modelo.TbFuncionario;
import modelo.Impacto;
import modelo.Prioridade;
import modelo.Site;
import modelo.Ticket;
import modelo.TipoAnomalia;
import modelo.TipoSite;
import negocio.ListagemNegocio;
import org.primefaces.model.DualListModel;


/**
 *
 * @author Vanilson
 */
@ManagedBean
@RequestScoped
public class ListagemBean {
    @EJB
    private ListagemNegocio listagemNegocio = new ListagemNegocio();
    
    private List<Site> ls;
    private List<TbFuncionario> lf;
    private List<Impacto> li;
    private List<Equipa> le;
    private List<Prioridade> lp;
    private List<Estado> les;
    private List<TipoSite> lts;
    private List<TipoAnomalia> lta;
    private List<Ticket> lt;
    private Site site;
    private Ticket ticket;
    private Funcionario funcionario;
    private Impacto impacto;
    private Equipa equipa;
    private Prioridade prioridade;
    private Estado estado;
    private TipoSite tipoSite;
    private TipoAnomalia tipoAnamolia;
    private DualListModel<TbFuncionario> listagemFuncionarios;
   List<TbFuncionario> source = new ArrayList<TbFuncionario>();
   List<TbFuncionario> target = new ArrayList<TbFuncionario>();
    /**
     * Creates a new instance of Ticket
     */
    private String nome;
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
    public List<Ticket> getTickets(){
        lt = listagemNegocio.getTickets();
        return lt;
    }
    public DualListModel<TbFuncionario> getFuncionariosPickList(){
        source = listagemNegocio.getFuncionarios();
        listagemFuncionarios = new DualListModel<TbFuncionario>(source, target);
        return listagemFuncionarios;
    }
    public void guardarEquipa(){
        System.out.println("Chamou o metodo: " + getNome());
        target = listagemFuncionarios.getTarget();
        for(int i = 0; i < target.size(); i++)
            System.out.println("Funcionarios: " + target.get(i));
    }
    public List<TbFuncionario> getFuncionarios(){
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
    public List<TipoAnomalia> getTipoAnomalias(){
        lta = listagemNegocio.getTipoAnomalia();
        return lta;
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

    public TipoAnomalia getTipoAnamolia() {
        return tipoAnamolia;
    }

    public void setTipoAnamolia(TipoAnomalia tipoAnamolia) {
        this.tipoAnamolia = tipoAnamolia;
    }

    public DualListModel<TbFuncionario> getListagemFuncionarios() {
        return listagemFuncionarios;
    }

    public void setListagemFuncionarios(DualListModel<TbFuncionario> listagemFuncionarios) {
        this.listagemFuncionarios = listagemFuncionarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
