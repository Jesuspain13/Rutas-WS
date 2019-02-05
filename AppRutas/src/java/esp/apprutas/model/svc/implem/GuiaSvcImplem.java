/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esp.apprutas.model.svc.implem;

import esp.apprutas.model.svc.GuiaSvc;
import esp.apprutas.model.Guia;
import esp.apprutas.model.dao.GuiaDao;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Jesús
 */
@Stateless
public class GuiaSvcImplem implements GuiaSvc{
    
    @EJB
    private GuiaDao dao;

    @Override
    public void guardar(Guia g) throws Exception {
        try {
            dao.save(g);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public Collection<Guia> listar() throws Exception {
        try {
            return dao.findAll();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public Guia filtrarPorId(Integer id) throws Exception {
        try {
            return dao.findById(id);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public void borrar(Guia g) throws Exception {
        try {
            dao.delete(g);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public void actualizar(Guia g) throws Exception {
        try {
            dao.update(g);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }
    
}
