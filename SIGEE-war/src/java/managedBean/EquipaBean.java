/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Equipa;
import modelo.EquipaFuncionario;
import modelo.EquipaFuncionarioPK;
import modelo.TbFuncionario;
import negocio.EquipaFuncionarioNegocio;
import negocio.EquipaNegocio;
import negocio.ListagemNegocio;
import org.primefaces.model.DualListModel;

/**
 *
 * @author Vanilson
 */
@ManagedBean
@RequestScoped
public class EquipaBean {
    @EJB
    private ListagemNegocio listagemNegocio;

    @EJB
    private EquipaNegocio equipaNegocio;
    @EJB
    private EquipaFuncionarioNegocio equipaFuncionarioNegocio;   
    private List<Equipa> le;
    private TbFuncionario funcionario;
    private DualListModel<TbFuncionario> listagemFuncionarios;
    List<TbFuncionario> source = new ArrayList<TbFuncionario>();
    List<TbFuncionario> target = new ArrayList<TbFuncionario>();
    private List<EquipaFuncionario> lef;
    private Equipa equipa;
    private EquipaFuncionario equipaFuncionario;
    private EquipaFuncionarioPK equipaFuncionarioPK;
    /**
     * Creates a new instance of EquipaBean
     */
    public EquipaBean() {
        equipa = new Equipa();
    }
    @PostConstruct
    public void postConstruct(){
        source = listagemNegocio.getFuncionarios();
        listagemFuncionarios = new DualListModel<TbFuncionario>(source, target);
    }
    public void guardarEquipa(){
        FacesContext fc = FacesContext.getCurrentInstance();
        equipaFuncionario = new EquipaFuncionario();
        equipaFuncionarioPK = new EquipaFuncionarioPK(); 
        funcionario = new TbFuncionario();
        equipaNegocio.guardar(equipa);
        int codigoUltimaEquipa = equipaNegocio.getUltimaEquipa();
        
        target = listagemFuncionarios.getTarget();
        for(int i = 0; i < target.size(); i++){
            equipa.setCodigoEquipa(codigoUltimaEquipa);
            equipaFuncionario.setEquipa(equipa);
            funcionario.setPkFuncionario(target.get(i).getPkFuncionario());
            equipaFuncionario.setPkFuncionario(funcionario);

           //equipaFuncionarioPK.set(target.get(i).getPkFuncionario());
           equipaFuncionarioPK.setCodigoEquipa(codigoUltimaEquipa);

            equipaFuncionario.setEquipaFuncionarioPK(equipaFuncionarioPK);
            equipaFuncionarioNegocio.guardar(equipaFuncionario);
        }
        fc.addMessage(null, new FacesMessage("Equipa", "A nova equipe foi salva com sucesso"));
    }
    public void eliminar(int codigoEquipa){
        FacesContext fc = FacesContext.getCurrentInstance();
        equipaFuncionarioNegocio.eliminar(codigoEquipa);
        //equipaNegocio.eliminar(codigoEquipa);
        fc.addMessage(null, new FacesMessage("Equipa", "A equipa foi eliminada com sucesso"));        
    }
    public List<EquipaFuncionario> getEquipaFuncionarioPorCodigo(int codigo){
        lef = equipaFuncionarioNegocio.getEquipaFuncionarioPorCodigo(codigo);
        System.out.println("Tamanho: " );
        System.out.println("Tamanho: " + lef.size());
        return lef;
    }
    public List<Equipa> getEquipas(){
        le = equipaNegocio.getEquipas();
        return le;
    }
    public void mostrarCodigo(int codigo){
        System.out.println("Codigo: " + codigo);
    }
    public ListagemNegocio getListagemNegocio() {
        return listagemNegocio;
    }

    public void setListagemNegocio(ListagemNegocio listagemNegocio) {
        this.listagemNegocio = listagemNegocio;
    }

    public TbFuncionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(TbFuncionario funcionario) {
        this.funcionario = funcionario;
    }

    public DualListModel<TbFuncionario> getListagemFuncionarios() {
        return listagemFuncionarios;
    }

    public void setListagemFuncionarios(DualListModel<TbFuncionario> listagemFuncionarios) {
        this.listagemFuncionarios = listagemFuncionarios;
    }

    public Equipa getEquipa() {
        return equipa;
    }

    public void setEquipa(Equipa equipa) {
        this.equipa = equipa;
    }

    public EquipaFuncionario getEquipaFuncionario() {
        return equipaFuncionario;
    }

    public void setEquipaFuncionario(EquipaFuncionario equipaFuncionario) {
        this.equipaFuncionario = equipaFuncionario;
    }

    public List<EquipaFuncionario> getLef() {
        return lef;
    }

    public void setLef(List<EquipaFuncionario> lef) {
        this.lef = lef;
    }
   
}
