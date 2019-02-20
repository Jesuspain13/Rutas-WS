/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esp.apprutas.model.svc.implem;

import esp.apprutas.model.Usuario;
import esp.apprutas.model.dao.UsuarioDao;
import esp.apprutas.model.svc.UsuarioSvc;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Jesús
 */
@Stateless
public class UsuarioSvcImplem implements UsuarioSvc {
    
    @EJB
    private UsuarioDao dao;

    @Override
    public Collection<Usuario> listar() throws Exception {
        try {
            return dao.findAll();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public Usuario filtrarPorId(Integer id) throws Exception {
        try {
            return dao.findById(id);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public Usuario filtrarProNombre(String nombre) throws Exception {
        try {
            return (Usuario) dao.findByName(nombre)
                    .toArray()[0];
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }
    
}
