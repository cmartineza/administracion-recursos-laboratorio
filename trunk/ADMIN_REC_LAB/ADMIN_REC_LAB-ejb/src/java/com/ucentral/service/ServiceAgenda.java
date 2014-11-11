/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.service;

import com.ucentral.ejb.PerfilDao;
import com.ucentral.ejb.PostulacionDao;
import com.ucentral.ejb.PostulacionDetalleDao;
import com.ucentral.entidades.Postulacion;
import com.ucentral.entidades.PostulacionDetalle;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class ServiceAgenda {
   @EJB private PostulacionDao postulacionDao;
   @EJB private PostulacionDetalleDao postulacionDetalleDao;
   
   public void realizarReserva(Postulacion postulacion){
       postulacionDao.realizarPostulacion(postulacion);
   }
   
   public List<Postulacion> getAllListPostulacion(){
       return postulacionDao.getListAll();
   }
   
   public Postulacion findById(String idPostulacion){
       return postulacionDao.findByIdPostulacion(idPostulacion);
   }
   
   public PostulacionDetalle findByIdDetalle(String idPostulacionDetalle){
       return postulacionDetalleDao.findById(idPostulacionDetalle);
   }
   
   public List<PostulacionDetalle> findByFechaDetalles(Date fechaPostulacion,
           String idEstadoPostulacion){
       return postulacionDetalleDao.findByFecha(fechaPostulacion, idEstadoPostulacion);
   }
   
   public List<PostulacionDetalle> findByFechaYHoraDetalle(Date fecha,
           String hora, String idEstadoPostulacion){
       return postulacionDetalleDao.findByFechaYHora(fecha, hora, idEstadoPostulacion);
   }
   
   public List<PostulacionDetalle> findByWeek(Date fechaIni, Date fechaFin,
           String idEstadoPostulacion){
       return postulacionDetalleDao.findByWeek(fechaIni, fechaFin, idEstadoPostulacion);
   }
   
   public List<PostulacionDetalle> findByMonth(Date fechaIni, Date fechaFin,
           String idEstadoPostulacion){
       return postulacionDetalleDao.findByMonth(fechaIni, fechaFin, idEstadoPostulacion);
   }
   
   public void modificarDetallePostultacion(PostulacionDetalle detalle){
       postulacionDetalleDao.modificarPostulacionDetalle(detalle);
   }
}

