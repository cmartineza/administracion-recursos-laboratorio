/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.ejb;

import com.ucentral.entidades.ProfesorHasEstudiante;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class ProfesorHasEstudianteDao extends GenericDao<ProfesorHasEstudiante>{
    public ProfesorHasEstudianteDao(){
        super(ProfesorHasEstudiante.class);
    }
    
    public void guardar(ProfesorHasEstudiante relacionEstudianteProf){
        super.save(relacionEstudianteProf);
    }
    
    public ProfesorHasEstudiante buscarFindById(Object idRegistro){
        return super.find(idRegistro);
    }
    
    public ProfesorHasEstudiante buscarProfesorHasEstudiante(Object idProfesor, 
            Object idEstudiante){
        Map parameters = new HashMap();
        parameters.put("idProfesor", idProfesor);
        parameters.put("idEstudiante", idEstudiante);
        return super.findOneResult(ProfesorHasEstudiante.FIND_BY_PROF_ESTU, parameters);
    
    }
}
