/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.controlador;

import com.ucentral.entidades.EstadoUsuario;
import com.ucentral.entidades.Perfiles;
import com.ucentral.entidades.ProfesorHasEstudiante;
import com.ucentral.entidades.TipoDocumento;
import com.ucentral.entidades.Usuario;
import com.ucentral.service.ServiceUsuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author MARA
 */
@ManagedBean(name = "registro")
@SessionScoped
public class ControladorRegistroApl implements Serializable {
    @EJB private ServiceUsuario serviceUsuario;
    private Usuario usuario;
    private List<Perfiles> listPerfiles;
    private List<TipoDocumento> listTipoDoc; 
    private String tipoRegistro;
    private boolean visibleCodigo;
    private String codigoProfesor;
    private String tipoIdentificacion;
    @PostConstruct
    public void init(){
        usuario = new Usuario();
        listPerfiles = serviceUsuario.listPerfil();
        listTipoDoc = serviceUsuario.listTipoDoc();
        visibleCodigo = false;
    }
    
    public void registrarUsuario(ActionEvent action ){
      String msg = null;
      if("profesor".equals(tipoRegistro)){
          if(serviceUsuario.findByIdUsuario(usuario.getNumeroIdentificacion())== null){
              usuario.setEstadoUsuario(new EstadoUsuario("2"));
              usuario.setPerfiles(new Perfiles("2"));
              usuario.setTipoDocumento(new TipoDocumento(tipoIdentificacion));
//              usuario.getEstadoUsuario().setIdEstado(msg);
              serviceUsuario.crearUsuario(usuario);
              msg = "El usuario fue creado correctamente en el sistema, esta pendiente"
                      + " la aprobacion por parte del laboratorio.";
              this.limpiar();
          }else{
              msg = "El usuario ya esta registrado en la base de datos";
          }
      }else{
          if("estudiante".equals(tipoRegistro)){
              if(serviceUsuario.buscarRelacionEstudianteProfesor(codigoProfesor,
                      usuario.getNumeroIdentificacion())== null){
                  Usuario profesor = serviceUsuario.findByIdUsuario(codigoProfesor);
                  if(profesor != null && profesor.getPerfiles().getIdTipoPerfil()
                          .equals("2")){
                      usuario.setEstadoUsuario(new EstadoUsuario("1"));
                      usuario.setPerfiles(new Perfiles("1"));
                      usuario.setTipoDocumento(new TipoDocumento(tipoIdentificacion));
                      serviceUsuario.crearUsuario(usuario);
                      ProfesorHasEstudiante phe = new ProfesorHasEstudiante();
                      phe.setUsuarios(profesor);
                      phe.setUsuarios1(usuario);
                      serviceUsuario.guardarRelacionProfesorEstudiante(phe);
                      msg = "El registro se realizo satisfactoriamente.";
                      this.limpiar();
                  }else{
                      msg = "El codigo del profesor asociado no existe.";
                  }
                  
              }else{
                  msg = "El usuario ingresado ya se encuentra registrado.";
              }
          }
      }
      
        FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Mensaje",msg);
        FacesContext.getCurrentInstance().addMessage(null, fmsg);
        
    }
    
    public void cambioRegistro(ValueChangeEvent event){
        if("profesor".equals(event.getNewValue().toString())){
            visibleCodigo = false;
        }else{
            visibleCodigo = true;
        }
    }
    
    public void limpiar(){
        usuario = new Usuario();
        visibleCodigo = false;
        codigoProfesor = null;
        tipoIdentificacion = null;
        tipoRegistro = null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Perfiles> getListPerfiles() {
        return listPerfiles;
    }

    public void setListPerfiles(List<Perfiles> listPerfiles) {
        this.listPerfiles = listPerfiles;
    }

    public List<TipoDocumento> getListTipoDoc() {
        return listTipoDoc;
    }

    public void setListTipoDoc(List<TipoDocumento> listTipoDoc) {
        this.listTipoDoc = listTipoDoc;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public boolean isVisibleCodigo() {
        return visibleCodigo;
    }

    public void setVisibleCodigo(boolean visibleCodigo) {
        this.visibleCodigo = visibleCodigo;
    }

    public String getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(String codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
    
    
}
