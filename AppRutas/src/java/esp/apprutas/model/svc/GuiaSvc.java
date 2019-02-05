/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esp.apprutas.model.svc;

import esp.apprutas.model.Guia;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Jesús
 */
@Local
public interface GuiaSvc {
    
    /**
     * guardar nuevo guia
     * @param guia guia a guardar
     * @throws Exception 
     */
    public void guardar(Guia g) throws Exception;
    
    /**
     * listar todos los guias
     * @return
     * @throws Exception 
     */
    public Collection<Guia> listar()throws Exception;
    
    /**
     * encontrar guia por id
     * @param id id a encontrar
     * @return guia con el id del parametro
     * @throws Exception 
     */
    public Guia filtrarPorId(Integer id) throws Exception;
    
    /**
     * borrar un guia
     * @param g guia a borrar
     * @throws Exception 
     */
    public void borrar(Guia g) throws Exception;
    
    /**
     * actualizar un guia
     * @param g guia a actualizar
     * @throws Exception 
     */
    public void actualizar(Guia g) throws Exception;
}
