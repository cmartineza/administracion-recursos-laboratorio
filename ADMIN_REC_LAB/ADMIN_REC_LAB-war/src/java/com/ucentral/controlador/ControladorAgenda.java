/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.controlador;

import com.ucentral.entidades.Archivo;
import com.ucentral.entidades.Postulacion;
import com.ucentral.service.ServiceAgenda;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author MARA
 */
@ManagedBean(name = "agenda")
@SessionScoped
public class ControladorAgenda {
    private @EJB ServiceAgenda serviceAgenda;
    private UploadedFile file;
    private Postulacion postulacion;
    private Archivo archivo;
    private Date fecha1;
    private Date fecha2;
    
    public void reservar(){
        try {
            serviceAgenda.realizarReserva(postulacion);
        } catch (Exception e) {
            
        }
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Postulacion getPostulacion() {
        return postulacion;
    }

    public void setPostulacion(Postulacion postulacion) {
        this.postulacion = postulacion;
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }

    public Date getFecha1() {
        return fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }
    
    
    
    
    
    
}
