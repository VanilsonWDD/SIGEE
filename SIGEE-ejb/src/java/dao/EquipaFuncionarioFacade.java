/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.EquipaFuncionario;

/**
 *
 * @author Vanilson
 */
@Stateless
public class EquipaFuncionarioFacade extends AbstractFacade<EquipaFuncionario> {
    @PersistenceContext(unitName = "SIGEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipaFuncionarioFacade() {
        super(EquipaFuncionario.class);
    }
    public List<EquipaFuncionario> getEquipaFuncionarioPorCodigo(int codigoEquipa){
        Query q = em.createQuery("SELECT ef FROM EquipaFuncionario ef WHERE ef.equipaFuncionarioPK.codigoEquipa  = '"+ codigoEquipa +"'");
        return q.getResultList();        
    }
    public void eliminarEquipa(int codigoEquipa){
        Query q = em.createQuery("DELETE FROM EquipaFuncionario ef WHERE ef.equipaFuncionarioPK.codigoEquipa  = '"+ codigoEquipa +"'");    
    }   
}
