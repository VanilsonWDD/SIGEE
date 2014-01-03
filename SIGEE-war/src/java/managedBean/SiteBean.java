/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBean;

import dao.TipoSiteFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Site;
import modelo.TipoSite;
import negocio.SiteNegocio;

/**
 *
 * @author Vanilson
 */
@ManagedBean
@SessionScoped
public class SiteBean {

    @EJB
    private TipoSiteFacade tipoSiteFacade;
    @EJB
    private SiteNegocio siteNegocio;
    
    private List<Site> ls;
    TipoSite tipoSite;
    Site site;
    /**
     * Creates a new instance of SiteBean
     */
    public SiteBean() {
        site = new Site();
        tipoSite = new TipoSite();
    }
    public void guardar(){
        FacesContext fc = FacesContext.getCurrentInstance();
        int codigoTipoSite = tipoSite.getCodigoTipoSite();
        tipoSite = tipoSiteFacade.getTipoSitePorCodigo(codigoTipoSite);
        site.setCodigoTipoSite(tipoSite);
        siteNegocio.guardar(site);
        fc.addMessage(null, new FacesMessage("Site", "O novo site foi salvo com sucesso"));  
    }
    public void eliminar(int codigoSite){
        siteNegocio.eliminar(codigoSite);
    }    
    public List<Site> getSites(){
        ls = siteNegocio.getSites();
        return ls;
    }

    public TipoSite getTipoSite() {
        return tipoSite;
    }

    public void setTipoSite(TipoSite tipoSite) {
        this.tipoSite = tipoSite;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
    
}
