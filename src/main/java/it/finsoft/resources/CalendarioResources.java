package it.finsoft.resources;

import java.util.List;

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
import javax.ws.rs.core.MediaType;

import it.finsoft.entity.Calendario;
import it.finsoft.manager.CalendarioManager;

@Stateless
@Path("resources/calendari")
@Produces(MediaType.APPLICATION_JSON)
public class CalendarioResources {
	
	@Inject
	CalendarioManager manager;
	
    @GET
    public List<Calendario> findAll() {
        return manager.findAll();
    }
    
    @GET
    @Path("{id}")
    public Calendario findById(@PathParam("id") long id) {
        return manager.findById(id);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long id) {
    	manager.remove(id);
    }
    @POST
    @Path("crea")
    @Consumes(MediaType.APPLICATION_JSON)
    public Calendario create(Calendario c) {
        return manager.save(c);
    }

    @PUT
    @Path("{id}")
    public void update(@PathParam("id") long id, Calendario c) {
        c.setIdCalendario(id);
        manager.save(c);
    }

}