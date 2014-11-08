/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.controlador;

import com.ucentral.entidades.EstadoUsuario;
import com.ucentral.entidades.Perfiles;
import com.ucentral.entidades.Usuario;
import com.ucentral.service.ServiceUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author MARA
 */
@ManagedBean
@SessionScoped
public class ControladorUsuarios implements Serializable{

    private @EJB
    ServiceUsuario serviceUsuario;
    private List<Usuario> list;
    private Usuario usuario;
    private String valorBusqueda;
    private String tipoDocumento;
    private int tipoBusqueda = -1;
    private List<Perfiles> listPerfil;
    private List<EstadoUsuario> listEstados;
    private String idPerfil;
    private String idEstado;

    @PostConstruct
    public void init() {
        list = serviceUsuario.listaUsuarios();
        listPerfil = serviceUsuario.listPerfil();
        listEstados = serviceUsuario.getAllListEstado();

    }

    public void buscar(ActionEvent action) {
        String msg = "Se ha realizado la consulta";
        FacesMessage fmsg = null;
        FacesMessage.Severity sev = null;
        try {
            if (tipoBusqueda == 1) {
                Usuario usuario = serviceUsuario.findByIdUsuario(valorBusqueda);
                list = new ArrayList<Usuario>();
                list.add(usuario);
            } else {
                if (tipoBusqueda == 5 || tipoBusqueda == 6) {
                    int valor = (tipoBusqueda == 5) ? 2 : 1;
                    list = serviceUsuario.buscarPorEstado(valor);
                } else {
                    list = serviceUsuario.findByNombreUsuario(valorBusqueda, tipoBusqueda);
                }
            }
            sev = FacesMessage.SEVERITY_INFO;

        } catch (Exception ex) {
            msg = "Error en el aplicativo, " + ex.getMessage();
            sev = FacesMessage.SEVERITY_FATAL;
            ex.printStackTrace();
        }
        fmsg = new FacesMessage(sev, "Alerta", msg);
        FacesContext.getCurrentInstance().addMessage(null, fmsg);
    }

    public void modificarUsuario(ActionEvent action) {
        try {
            
            usuario.setPerfiles(serviceUsuario.findPerfilesById(usuario.getPerfiles()
                    .getIdTipoPerfil()));
            serviceUsuario.modificarUsuario(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO, "Mensaje", "Se modifico correctamente el usuario"));
            this.buscar(action);
        } catch (Exception ex) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Error", "No se pudo modificar el usuario,"
                    + " error en el aplicativo"));
            ex.printStackTrace();
        }

    }

    /* get y set */
    public List<Usuario> getList() {
        return list;
    }

    public void setList(List<Usuario> list) {
        this.list = list;
    }

    public Usuario getUsuario() {
        if (usuario != null) {
            idPerfil = usuario.getPerfiles().getIdTipoPerfil().toString();
            idEstado = usuario.getEstadoUsuario().getIdEstado().toString();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getValorBusqueda() {
        return valorBusqueda;
    }

    public void setValorBusqueda(String valorBusqueda) {
        this.valorBusqueda = valorBusqueda;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getTipoBusqueda() {
        return tipoBusqueda;
    }

    public void setTipoBusqueda(int tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }

    public List<Perfiles> getListPerfil() {
        return listPerfil;
    }

    public void setListPerfil(List<Perfiles> listPerfil) {
        this.listPerfil = listPerfil;
    }

    public List<EstadoUsuario> getListEstados() {
        return listEstados;
    }

    public void setListEstados(List<EstadoUsuario> listEstados) {
        this.listEstados = listEstados;
    }

    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }
}
