/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.service;

import com.ucentral.ejb.EstadoUsuariosDao;
import com.ucentral.ejb.PerfilDao;
import com.ucentral.ejb.ProfesorHasEstudianteDao;
import com.ucentral.ejb.TipoDocumentoDao;
import com.ucentral.entidades.Usuario;
import com.ucentral.ejb.UsuarioDao;
import com.ucentral.entidades.EstadoUsuario;
import com.ucentral.entidades.Perfiles;
import com.ucentral.entidades.ProfesorHasEstudiante;
import com.ucentral.entidades.TipoDocumento;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author MARA
 */
@LocalBean
@Stateless
public class ServiceUsuario {
    private @EJB UsuarioDao daoUsuario;
    private @EJB TipoDocumentoDao daoTipoDoc;
    private @EJB PerfilDao daoPerfil;
    private @EJB EstadoUsuariosDao daoEstadoUsuario;
    private @EJB ProfesorHasEstudianteDao daoProfEstu;
    
    public Usuario validarUsuario(String idUsuario, String contrasena){
      return daoUsuario.login(idUsuario, contrasena);
    }
    
    public List<Usuario> listaUsuarios(){
       return daoUsuario.getListUsuarios();
    }
    
    public List<Usuario> findByNombreUsuario(String valorConsulta, int consulta) throws Exception{
        return daoUsuario.findByNames(valorConsulta, consulta);
    }
    
    public Usuario findByIdUsuario(String id){
        return daoUsuario.find(id);
    }
    
     public void crearUsuario(Usuario usuario){
        daoUsuario.crear(usuario);
    }
    
    public void modificarUsuario(Usuario usuario){
        daoUsuario.modificar(usuario);
    }
    
    public void eliminarUsuario(Usuario usuario){
        daoUsuario.eliminar(usuario);
    }
    
    public List<Usuario> buscarPorEstado(int idEstado){
        return daoUsuario.buscarPorEstado(idEstado);
    }
    
    public List<TipoDocumento> listTipoDoc(){
        return daoTipoDoc.getAllList();
    }
    
    public TipoDocumento findTipoDocById(int idTipoDoc){
        return daoTipoDoc.findById(idTipoDoc);
    }
    
    public List<Perfiles> listPerfil(){
        return daoPerfil.getAllList();
    }
    
    public Perfiles findPerfilesById(Object idTipoDoc){
        return daoPerfil.findById(idTipoDoc);
    }
    
    public List<EstadoUsuario> getAllListEstado(){
        return daoEstadoUsuario.getAllList();
    }
    
    public void guardarRelacionProfesorEstudiante(ProfesorHasEstudiante relacion){
        daoProfEstu.guardar(relacion);
    }
    
    public ProfesorHasEstudiante buscarRelacionEstudianteProfesor(
            String idProfesor, String idEstudiante){
        return daoProfEstu.buscarProfesorHasEstudiante(idProfesor, idEstudiante);
    }
}
