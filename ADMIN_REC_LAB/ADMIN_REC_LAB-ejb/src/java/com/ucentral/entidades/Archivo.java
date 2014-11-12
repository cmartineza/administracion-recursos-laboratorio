/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARA
 */
@Entity
@Table(name = "ARCHIVOS", catalog = "bd_calidad", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Archivo.findAll", query = "SELECT a FROM Archivo a"),
    @NamedQuery(name = "Archivo.findByIdArchivo", query = "SELECT a FROM Archivo a WHERE a.idArchivo = :idArchivo"),
    @NamedQuery(name = "Archivo.findByNombreReal", query = "SELECT a FROM Archivo a WHERE a.nombreReal = :nombreReal"),
    @NamedQuery(name = "Archivo.findByNombreReferenciaApl", query = "SELECT a FROM Archivo a WHERE a.nombreReferenciaApl = :nombreReferenciaApl")})
public class Archivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ARCHIVO")
    private Integer idArchivo;
    @Size(max = 50)
    @Column(name = "NOMBRE_REAL")
    private String nombreReal;
    @Size(max = 50)
    @Column(name = "NOMBRE_REFERENCIA_APL")
    private String nombreReferenciaApl;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "numero_identificacion")
    @ManyToOne
    private Usuario usuarios;
    @JoinColumn(name = "ID_TIPO_ARCHIVO", referencedColumnName = "id_tipo_archivo")
    @ManyToOne
    private TipoArchivos tipoArchivos;
    @JoinColumn(name = "ID_CODIGO_GENERADOR", referencedColumnName = "ID_CODIGO")
    @ManyToOne
    private CodigosReserva codigosReserva;

    public Archivo() {
    }

    public Archivo(Integer idArchivo) {
        this.idArchivo = idArchivo;
    }

    public Integer getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(Integer idArchivo) {
        this.idArchivo = idArchivo;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public String getNombreReferenciaApl() {
        return nombreReferenciaApl;
    }

    public void setNombreReferenciaApl(String nombreReferenciaApl) {
        this.nombreReferenciaApl = nombreReferenciaApl;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    public TipoArchivos getTipoArchivos() {
        return tipoArchivos;
    }

    public void setTipoArchivos(TipoArchivos tipoArchivos) {
        this.tipoArchivos = tipoArchivos;
    }

    public CodigosReserva getCodigosReserva() {
        return codigosReserva;
    }

    public void setCodigosReserva(CodigosReserva codigosReserva) {
        this.codigosReserva = codigosReserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArchivo != null ? idArchivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archivo)) {
            return false;
        }
        Archivo other = (Archivo) object;
        if ((this.idArchivo == null && other.idArchivo != null) || (this.idArchivo != null && !this.idArchivo.equals(other.idArchivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucentra.entidades.Archivos[ idArchivo=" + idArchivo + " ]";
    }
    
}
