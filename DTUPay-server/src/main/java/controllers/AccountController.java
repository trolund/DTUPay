package controllers;

import dao.Account;
import services.AccountService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/account")
public class AccountController {


    AccountService service = new AccountService();

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public void CreateAccounts(dao.Account account) {
        service.add(account);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public dao.Account getAccount(@PathParam("id") Integer id) {
            return service.get(id);
    }

    @GET
    @Path("cpr/{cpr}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<dao.Account> getAccount(@PathParam("cpr") String cpr) {
        return service.getByCpr(cpr);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteAccount(@PathParam("id") Integer id) {
        service.delete(id);
    }

}
