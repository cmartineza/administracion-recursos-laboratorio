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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MARA
 */
@Entity
@Table(name = "CODIGOS_RESERVA", catalog = "bd_calidad", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodigosReserva.findAll", query = "SELECT c FROM CodigosReserva c"),
    @NamedQuery(name = "CodigosReserva.findByIdCodigo", query = "SELECT c FROM CodigosReserva c WHERE c.idCodigo = :idCodigo")})
public class CodigosReserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CODIGO")
    private Integer idCodigo;
    @JoinColumn(name = "ID_POSTULACION", referencedColumnName = "id_postulacion")
    @ManyToOne
    private Postulacion postulacion;
    @JoinColumn(name = "ESTADO_CODIGOS", referencedColumnName = "id_estados_codigo")
    @ManyToOne
    private EstadosCodigo estadosCodigo;
    @OneToMany(mappedBy = "codigosReserva")
    private List<Archivo> archivosList;

    public CodigosReserva() {
    }

    public CodigosReserva(Integer idCodigo) {
        this.idCodigo = idCodigo;
    }

    public Integer getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(Integer idCodigo) {
        this.idCodigo = idCodigo;
    }

    public Postulacion getPostulacion() {
        return postulacion;
    }

    public void setPostulacion(Postulacion postulacion) {
        this.postulacion = postulacion;
    }

    public EstadosCodigo getEstadosCodigo() {
        return estadosCodigo;
    }

    public void setEstadosCodigo(EstadosCodigo estadosCodigo) {
        this.estadosCodigo = estadosCodigo;
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
        hash += (idCodigo != null ? idCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodigosReserva)) {
            return false;
        }
        CodigosReserva other = (CodigosReserva) object;
        if ((this.idCodigo == null && other.idCodigo != null) || (this.idCodigo != null && !this.idCodigo.equals(other.idCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucentra.entidades.CodigosReserva[ idCodigo=" + idCodigo + " ]";
    }
    
}
