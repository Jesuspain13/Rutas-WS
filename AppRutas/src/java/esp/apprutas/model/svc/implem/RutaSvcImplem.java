/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esp.apprutas.model.svc.implem;

import esp.apprutas.model.svc.RutaSvc;
import esp.apprutas.model.Ruta;
import esp.apprutas.model.dao.RutaDao;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Jesús
 */
@Stateless
public class RutaSvcImplem implements RutaSvc {
    
    @EJB
    private RutaDao dao;

    @Override
    public void guardar(Ruta r) throws Exception {
        try {
            dao.save(r);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public Collection<Ruta> listar() throws Exception {
        try {
            return dao.findAll();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public Ruta filtrarPorId(Integer id) throws Exception {
        try {
            return dao.findById(id);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public void borrar(Ruta r) throws Exception {
        try {
            dao.delete(r);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public void actualizar(Ruta r) throws Exception {
        try {
            dao.update(r);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }
    
}
