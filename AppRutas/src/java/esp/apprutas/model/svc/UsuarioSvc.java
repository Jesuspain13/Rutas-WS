/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esp.apprutas.model.svc;

import esp.apprutas.model.Usuario;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Jesús
 */
@Local
public interface UsuarioSvc {
    
    /**
     * listar todos los usuarios
     * @return
     * @throws Exception 
     */
    public Collection<Usuario> listar()throws Exception;
    
    /**
     * encontrar guia por id
     * @param id id a encontrar
     * @return usuario con el id del parametro
     * @throws Exception 
     */
    public Usuario filtrarPorId(Integer id) throws Exception;
    
    /**
     * encontrar guia por nombre
     * @param nombre nombre a encontrar
     * @return usuario con el nombre del parametro
     * @throws Exception 
     */
    public Usuario filtrarProNombre(String nombre) throws Exception;
}
