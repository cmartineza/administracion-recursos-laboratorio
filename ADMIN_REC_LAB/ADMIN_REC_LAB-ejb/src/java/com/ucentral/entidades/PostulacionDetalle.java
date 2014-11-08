/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARA
 */
@Entity
@Table(name = "POSTULACION_DETALLE", catalog = "bd_calidad", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PostulacionDetalle.findAll", query = "SELECT p FROM PostulacionDetalle p"),
    @NamedQuery(name = "PostulacionDetalle.findByIdPostulacionDetalle", query = "SELECT p FROM PostulacionDetalle p WHERE p.idPostulacionDetalle = :idPostulacionDetalle"),
    @NamedQuery(name = "PostulacionDetalle.findByHoraInicial", query = "SELECT p FROM PostulacionDetalle p WHERE p.horaInicial = :horaInicial"),
    @NamedQuery(name = "PostulacionDetalle.findByHoraFinal", query = "SELECT p FROM PostulacionDetalle p WHERE p.horaFinal = :horaFinal"),
    @NamedQuery(name = "PostulacionDetalle.findByFechaPostulacion", query = "SELECT p FROM PostulacionDetalle p WHERE p.fechaPostulacion = :fechaPostulacion"),
    @NamedQuery(name = "PostulacionDetalle.findByDay", query="SELECT p FROM PostulacionDetalle p INNER JOIN p.postulacion po INNER JOIN po.estadosPostulacion e WHERE p.fechaPostulacion = :fechaPostulacion  AND  e.idEstadoPostulacion =: idEstadoPostulacion"),
    @NamedQuery(name = "PostulacionDetalle.findByDayAndHour", query="SELECT p FROM PostulacionDetalle p INNER JOIN p.postulacion po INNER JOIN po.estadosPostulacion e WHERE p.fechaPostulacion = :fechaPostulacion AND p.horaInicial = :hora  AND  e.idEstadoPostulacion =: idEstadoPostulacion"),
    @NamedQuery(name = "PostulacionDetalle.findByDate", query="SELECT p FROM PostulacionDetalle p INNER JOIN p.postulacion po INNER JOIN po.estadosPostulacion e WHERE p.fechaPostulacion BETWEEN :fechaInicial AND :fechaFinal  AND  e.idEstadoPostulacion =: idEstadoPostulacion"),
    @NamedQuery(name = "PostulacionDetalle.findByIdPostulacion", query="SELECT p FROM PostulacionDetalle p INNER JOIN p.postulacion po INNER JOIN po.estadosPostulacion e WHERE po.idPostulacion = :idPostulacion AND  e.idEstadoPostulacion =: idEstadoPostulacion"),
})
public class PostulacionDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String FIND_BY_DAY = "findByDay";
    public static final String FIND_BY_HOUR= "findByDayAndHour";
    public static final String FIND_BY_DATE = "findByDate";
    public static final String FIND_BY_POSTULACION= "findByIdPostulacion";
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_POSTULACION_DETALLE")
    private String idPostulacionDetalle;
    @Size(max = 40)
    @Column(name = "HORA_INICIAL")
    private String horaInicial;
    @Size(max = 40)
    @Column(name = "HORA_FINAL")
    private String horaFinal;
    @Column(name = "FECHA_POSTULACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPostulacion;
    @JoinColumn(name = "ID_POSTULACION", referencedColumnName = "id_postulacion")
    @ManyToOne
    private Postulacion postulacion;
    @JoinColumn(name = "ID_AREA_POSTULACION", referencedColumnName = "id_area")
    @ManyToOne
    private Area area;

    public PostulacionDetalle() {
    }

    public PostulacionDetalle(String idPostulacionDetalle) {
        this.idPostulacionDetalle = idPostulacionDetalle;
    }

    public String getIdPostulacionDetalle() {
        return idPostulacionDetalle;
    }

    public void setIdPostulacionDetalle(String idPostulacionDetalle) {
        this.idPostulacionDetalle = idPostulacionDetalle;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Date getFechaPostulacion() {
        return fechaPostulacion;
    }

    public void setFechaPostulacion(Date fechaPostulacion) {
        this.fechaPostulacion = fechaPostulacion;
    }

    public Postulacion getPostulacion() {
        return postulacion;
    }

    public void setPostulacion(Postulacion postulacion) {
        this.postulacion = postulacion;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPostulacionDetalle != null ? idPostulacionDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PostulacionDetalle)) {
            return false;
        }
        PostulacionDetalle other = (PostulacionDetalle) object;
        if ((this.idPostulacionDetalle == null && other.idPostulacionDetalle != null) || (this.idPostulacionDetalle != null && !this.idPostulacionDetalle.equals(other.idPostulacionDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucentra.entidades.PostulacionDetalle[ idPostulacionDetalle=" + idPostulacionDetalle + " ]";
    }
    
}
