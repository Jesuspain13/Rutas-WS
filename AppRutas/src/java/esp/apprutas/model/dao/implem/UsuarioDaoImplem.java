/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esp.apprutas.model.dao.implem;

import esp.apprutas.model.Usuario;
import esp.apprutas.model.dao.UsuarioDao;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jesús
 */
@Stateless
public class UsuarioDaoImplem implements UsuarioDao {
    
    @PersistenceContext(unitName = "AppRutasPU")
    private EntityManager em;

    @Override
    public Collection<Usuario> findAll() throws Exception {
        try {
            String sql = "SELECT u FROM Usuario u";
            
            return em.createQuery(sql).getResultList();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public Usuario findById(Integer id) throws Exception {
        try {
            return em.find(Usuario.class, id);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public Collection<Usuario> findByName(String name) throws Exception {
        try {
            String sql = "SELECT u FROM Usuario u WHERE u.nombre = ?";
            
            return em.createQuery(sql).setParameter(0, name).getResultList();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }
    
}
