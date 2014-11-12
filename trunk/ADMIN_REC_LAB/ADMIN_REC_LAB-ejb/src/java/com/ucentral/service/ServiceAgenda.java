/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.service;

import com.ucentral.ejb.PerfilDao;
import com.ucentral.ejb.PostulacionDao;
import com.ucentral.entidades.Postulacion;
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
   
   public void realizarReserva(Postulacion postulacion){
       postulacionDao.realizarPostulacion(postulacion);
   }
}
