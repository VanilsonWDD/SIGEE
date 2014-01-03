/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import dao.SiteFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Site;

/**
 *
 * @author Vanilson
 */
@Stateless
@LocalBean
public class SiteNegocio {
    @EJB
    private SiteFacade siteFacade;
    Site site = new Site();
    public void guardar(Site site){
        siteFacade.create(site);
    }
    public void eliminar(int codigoSite){
        site = siteFacade.find(codigoSite);
        siteFacade.remove(site);
    }      
    public List<Site> getSites(){
        return siteFacade.findAll();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
