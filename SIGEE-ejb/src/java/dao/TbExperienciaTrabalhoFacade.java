/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.TbExperienciaTrabalho;

/**
 *
 * @author Vanilson
 */
@Stateless
public class TbExperienciaTrabalhoFacade extends AbstractFacade<TbExperienciaTrabalho> {
    @PersistenceContext(unitName = "SIGEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbExperienciaTrabalhoFacade() {
        super(TbExperienciaTrabalho.class);
    }
    
}
