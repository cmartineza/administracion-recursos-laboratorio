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
@Table(name = "estados_codigo", catalog = "bd_calidad", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosCodigo.findAll", query = "SELECT e FROM EstadosCodigo e"),
    @NamedQuery(name = "EstadosCodigo.findByIdEstadosCodigo", query = "SELECT e FROM EstadosCodigo e WHERE e.idEstadosCodigo = :idEstadosCodigo"),
    @NamedQuery(name = "EstadosCodigo.findByDescripcion", query = "SELECT e FROM EstadosCodigo e WHERE e.descripcion = :descripcion")})
public class EstadosCodigo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estados_codigo")
    private Integer idEstadosCodigo;
    @Size(max = 60)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "estadosCodigo")
    private List<CodigosReserva> codigosReservaList;

    public EstadosCodigo() {
    }

    public EstadosCodigo(Integer idEstadosCodigo) {
        this.idEstadosCodigo = idEstadosCodigo;
    }

    public Integer getIdEstadosCodigo() {
        return idEstadosCodigo;
    }

    public void setIdEstadosCodigo(Integer idEstadosCodigo) {
        this.idEstadosCodigo = idEstadosCodigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<CodigosReserva> getCodigosReservaList() {
        return codigosReservaList;
    }

    public void setCodigosReservaList(List<CodigosReserva> codigosReservaList) {
        this.codigosReservaList = codigosReservaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadosCodigo != null ? idEstadosCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosCodigo)) {
            return false;
        }
        EstadosCodigo other = (EstadosCodigo) object;
        if ((this.idEstadosCodigo == null && other.idEstadosCodigo != null) || (this.idEstadosCodigo != null && !this.idEstadosCodigo.equals(other.idEstadosCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucentra.entidades.EstadosCodigo[ idEstadosCodigo=" + idEstadosCodigo + " ]";
    }
    
}
