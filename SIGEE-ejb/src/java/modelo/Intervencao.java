/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vanilson
 */
@Entity
@Table(name = "intervencao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intervencao.findAll", query = "SELECT i FROM Intervencao i"),
    @NamedQuery(name = "Intervencao.findByCodigoIntervencao", query = "SELECT i FROM Intervencao i WHERE i.codigoIntervencao = :codigoIntervencao"),
    @NamedQuery(name = "Intervencao.findByDataIntervencao", query = "SELECT i FROM Intervencao i WHERE i.dataIntervencao = :dataIntervencao")})
public class Intervencao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_intervencao")
    private Integer codigoIntervencao;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentario_intervencao")
    private String comentarioIntervencao;
    @Column(name = "data_intervencao")
    @Temporal(TemporalType.DATE)
    private Date dataIntervencao;
    @JoinColumn(name = "codigo_ticket", referencedColumnName = "codigo_ticket")
    @ManyToOne(optional = false)
    private Ticket codigoTicket;

    public Intervencao() {
    }

    public Intervencao(Integer codigoIntervencao) {
        this.codigoIntervencao = codigoIntervencao;
    }

    public Integer getCodigoIntervencao() {
        return codigoIntervencao;
    }

    public void setCodigoIntervencao(Integer codigoIntervencao) {
        this.codigoIntervencao = codigoIntervencao;
    }

    public String getComentarioIntervencao() {
        return comentarioIntervencao;
    }

    public void setComentarioIntervencao(String comentarioIntervencao) {
        this.comentarioIntervencao = comentarioIntervencao;
    }

    public Date getDataIntervencao() {
        return dataIntervencao;
    }

    public void setDataIntervencao(Date dataIntervencao) {
        this.dataIntervencao = dataIntervencao;
    }

    public Ticket getCodigoTicket() {
        return codigoTicket;
    }

    public void setCodigoTicket(Ticket codigoTicket) {
        this.codigoTicket = codigoTicket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoIntervencao != null ? codigoIntervencao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Intervencao)) {
            return false;
        }
        Intervencao other = (Intervencao) object;
        if ((this.codigoIntervencao == null && other.codigoIntervencao != null) || (this.codigoIntervencao != null && !this.codigoIntervencao.equals(other.codigoIntervencao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Intervencao[ codigoIntervencao=" + codigoIntervencao + " ]";
    }
    
}
