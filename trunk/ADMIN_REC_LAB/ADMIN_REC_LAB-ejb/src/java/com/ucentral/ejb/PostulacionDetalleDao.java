/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.ejb;

import com.ucentral.entidades.PostulacionDetalle;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class PostulacionDetalleDao extends GenericDao<PostulacionDetalle>{

    public PostulacionDetalleDao(){
        super(PostulacionDetalle.class);
    }
    
    public List<PostulacionDetalle> findByIdPostulacion(String idPostulacion,
            String idEstadoPostulacion){
        Map parameters = new HashMap();
        parameters.put("idEstadoPostulacion",idEstadoPostulacion);
        parameters.put("idPostulacion",idPostulacion);
        return super.executeQueryListResult(PostulacionDetalle.FIND_BY_POSTULACION,
                parameters);
    }
    
    public List<PostulacionDetalle> findByFecha(Date fecha,
            String idEstadoPostulacion){
       Map parameters = new HashMap();
       parameters.put("fechaPostulacion", fecha);
       parameters.put("idEstadoPostulacion",idEstadoPostulacion);
        return super.executeQueryListResult(PostulacionDetalle.FIND_BY_DAY, parameters);
    }
    
    public List<PostulacionDetalle> findByFechaYHora(Date fecha, String hora,
            String idEstadoPostulacion){
       Map parameters = new HashMap();
       parameters.put("fechaPostulacion", fecha);
       parameters.put("hora",hora);
       parameters.put("idEstadoPostulacion",idEstadoPostulacion);
        return super.executeQueryListResult(PostulacionDetalle.FIND_BY_HOUR, parameters);
    }
    
    public List<PostulacionDetalle> findByWeek(Date fechaInicial, Date fechaFinal,
            String idEstadoPostulacion){
        Map parameters = new HashMap();
        parameters.put("fechaInicial",fechaInicial);
        parameters.put("fechaInicial",fechaFinal);
        parameters.put("idEstadoPostulacion",idEstadoPostulacion);
        return super.executeQueryListResult(PostulacionDetalle.FIND_BY_DATE, parameters);
    }
    
    public List<PostulacionDetalle> findByMonth(Date fechaInicial, Date fechaFinal,
            String idEstadoPostulacion){
        Map parameters = new HashMap();
        parameters.put("fechaInicial",fechaInicial);
        parameters.put("fechaInicial",fechaFinal);
        parameters.put("idEstadoPostulacion",idEstadoPostulacion);
        return super.executeQueryListResult(PostulacionDetalle.FIND_BY_DATE, parameters);
    }
    
    public void guardarPostulacionDetalle(PostulacionDetalle postulacionDetalle){
        super.save(postulacionDetalle);
    }
    
    public PostulacionDetalle findById(String idPostulacion){
        return super.find(idPostulacion);
    }
    
    public void modificarPostulacionDetalle(PostulacionDetalle postulacionDetalle){
        super.update(postulacionDetalle);
    }
}
