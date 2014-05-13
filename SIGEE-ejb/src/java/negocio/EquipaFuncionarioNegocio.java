/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import dao.EquipaFuncionarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.EquipaFuncionario;
import modelo.EquipaFuncionarioPK;

/**
 *
 * @author Vanilson
 */
@Stateless
@LocalBean
public class EquipaFuncionarioNegocio {
    @EJB
    private EquipaFuncionarioFacade equipaFuncionarioFacade;
    EquipaFuncionario ef = new EquipaFuncionario();
    EquipaFuncionarioPK equipaFuncionarioPK = new EquipaFuncionarioPK();
    public void guardar(EquipaFuncionario equipaFuncionario){
        equipaFuncionarioFacade.create(equipaFuncionario);
    }
    public List<EquipaFuncionario> getEquipaFuncionarioPorCodigo(int codigo){
        return equipaFuncionarioFacade.getEquipaFuncionarioPorCodigo(codigo);
    }
    public void eliminar(int codigoEquipa){
        equipaFuncionarioPK.setCodigoEquipa(codigoEquipa);
        System.out.println(equipaFuncionarioPK);
        //int codigoEquipaFuncionarioPK = equipaFuncionarioPK.getCodigoEquipa();
        //ef = equipaFuncionarioFacade.find(equipaFuncionarioPK);
        //equipaFuncionarioFacade.remove(ef);
    }
}
