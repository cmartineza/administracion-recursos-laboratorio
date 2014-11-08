/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARA
 */
@Entity
@Table(name = "PROFESOR_HAS_ESTUDIANTE", catalog = "bd_calidad", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfesorHasEstudiante.findAll", query = "SELECT p FROM ProfesorHasEstudiante p"),
    @NamedQuery(name = "ProfesorHasEstudiante.findByIdRegistro", query = "SELECT p FROM ProfesorHasEstudiante p WHERE p.idRegistro = :idRegistro"),
    @NamedQuery(name = "ProfesorHasEstudiante.findByProfEstu", query = "SELECT p FROM ProfesorHasEstudiante p INNER JOIN p.usuarios u INNER JOIN p.usuarios1 e WHERE u.numeroIdentificacion = :idProfesor AND  e.numeroIdentificacion = :idEstudiante")
})
public class ProfesorHasEstudiante implements Serializable {
    public static final String FIND_BY_PROF_ESTU = "ProfesorHasEstudiante.findByProfEstu";
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REGISTRO",unique = true, nullable = false)
    private Integer idRegistro;
    @JoinColumn(name = "ID_ESTUDIANTE", referencedColumnName = "numero_identificacion")
    @ManyToOne
    private Usuario usuarios;
    @JoinColumn(name = "ID_PROFESOR", referencedColumnName = "numero_identificacion")
    @ManyToOne
    private Usuario usuarios1;

    public ProfesorHasEstudiante() {
    }

    public ProfesorHasEstudiante(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuarios1() {
        return usuarios1;
    }

    public void setUsuarios1(Usuario usuarios1) {
        this.usuarios1 = usuarios1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistro != null ? idRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfesorHasEstudiante)) {
            return false;
        }
        ProfesorHasEstudiante other = (ProfesorHasEstudiante) object;
        if ((this.idRegistro == null && other.idRegistro != null) || (this.idRegistro != null && !this.idRegistro.equals(other.idRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucentra.entidades.ProfesorHasEstudiante[ idRegistro=" + idRegistro + " ]";
    }
    
}
