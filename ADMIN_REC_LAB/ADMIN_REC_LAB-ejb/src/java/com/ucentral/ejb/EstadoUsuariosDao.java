/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.ejb;

import com.ucentral.entidades.EstadoUsuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class EstadoUsuariosDao extends GenericDao<EstadoUsuario>{
    public EstadoUsuariosDao(){
        super(EstadoUsuario.class);
    }
    
    public List<EstadoUsuario> getAllList(){
        return super.findAll();
    }
    
    public EstadoUsuario findById(int idEstado){
        return super.find(idEstado);
    }

}
