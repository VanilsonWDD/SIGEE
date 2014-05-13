/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBean;

import dao.TipoAnomaliaFacade;
import dao.TipoSiteFacade;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import modelo.Site;
import modelo.TipoAnomalia;
import modelo.TipoSite;
import negocio.SiteNegocio;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Vanilson
 */
@ManagedBean
@ViewScoped
public class SiteBean {
    @EJB
    private TipoAnomaliaFacade tipoAnomaliaFacade;

    @EJB
    private TipoSiteFacade tipoSiteFacade;
    @EJB
    private SiteNegocio siteNegocio;
    
    private List<Site> ls;
    TipoSite tipoSite;
    TipoAnomalia tipoAnomalia;
    Site site;
    String caminhoImagemSite = "";
    String nomeImagemSite = "";
    /**
     * Creates a new instance of SiteBean
     */
    public SiteBean() {
        site = new Site();
        tipoSite = new TipoSite();
        tipoAnomalia = new TipoAnomalia();
    }
    public void guardar(){
        
        FacesContext fc = FacesContext.getCurrentInstance();
        int codigoTipoSite = tipoSite.getCodigoTipoSite();
        int codigoTipoAnomalia = tipoAnomalia.getCodigoTipoAnomalia();
        tipoSite = tipoSiteFacade.getTipoSitePorCodigo(codigoTipoSite);
        tipoAnomalia = tipoAnomaliaFacade.getTipoAnomaliaPorCodigo(codigoTipoAnomalia);
        site.setCodigoTipoSite(tipoSite);
        site.setCodigoTipoAnomalia(tipoAnomalia);
        site.setCaminhoFotoSite(caminhoImagemSite);
        site.setNomeFotoSite(nomeImagemSite);
        siteNegocio.guardar(site);
        fc.addMessage(null, new FacesMessage("Site", "O novo site foi salvo com sucesso"));  
    }
    public void eliminar(int codigoSite){
        FacesContext fc = FacesContext.getCurrentInstance();
        siteNegocio.eliminar(codigoSite);
        fc.addMessage(null, new FacesMessage("Site", "O site foi eliminado com sucesso"));  
    }    
    public List<Site> getSites(){
        ls = siteNegocio.getSites();
        return ls;
    }
    public void fileUploadAction(FileUploadEvent event) {
        
        try {
            OutputStream out = null;
            InputStream in = event.getFile().getInputstream();
            
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

            FacesContext aFacesContext = FacesContext.getCurrentInstance();
            ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();

            String realPath = context.getRealPath("/");

            File file = new File(realPath + "/img/sites/");
            file.mkdirs();
          
            caminhoImagemSite = realPath + "img/sites/" + event.getFile().getFileName();
            nomeImagemSite = event.getFile().getFileName();
            out = new FileOutputStream(caminhoImagemSite);
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) 
            {
                out.write(bytes, 0, read);
            }
            out.flush(); 
        } 
        catch (Throwable ex) {
            ex.printStackTrace();
        }
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

    public TipoAnomalia getTipoAnomalia() {
        return tipoAnomalia;
    }

    public void setTipoAnomalia(TipoAnomalia tipoAnomalia) {
        this.tipoAnomalia = tipoAnomalia;
    }
    
}
