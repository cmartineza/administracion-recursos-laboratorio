/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.ejb;

import com.ucentral.entidades.Archivo;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import sun.misc.IOUtils;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class ArchivoDao extends GenericDao<Archivo>{
    
    public ArchivoDao(){
        super(Archivo.class);
    }
    
    public void guardarArchivo(Archivo archivo, InputStream inputStream) throws FileNotFoundException{
        BufferedInputStream bfi = new BufferedInputStream(inputStream);
        FileOutputStream fos = new FileOutputStream("");
        
        BufferedOutputStream bfo = new BufferedOutputStream(fos);
        byte [] buf = new byte[1024];
        int len;
        try {
            while((len = bfi.read(buf))>0){
                fos.write(buf,0,len);
            }
            bfi.close();
            fos.close();
            
        } catch (IOException ex) {
            
            Logger.getLogger(ArchivoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        archivo.setNombreReferenciaApl("pruebas");
        super.save(archivo);
    }
    
    public List<Archivo> listaArchivosPorUsuario(String idUsuario){
        Map parameter = new HashMap();
        parameter.put("idUsuario", idUsuario);
        return super.executeQueryListResult(Archivo.findByUsuario, parameter);
    }
    
    public InputStream getStreamArchivo(String idArchivo){
        return null;
    }
}
