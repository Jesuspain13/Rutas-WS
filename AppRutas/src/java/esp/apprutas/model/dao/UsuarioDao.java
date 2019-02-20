/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esp.apprutas.model.dao;

import esp.apprutas.model.Usuario;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Jesús
 */
@Local
public interface UsuarioDao {

    /**
     * listar todos los guias
     * @return
     * @throws Exception 
     */
    public Collection<Usuario> findAll() throws Exception;
    
    /**
     * encontrar guia por id
     * @param id id a encontrar
     * @return guia con el id del parametro
     * @throws Exception 
     */
    public Usuario findById(Integer id) throws Exception;

    /**
     * encontrar guia por nombre
     * @param name nombre a encontrar
     * @return guia con el nombre del parametro
     * @throws Exception 
     */
    public Collection<Usuario> findByName(String name) throws Exception;
}
