package ro.sda.booking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.booking.core.entity.Client;
import ro.sda.booking.core.service.ClientService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Service
@Path("/client")
public class ClientRestService {

    @Autowired
    private ClientService clientService;

    @Path("/find-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> findAll(){
        return clientService.findAll();
    }

    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Client getClient(@PathParam("id") long id){
        return clientService.getClientById(id);
    }

    @Path("/find")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Client getClient(@QueryParam("name") String name){
        return clientService.getClientByName(name);
    }


    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public void deleteClient(@QueryParam("clientId") long id){
        Client c = clientService.getClientById(id);
        clientService.delete(c);
    }

    @Path("/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Client create(Client client){
        return clientService.create(client);
    }

    @Path("/update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Client update(Client client){
        return clientService.update(client);
    }
}
