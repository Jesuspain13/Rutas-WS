/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esp.apprutas.model.svc.rest;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import esp.apprutas.model.Usuario;
import esp.apprutas.model.svc.UsuarioSvc;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jesús
 */
public class FiltroAutenticacion implements ContainerRequestFilter{
    
    @Context
    private ResourceInfo resourceInfo;
    
    @EJB
    private UsuarioSvc svc;
    
            
    private static final String AUTHORIZATION_PROPERTY = "Authorization";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Method method = resourceInfo.getResourceMethod();
        //si no hay anotación sobre quien tiene permiso
        if( !method.isAnnotationPresent(PermitAll.class)) {
            
            //si el acceso está denegado para todos
            if( method.isAnnotationPresent(DenyAll.class)) {
                requestContext.abortWith(Response.status(Response.Status.FORBIDDEN)
                .entity("Access blocked for all users!").build());
                return;
            }
            MultivaluedMap<String, String> cabecerasPeticion = requestContext
                    .getHeaders();
            
            List<String> autorizacion = cabecerasPeticion.get(this.AUTHORIZATION_PROPERTY);
            
            if( autorizacion == null || autorizacion.isEmpty()) {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                .entity("you cannot access this resource").build());
                return;
            }
            
            //coge el usuario y la contraseña (viene codificada en base 64)
            String encodedUserAndPassword = autorizacion.get(0)
                    .replaceFirst(AUTHORIZATION_PROPERTY + " ", "");
            
            //decodifica el usuario y la contraseña
            try {
                String usernameAndPassword = new String(Base64.decode(encodedUserAndPassword.getBytes()));
                
                //separa el usuario y la contraseña
                StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
                String usuario = tokenizer.nextToken();
                String contraseña = tokenizer.nextToken();
                
                //verificar si tiene acceso
                if (method.isAnnotationPresent(RolesAllowed.class)) {
                    RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
                    Set<String> ConjuntoRoles = new HashSet<String>(Arrays.asList((rolesAnnotation.value())));
                    
                    //es valido el usuario
                    if ( ! this.isUserAllowed(usuario, contraseña, ConjuntoRoles)) {
                        requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                        .entity("You cannot access this resource").build());
                    }
                }
            }
            catch (Exception ex) {
                throw new IOException(ex);
            }
            
        }
        
    }
    
    private boolean isUserAllowed(String username, String password, Set<String> rolesSet) throws Exception {
        boolean isAllowed = false;
        try {
            Usuario usuarioAComprobar = svc.filtrarProNombre(username);
    
            if (usuarioAComprobar == null) {
                System.out.println("Usuario no hencontrado");
                //si se ha encontrado el usuario con el nombre
            } else {
                //con la busqueda se ha comprobado el nombre, ahora se comprueba la contraseña
                if (password.equals(usuarioAComprobar.getContraseña())) {
                    //comprobar la autorizacion
                    if (rolesSet.contains(usuarioAComprobar.getAutorizacion())) {
                        isAllowed = true;
                    }
                }
            }
            return isAllowed;
        } catch (Exception ex){
            throw new Exception(ex);
        }
    }    
}
