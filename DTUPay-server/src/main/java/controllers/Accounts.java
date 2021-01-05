package controllers;

import dao.Account;
import services.AccountService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/account")
public class Accounts {

    AccountService service = new AccountService();

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public void CreateAccounts(Account account) {
        service.add(account);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccount(@PathParam("id") Integer id) {
            return service.get(id);
    }


}
