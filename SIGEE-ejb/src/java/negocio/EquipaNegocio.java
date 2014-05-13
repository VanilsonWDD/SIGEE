/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import dao.EquipaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Equipa;

/**
 *
 * @author Vanilson
 */
@Stateless
@LocalBean
public class EquipaNegocio {
    @EJB
    private EquipaFacade equipaFacade;
    Equipa equipa = new Equipa();
    public void guardar(Equipa equipa){
        equipaFacade.create(equipa);
    }
    public int getUltimaEquipa(){
        return equipaFacade.getUltimaEquipa();
    }
    public List<Equipa> getEquipas(){
        return equipaFacade.findAll();
    }
    public void eliminar(int codigoEquipa){
        equipa = equipaFacade.find(codigoEquipa);
        equipaFacade.remove(equipa);
    }
}
