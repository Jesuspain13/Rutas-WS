/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esp.apprutas.model.dao.implem;

import esp.apprutas.model.Guia;
import esp.apprutas.model.dao.GuiaDao;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jesús
 */
@Stateless
public class GuiaDaoImplem implements GuiaDao{
    
    @PersistenceContext(unitName = "AppRutasPU")
    private EntityManager em;

    @Override
    public void save(Guia guia) {
        try {
            em.persist(guia);
        } catch (Exception ex) {
            
        }
    }

    @Override
    public Collection<Guia> findAll() throws Exception {
        try {
            String sql = "SELECT g FROM Guia g";
            
            return em.createQuery(sql).getResultList();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public Guia findById(Integer id) throws Exception {
        try {            
            return em.find(Guia.class, id);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public void delete(Guia guia) throws Exception {
        try {            
            em.remove(guia);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public void update(Guia guia) throws Exception {
        try {            
            em.merge(guia);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }
    
    
}
