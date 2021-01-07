package controllers;

import dtu.ws.fastmoney.Account;
import dtu.ws.fastmoney.BankServiceException_Exception;
import dtu.ws.fastmoney.User;
import org.jboss.resteasy.annotations.Body;
import services.AccountService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/account")
public class AccountController {

    AccountService service = new AccountService();

    @POST
    @Consumes("application/json")
    public Response CreateAccounts(User user, @QueryParam("balance") int balance) {
        try {
            service.add(user, balance);
            return Response.ok().build();
        } catch (BankServiceException_Exception e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccount(@PathParam("id") String id) {
        try {
            return Response.ok().entity(service.get(id)).build();
        } catch (BankServiceException_Exception e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }


    @GET
    @Path("cpr/{cpr}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountByCpr(@PathParam("cpr") String cpr) {
        try {
            return Response.ok().entity(service.getByCpr(cpr)).build();
        } catch (BankServiceException_Exception e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAccount(@PathParam("id") String id) {
        try{
            service.delete(id);
            return Response.ok().build();
        }catch (Exception e) {
            return Response.status(500, e.getMessage()).build();
        }
    }



}
