/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.ws;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.martin.model.Tarea;
import org.martin.service.TareaService;

/**
* @RequestScoped esto es importante en payara
 * @author mdominguez
 */
@Path("/tarea")
@Stateless 
public class TareaResource {

    private static final Logger LOG = Logger.getLogger(TareaResource.class.getName());
    
    @Inject private TareaService service;
    
    @GET
    @Path("/{idTarea}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTarea(@PathParam("idTarea") Integer id){
        LOG.info("Buscar la tarea "+id);
        Tarea t = service.buscarTarea(id);
        LOG.info("Encontro la tarea "+t);
        return Response.ok(t,MediaType.APPLICATION_JSON).build();
    }
       
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarTodas(){
        LOG.info("Buscar todas");
        List<Tarea> todas = service.buscarTodas();
        GenericEntity<List<Tarea>> entityTodas = new GenericEntity<List<Tarea>>(todas) {};

        LOG.info("Encontro la tarea "+todas);
        return Response.ok(entityTodas,MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearTarea(Tarea t){
        LOG.info("Crear la tarea "+t);
        Tarea creada = service.addTarea(t);
        LOG.info("Creo...."+t);
        return Response.ok(creada,MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/{idTarea}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearTarea(@PathParam("idTarea") Integer id,Tarea t){
        LOG.info("Actualizo la tarea "+t+ " (ID: "+id+")");
        Tarea actualizada = service.actualizarTarea(t);
        return Response.ok(actualizada,MediaType.APPLICATION_JSON).build();
    }
    
    @DELETE
    @Path("/{idTarea}")
    public Response borrarTarea(@PathParam("idTarea") Integer id){
        LOG.info("Actualizo la tarea   (ID: "+id+")");
        service.borrarTarea(id);
        return Response.ok("Tarea "+id+" borrada ").build();
    }
    /**
     * @return the service
     */
    public TareaService getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(TareaService service) {
        this.service = service;
    }
}
