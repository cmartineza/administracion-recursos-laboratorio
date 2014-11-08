/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.ejb;

import com.ucentral.entidades.Perfiles;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class PerfilDao extends GenericDao<Perfiles>{
    public PerfilDao(){
        super(Perfiles.class);
    }
    
    public List<Perfiles> getAllList(){
        return super.findAll();
    }
    
    public Perfiles findById(Object id){
        return super.find(id);
    }
}
