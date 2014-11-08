/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.ejb;

import com.ucentral.entidades.TipoDocumento;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class TipoDocumentoDao extends GenericDao<TipoDocumento>{
    public TipoDocumentoDao(){
        super(TipoDocumento.class);
    }
    
    public List<TipoDocumento> getAllList(){
        return super.findAll();
    }
    
    public TipoDocumento findById(int idTipoDocumento){
        return super.find(idTipoDocumento);
    }
}
