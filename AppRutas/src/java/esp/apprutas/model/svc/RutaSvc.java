/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esp.apprutas.model.svc;

import esp.apprutas.model.Ruta;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Jesús
 */
@Local
public interface RutaSvc {
    
    /**
     * guardar una ruta
     * @param r ruta a guardar
     * @throws Exception 
     */
    public void guardar(Ruta r) throws Exception;
    
    /**
     * listar todas las rutas
     * @return lista de rutas
     * @throws Exception 
     */
    public Collection<Ruta> listar()throws Exception;
    
    /**
     * encontrar ruta por id
     * @param id id de la ruta
     * @return ruta cpn id seleccionado
     * @throws Exception 
     */
    public Ruta filtrarPorId(Integer id) throws Exception;
    
    /**
     * borrar una ruta 
     * @param r ruta a borrar
     * @throws Exception 
     */
    public void borrar(Ruta r) throws Exception;
    
    /**
     * actualizar una ruta
     * @param r ruta a actualizar
     * @throws Exception 
     */
    public void actualizar(Ruta r) throws Exception;
}
