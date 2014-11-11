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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARA
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametro.findAll", query = "SELECT p FROM Parametro p"),
    @NamedQuery(name = "Parametro.findByIdParametro", query = "SELECT p FROM Parametro p WHERE p.idParametro = :idParametro"),
    @NamedQuery(name = "Parametro.findBySeccion", query = "SELECT p FROM Parametro p WHERE p.seccion = :seccion"),
    @NamedQuery(name = "Parametro.findBySubseccion", query = "SELECT p FROM Parametro p WHERE p.subseccion = :subseccion"),
    @NamedQuery(name = "Parametro.findByValor", query = "SELECT p FROM Parametro p WHERE p.valor = :valor")})
public class Parametro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_parametro")
    private Integer idParametro;
    @Size(max = 100)
    private String seccion;
    @Size(max = 100)
    private String subseccion;
    @Size(max = 1000)
    private String valor;

    public Parametro() {
    }

    public Parametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public Integer getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getSubseccion() {
        return subseccion;
    }

    public void setSubseccion(String subseccion) {
        this.subseccion = subseccion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParametro != null ? idParametro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametro)) {
            return false;
        }
        Parametro other = (Parametro) object;
        if ((this.idParametro == null && other.idParametro != null) || (this.idParametro != null && !this.idParametro.equals(other.idParametro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucentral.entidades.Parametro[ idParametro=" + idParametro + " ]";
    }
    
}
