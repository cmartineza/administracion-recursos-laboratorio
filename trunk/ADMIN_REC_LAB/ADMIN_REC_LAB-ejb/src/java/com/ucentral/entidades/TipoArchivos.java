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
@Table(name = "tipo_archivos", catalog = "bd_calidad", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoArchivos.findAll", query = "SELECT t FROM TipoArchivos t"),
    @NamedQuery(name = "TipoArchivos.findByIdTipoArchivo", query = "SELECT t FROM TipoArchivos t WHERE t.idTipoArchivo = :idTipoArchivo"),
    @NamedQuery(name = "TipoArchivos.findByDescripcion", query = "SELECT t FROM TipoArchivos t WHERE t.descripcion = :descripcion")})
public class TipoArchivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_archivo")
    private Integer idTipoArchivo;
    @Size(max = 60)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "tipoArchivos")
    private List<Archivo> archivosList;

    public TipoArchivos() {
    }

    public TipoArchivos(Integer idTipoArchivo) {
        this.idTipoArchivo = idTipoArchivo;
    }

    public Integer getIdTipoArchivo() {
        return idTipoArchivo;
    }

    public void setIdTipoArchivo(Integer idTipoArchivo) {
        this.idTipoArchivo = idTipoArchivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Archivo> getArchivosList() {
        return archivosList;
    }

    public void setArchivosList(List<Archivo> archivosList) {
        this.archivosList = archivosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoArchivo != null ? idTipoArchivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoArchivos)) {
            return false;
        }
        TipoArchivos other = (TipoArchivos) object;
        if ((this.idTipoArchivo == null && other.idTipoArchivo != null) || (this.idTipoArchivo != null && !this.idTipoArchivo.equals(other.idTipoArchivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucentra.entidades.TipoArchivos[ idTipoArchivo=" + idTipoArchivo + " ]";
    }
    
}
