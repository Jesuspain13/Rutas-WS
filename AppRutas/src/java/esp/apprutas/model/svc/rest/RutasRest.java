/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esp.apprutas.model.svc.rest;

import esp.apprutas.model.Rutas;
import esp.apprutas.model.svc.RutaSvc;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jesús
 */
@Stateless
@Path("rutas")
public class RutasRest {
    
    @EJB
    private RutaSvc svc;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        try {
            Rutas rutas = new Rutas();
            rutas.setListaRutas(svc.listar());
            // si despues de asignarle la lista la lista de rutas esta vacía
            if (rutas.getListaRutas().isEmpty()) {
                //manda un error 404 recurso no encontrado
                return Response.status(Response.Status.NOT_FOUND).build();
            } else {
                //si no esta vacía (la ha encontrado) encapsula el bojeto y construye la respuesta
                GenericEntity<Rutas> entity = 
                        new GenericEntity(rutas, Rutas.class);
                return Response.ok().entity(entity).build();
            }
        } catch (Exception ex) {
            return Response.serverError().build();
        }
    }
}
