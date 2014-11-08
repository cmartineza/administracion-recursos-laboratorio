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
@Table(name = "estados_postulacion", catalog = "bd_calidad", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosPostulacion.findAll", query = "SELECT e FROM EstadosPostulacion e"),
    @NamedQuery(name = "EstadosPostulacion.findByIdEstadoPostulacion", query = "SELECT e FROM EstadosPostulacion e WHERE e.idEstadoPostulacion = :idEstadoPostulacion"),
    @NamedQuery(name = "EstadosPostulacion.findByDescripcion", query = "SELECT e FROM EstadosPostulacion e WHERE e.descripcion = :descripcion")})
public class EstadosPostulacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estado_postulacion")
    private String idEstadoPostulacion;
    @Size(max = 60)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "estadosPostulacion")
    private List<Postulacion> postulacionList;

    public EstadosPostulacion() {
    }

    public EstadosPostulacion(String idEstadoPostulacion) {
        this.idEstadoPostulacion = idEstadoPostulacion;
    }

    public String getIdEstadoPostulacion() {
        return idEstadoPostulacion;
    }

    public void setIdEstadoPostulacion(String idEstadoPostulacion) {
        this.idEstadoPostulacion = idEstadoPostulacion;
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
        hash += (idEstadoPostulacion != null ? idEstadoPostulacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosPostulacion)) {
            return false;
        }
        EstadosPostulacion other = (EstadosPostulacion) object;
        if ((this.idEstadoPostulacion == null && other.idEstadoPostulacion != null) || (this.idEstadoPostulacion != null && !this.idEstadoPostulacion.equals(other.idEstadoPostulacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucentra.entidades.EstadosPostulacion[ idEstadoPostulacion=" + idEstadoPostulacion + " ]";
    }
    
}
