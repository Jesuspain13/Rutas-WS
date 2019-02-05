/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esp.apprutas.model.dao.implem;

import esp.apprutas.model.Ruta;
import esp.apprutas.model.dao.RutaDao;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jesús
 */
@Stateless
public class RutaDaoImplem implements RutaDao {
    
    @PersistenceContext(unitName = "AppRutasPU")
    private EntityManager em;

    @Override
    public void save(Ruta ruta) {
        try {
            em.persist(ruta);
        } catch (Exception ex) {
            
        }    
    }

    @Override
    public Collection<Ruta> findAll() throws Exception {
        try {
            String sql = "SELECT r FROM Ruta r";
            
            return em.createQuery(sql).getResultList();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public Ruta findById(Integer id) throws Exception {
        try {            
            return em.find(Ruta.class, id);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public void delete(Ruta ruta) throws Exception {
        try {            
            em.remove(ruta);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public void update(Ruta ruta) throws Exception {
        try {            
            em.merge(ruta);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }
    
}
