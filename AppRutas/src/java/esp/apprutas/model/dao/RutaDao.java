/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esp.apprutas.model.dao;

import esp.apprutas.model.Ruta;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Jesús
 */
@Local
public interface RutaDao {
    
    /**
     * actualizar una ruta
     * @param r
     * @throws Exception 
     */
    public void save(Ruta r) throws Exception;
    
    /**
     * listar todas las rutas
     * @return lista de rutas
     * @throws Exception 
     */
    public Collection<Ruta> findAll() throws Exception;
    
    /**
     * encontrar ruta por id
     * @param id id de la ruta
     * @return ruta cpn id seleccionado
     * @throws Exception 
     */
    public Ruta findById(Integer id) throws Exception;
    
    /**
     * borrar una ruta 
     * @param r ruta a borrar
     * @throws Exception 
     */
    public void delete(Ruta r) throws Exception;
    
    /**
     * actualizar una ruta
     * @param r ruta a actualizar
     * @throws Exception 
     */
    public void update(Ruta r) throws Exception;
}
