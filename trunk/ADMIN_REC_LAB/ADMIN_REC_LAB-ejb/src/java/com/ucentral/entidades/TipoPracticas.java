/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MARA
 */
@Entity
@Table(name = "tipo_practicas", catalog = "bd_calidad", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPracticas.findAll", query = "SELECT t FROM TipoPracticas t"),
    @NamedQuery(name = "TipoPracticas.findByIdTipoPracticas", query = "SELECT t FROM TipoPracticas t WHERE t.idTipoPracticas = :idTipoPracticas"),
    @NamedQuery(name = "TipoPracticas.findByDescripcion", query = "SELECT t FROM TipoPracticas t WHERE t.descripcion = :descripcion")})
public class TipoPracticas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_practicas")
    private Integer idTipoPracticas;
    @Size(max = 60)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "tipoPracticas")
    private List<Postulacion> postulacionList;

    public TipoPracticas() {
    }

    public TipoPracticas(Integer idTipoPracticas) {
        this.idTipoPracticas = idTipoPracticas;
    }

    public Integer getIdTipoPracticas() {
        return idTipoPracticas;
    }

    public void setIdTipoPracticas(Integer idTipoPracticas) {
        this.idTipoPracticas = idTipoPracticas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Postulacion> getPostulacionList() {
        return postulacionList;
    }

    public void setPostulacionList(List<Postulacion> postulacionList) {
        this.postulacionList = postulacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPracticas != null ? idTipoPracticas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPracticas)) {
            return false;
        }
        TipoPracticas other = (TipoPracticas) object;
        if ((this.idTipoPracticas == null && other.idTipoPracticas != null) || (this.idTipoPracticas != null && !this.idTipoPracticas.equals(other.idTipoPracticas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucentra.entidades.TipoPracticas[ idTipoPracticas=" + idTipoPracticas + " ]";
    }
    
}
