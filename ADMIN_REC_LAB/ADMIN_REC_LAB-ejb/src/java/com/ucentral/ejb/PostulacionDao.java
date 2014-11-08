/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.ejb;

import com.ucentral.entidades.EstadosPostulacion;
import com.ucentral.entidades.Postulacion;
import com.ucentral.entidades.PostulacionDetalle;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class PostulacionDao extends GenericDao<Postulacion> {

    @EJB
    PostulacionDetalleDao daoDetallePost;

    public PostulacionDao() {
        super(Postulacion.class);
    }

    private void guardarPostulacion(Postulacion postulacion) {
        super.save(postulacion);
    }

    private void modificarPostulacion(Postulacion postulacion) {
        super.update(postulacion);
    }

    public List<Postulacion> getListAll() {
        return super.findAll();
    }

    public Postulacion findByIdPostulacion(String idPostulacion) {
        return super.find(idPostulacion);
    }

    public void realizarPostulacion(Postulacion postulacion) {
        List<PostulacionDetalle> lista = daoDetallePost
                .findByFecha(postulacion.getPostulacionDetalleList().get(0).getFechaPostulacion(), "1");
        boolean bndVal = false;
        if (lista != null) {
            String horaIni = postulacion.getPostulacionDetalleList().get(0).getHoraInicial();
            String horaFin = postulacion.getPostulacionDetalleList().get(0).getHoraFinal();
            for (int i = 0; i < lista.size() && !bndVal; i++) {
                String horaIniTmp = lista.get(i).getHoraInicial();
                String horaFinal = lista.get(i).getHoraFinal();
                boolean validacion = this.validarHora(horaIni, horaFin, horaIniTmp, horaFinal);
                if(validacion){
                    bndVal = true;
                }
            }
            
            if(!bndVal){
                this.modificarPostulacion(postulacion);
                for(PostulacionDetalle aux: postulacion.getPostulacionDetalleList()){
                    daoDetallePost.update(aux);
                }
                
            }
        } else {
            this.modificarPostulacion(postulacion);
            for(PostulacionDetalle aux: postulacion.getPostulacionDetalleList()){
                    daoDetallePost.update(aux);
                }
        }

    }

    private boolean validarHora(String horaIni, String horaFin, String horaIni2, String horaFin2) {
        int horaInicial = Integer.parseInt(horaIni.split(":")[0]);
        int minutoIni = Integer.parseInt(horaIni.split(":")[1]);

        int horaFinal = Integer.parseInt(horaIni.split(":")[0]);
        int minutoFin = Integer.parseInt(horaIni.split(":")[1]);

        int horaInicial1 = Integer.parseInt(horaIni.split(":")[0]);
        int minutoIni1 = Integer.parseInt(horaIni.split(":")[1]);

        int horaFinal1 = Integer.parseInt(horaIni.split(":")[0]);
        int minutoFinal1 = Integer.parseInt(horaIni.split(":")[1]);
        if ((horaFinal1 - horaInicial1) >= 2) {
            if (horaInicial < horaInicial1 && horaFinal > horaInicial1) {
                return true;
            } else {
                if (horaInicial == horaFinal1) {
                    if (minutoIni < minutoFinal1) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (horaInicial < horaFinal1 && horaFinal > horaFinal1) {
                        return true;
                    } else {
                        if (horaFinal == horaFinal1) {
                            if (minutoIni1 < minutoFin) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        } else {
            return false;
        }
        return false;
    }
}
