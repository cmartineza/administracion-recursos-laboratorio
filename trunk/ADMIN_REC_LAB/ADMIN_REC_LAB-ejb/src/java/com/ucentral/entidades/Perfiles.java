/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "perfiles", catalog = "bd_calidad", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfiles.findAll", query = "SELECT p FROM Perfiles p"),
    @NamedQuery(name = "Perfiles.findByIdTipoPerfil", query = "SELECT p FROM Perfiles p WHERE p.idTipoPerfil = :idTipoPerfil"),
    @NamedQuery(name = "Perfiles.findByNombrePerfil", query = "SELECT p FROM Perfiles p WHERE p.nombrePerfil = :nombrePerfil")})
public class Perfiles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_perfil")
    private String idTipoPerfil;
    @Size(max = 60)
    @Column(name = "nombre_perfil")
    private String nombrePerfil;
    @OneToMany(mappedBy = "perfiles")
    private List<Usuario> usuariosList;

    public Perfiles() {
    }

    public Perfiles(String idTipoPerfil) {
        this.idTipoPerfil = idTipoPerfil;
    }

    public String getIdTipoPerfil() {
        return idTipoPerfil.toString();
    }

    public void setIdTipoPerfil(String idTipoPerfil) {
        this.idTipoPerfil = idTipoPerfil;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    @XmlTransient
    public List<Usuario> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuario> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPerfil != null ? idTipoPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfiles)) {
            return false;
        }
        Perfiles other = (Perfiles) object;
        if ((this.idTipoPerfil == null && other.idTipoPerfil != null) || (this.idTipoPerfil != null && !this.idTipoPerfil.equals(other.idTipoPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucentra.entidades.Perfiles[ idTipoPerfil=" + idTipoPerfil + " ]";
    }
    
}
