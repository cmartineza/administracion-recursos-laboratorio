/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.ejb;

import com.ucentral.entidades.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/** 
 *
 * @author MARA
 */

@Stateless
public class UsuarioDao extends GenericDao<Usuario>{    
    public UsuarioDao(){
        super(Usuario.class);
    }
    
    public Usuario login(int idUsuario, String contrasena){
        Map parameter =  new HashMap();
        parameter.put("id", idUsuario);
        parameter.put("pass", contrasena);
        return super.findOneResult(Usuario.queryLogin, parameter);
    }
    
    public List<Usuario> getListUsuarios(){
        return super.findAll();
    }
    
    public Usuario find(Object idUsuario){
        return super.find(idUsuario);
    }
    
    public List<Usuario> findByNames(String valorConsulta, int tipoConsulta) throws Exception{
        
       Map parameter = new HashMap();
       parameter.put("param", "%"+valorConsulta+"%");
       String query =  "";
      switch(tipoConsulta){
           case 2:query = Usuario.findByNombre;
               break;
           case 3:query = Usuario.findByApellido1;
               break;
           case 4:query = Usuario.findByApellido2;
               break;
           default:
               throw new Exception("Tipo de consulta no valida "+tipoConsulta);
      }
      
      return super.executeQueryListResult(query, parameter);
    }
    
    public void crear(Usuario usuario){
        super.save(usuario);
    }
    
    public void modificar(Usuario usuario){
        super.update(usuario);
    }
    
    public void eliminar(Usuario usuario){
        super.delete(usuario);
    }
    
    public List<Usuario> buscarPorEstado(int idEstado){
        Map parameter = new HashMap();
        parameter.put("estado", idEstado);
        return super.executeQueryListResult(Usuario.buscarPorEstado, parameter);
    }
}
