/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.controlador;

import com.ucentral.entidades.Usuario;
import com.ucentral.service.ServiceUsuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author MARA
 */
@ManagedBean(name = "controadorLogin")
@RequestScoped
public class ControladorLogin implements Serializable {
    
    public static final String KEY_USURIO_SE = "usuario";
    private @EJB ServiceUsuario serviceAusuario;
    private String contrasena;
    private String idUsuario;
    private FacesContext ctx;
            
    @PostConstruct    
    public void init(){
        ctx = FacesContext.getCurrentInstance();
    }
    public String login(){
        Usuario usuario = serviceAusuario.validarUsuario(
                Integer.parseInt(idUsuario), contrasena);
        System.out.println("constrasena "+contrasena);
        System.out.println("usuario "+idUsuario);
        if(usuario != null){
            ctx.getExternalContext().getSessionMap().put(KEY_USURIO_SE, usuario);
            return "ok";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, 
                 new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Usuario "
                    + "y contraseña invalidos"));
            return "fail";
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
