package controllers;

import dao.Account;
import services.AccountService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/account")
public class AccountController {

    AccountService service = new AccountService();

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response CreateAccounts(dao.Account account) {
        service.add(account);
        return Response.ok().build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccount(@PathParam("id") Integer id) {
        return Response.ok().entity(service.get(id)).build();
    }

    @GET
    @Path("cpr/{cpr}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccount(@PathParam("cpr") String cpr) {
        return Response.ok().entity(service.getByCpr(cpr)).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAccount(@PathParam("id") Integer id) {
        try{
            service.delete(id);
            return Response.ok().build();
        }catch (Exception e) {
            return Response.status(500, e.getMessage()).build();
        }
    }

}
