/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MARA
 */
@Entity
@Table(name = "postulacion", catalog = "bd_calidad", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postulacion.findAll", query = "SELECT p FROM Postulacion p"),
    @NamedQuery(name = "Postulacion.findByIdPostulacion", query = "SELECT p FROM Postulacion p WHERE p.idPostulacion = :idPostulacion"),
    @NamedQuery(name = "Postulacion.findByObservaciones", query = "SELECT p FROM Postulacion p WHERE p.observaciones = :observaciones"),
    @NamedQuery(name = "Postulacion.findByIdArcivoGua", query = "SELECT p FROM Postulacion p WHERE p.idArcivoGua = :idArcivoGua"),
    @NamedQuery(name = "Postulacion.findByTotalPracticates", query = "SELECT p FROM Postulacion p WHERE p.totalPracticates = :totalPracticates"),
    @NamedQuery(name = "Postulacion.findByFechaSolicitud", query = "SELECT p FROM Postulacion p WHERE p.fechaSolicitud = :fechaSolicitud"),
    @NamedQuery(name = "Postulacion.findByHoraSolicitud", query = "SELECT p FROM Postulacion p WHERE p.horaSolicitud = :horaSolicitud"),
    @NamedQuery(name = "Postulacion.findByFechaRespuesta", query = "SELECT p FROM Postulacion p WHERE p.fechaRespuesta = :fechaRespuesta"),
    @NamedQuery(name = "Postulacion.findByHoraRespuesta", query = "SELECT p FROM Postulacion p WHERE p.horaRespuesta = :horaRespuesta"),
    @NamedQuery(name = "Postulacion.findByActivas", query = "SELECT p FROM Postulacion p INNER JOIN p.estadosPostulacion e WHERE e.idEstadoPostulacion =:idEstado")
})
public class Postulacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_postulacion")
    private String idPostulacion;
    @Size(max = 399)
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "id_arcivo_gua")
    private Integer idArcivoGua;
    @Column(name = "total_practicates")
    private Integer totalPracticates;
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitud;
    @Size(max = 60)
    @Column(name = "hora_solicitud")
    private String horaSolicitud;
    @Column(name = "fecha_respuesta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRespuesta;
    @Size(max = 60)
    @Column(name = "hora_respuesta")
    private String horaRespuesta;
    @OneToMany(mappedBy = "postulacion")
    private List<CodigosReserva> codigosReservaList;
    @OneToMany(mappedBy = "postulacion")
    private List<PostulacionDetalle> postulacionDetalleList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "numero_identificacion")
    @ManyToOne
    private Usuario usuarios;
    @JoinColumn(name = "id_tipo_practica", referencedColumnName = "id_tipo_practicas")
    @ManyToOne
    private TipoPracticas tipoPracticas;
    @JoinColumn(name = "id_Estado_postulacion", referencedColumnName = "id_estado_postulacion")
    @ManyToOne
    private EstadosPostulacion estadosPostulacion;

    public Postulacion() {
    }

    public Postulacion(String idPostulacion) {
        this.idPostulacion = idPostulacion;
    }

    public String getIdPostulacion() {
        return idPostulacion;
    }

    public void setIdPostulacion(String idPostulacion) {
        this.idPostulacion = idPostulacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getIdArcivoGua() {
        return idArcivoGua;
    }

    public void setIdArcivoGua(Integer idArcivoGua) {
        this.idArcivoGua = idArcivoGua;
    }

    public Integer getTotalPracticates() {
        return totalPracticates;
    }

    public void setTotalPracticates(Integer totalPracticates) {
        this.totalPracticates = totalPracticates;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getHoraSolicitud() {
        return horaSolicitud;
    }

    public void setHoraSolicitud(String horaSolicitud) {
        this.horaSolicitud = horaSolicitud;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public String getHoraRespuesta() {
        return horaRespuesta;
    }

    public void setHoraRespuesta(String horaRespuesta) {
        this.horaRespuesta = horaRespuesta;
    }

    @XmlTransient
    public List<CodigosReserva> getCodigosReservaList() {
        return codigosReservaList;
    }

    public void setCodigosReservaList(List<CodigosReserva> codigosReservaList) {
        this.codigosReservaList = codigosReservaList;
    }

    @XmlTransient
    public List<PostulacionDetalle> getPostulacionDetalleList() {
        return postulacionDetalleList;
    }

    public void setPostulacionDetalleList(List<PostulacionDetalle> postulacionDetalleList) {
        this.postulacionDetalleList = postulacionDetalleList;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    public TipoPracticas getTipoPracticas() {
        return tipoPracticas;
    }

    public void setTipoPracticas(TipoPracticas tipoPracticas) {
        this.tipoPracticas = tipoPracticas;
    }

    public EstadosPostulacion getEstadosPostulacion() {
        return estadosPostulacion;
    }

    public void setEstadosPostulacion(EstadosPostulacion estadosPostulacion) {
        this.estadosPostulacion = estadosPostulacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPostulacion != null ? idPostulacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postulacion)) {
            return false;
        }
        Postulacion other = (Postulacion) object;
        if ((this.idPostulacion == null && other.idPostulacion != null) || (this.idPostulacion != null && !this.idPostulacion.equals(other.idPostulacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucentra.entidades.Postulacion[ idPostulacion=" + idPostulacion + " ]";
    }
    
}
