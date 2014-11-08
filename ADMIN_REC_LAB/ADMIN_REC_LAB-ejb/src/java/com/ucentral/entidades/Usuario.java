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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MARA
 */
@Entity
@Table(name = "usuarios", catalog = "bd_calidad", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByNumeroIdentificacion", query = "SELECT u FROM Usuario u WHERE u.numeroIdentificacion = :numeroIdentificacion"),
    @NamedQuery(name = "Usuario.findByNombres", query = "SELECT u FROM Usuario u WHERE u.nombres LIKE :param"),
    @NamedQuery(name = "Usuario.findByApellido1", query = "SELECT u FROM Usuario u WHERE u.apellido1 LIKE :param"),
    @NamedQuery(name = "Usuario.findByApellido2", query = "SELECT u FROM Usuario u WHERE u.apellido2 LIKE :param"),
    @NamedQuery(name = "Usuario.findByCelular", query = "SELECT u FROM Usuario u WHERE u.celular = :celular"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.validarPass", query = "SELECT u FROM Usuario u WHERE u.numeroIdentificacion = :id and u.contrasena = :pass"),
    @NamedQuery(name = "Usuario.buscarPorEstado",query = "SELECT u FROM Usuario u INNER JOIN u.estadoUsuario e WHERE e.idEstado = :estado")
})
   
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String queryLogin = "Usuario.validarPass";
    public static final String findByIdentificacion = "Usuario.findByNombres";
    public static final String findByNombre = "Usuario.findByNombres";
    public static final String findByApellido1 = "Usuario.findByApellido1";
    public static final String findByApellido2 = "Usuario.findByApellido2";
    public static final String buscarPorEstado = "Usuario.buscarPorEstado";
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_identificacion")
    private String numeroIdentificacion;
    @Size(max = 60)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 60)
    @Column(name = "apellido1")
    private String apellido1;
    @Size(max = 60)
    @Column(name = "apellido2")
    private String apellido2;
    @Size(max = 60)
    @Column(name = "celular")
    private String celular;
    private String contrasena;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 60)
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "usuarios")
    private List<Postulacion> postulacionList;
    @OneToMany(mappedBy = "usuarios")
    private List<Archivo> archivosList;
    @OneToMany(mappedBy = "usuarios")
    private List<ProfesorHasEstudiante> profesorHasEstudianteList;
    @OneToMany(mappedBy = "usuarios1")
    private List<ProfesorHasEstudiante> profesorHasEstudianteList1;
    @JoinColumn(name = "id_tipo_doc", referencedColumnName = "id_tipo_documento")
    @ManyToOne
    private TipoDocumento tipoDocumento;
    @JoinColumn(name = "id_perfil", referencedColumnName = "id_tipo_perfil")
    @ManyToOne
    private Perfiles perfiles;
    @JoinColumn(name = "estado_usuario", referencedColumnName = "id_estado")
    @ManyToOne
    private EstadoUsuario estadoUsuario;

    public Usuario() {
    }

    public Usuario(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Postulacion> getPostulacionList() {
        return postulacionList;
    }

    public void setPostulacionList(List<Postulacion> postulacionList) {
        this.postulacionList = postulacionList;
    }

    @XmlTransient
    public List<Archivo> getArchivosList() {
        return archivosList;
    }

    public void setArchivosList(List<Archivo> archivosList) {
        this.archivosList = archivosList;
    }

    @XmlTransient
    public List<ProfesorHasEstudiante> getProfesorHasEstudianteList() {
        return profesorHasEstudianteList;
    }

    public void setProfesorHasEstudianteList(List<ProfesorHasEstudiante> profesorHasEstudianteList) {
        this.profesorHasEstudianteList = profesorHasEstudianteList;
    }

    @XmlTransient
    public List<ProfesorHasEstudiante> getProfesorHasEstudianteList1() {
        return profesorHasEstudianteList1;
    }

    public void setProfesorHasEstudianteList1(List<ProfesorHasEstudiante> profesorHasEstudianteList1) {
        this.profesorHasEstudianteList1 = profesorHasEstudianteList1;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Perfiles getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(Perfiles perfiles) {
        this.perfiles = perfiles;
    }

    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroIdentificacion != null ? numeroIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.numeroIdentificacion == null && other.numeroIdentificacion != null) || (this.numeroIdentificacion != null && !this.numeroIdentificacion.equals(other.numeroIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucentra.entidades.Usuarios[ numeroIdentificacion=" + numeroIdentificacion + " ]";
    }
    
}
