/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import dao.IntervencaoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Intervencao;

/**
 *
 * @author Vanilson
 */
@Stateless
@LocalBean
public class IntervencaoNegocio {
    @EJB
    private IntervencaoFacade intervencaoFacade;
    Intervencao intervencao = new Intervencao();
    
    public void guardar(Intervencao intervencao){
        intervencaoFacade.create(intervencao);
    }
    public List<Intervencao> getIntervencoes(){
        return intervencaoFacade.findAll();
    }
    public void eliminar(int codigoIntervencao){
        intervencao = intervencaoFacade.find(codigoIntervencao);
        intervencaoFacade.remove(intervencao);
    } 
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
