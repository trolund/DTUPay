package controllers;

import services.CustomerService;
import services.MerchantService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserController {

    @Inject
    MerchantService ms;
    @Inject
    CustomerService cs;

    @GET
    @Path("customer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("id") String id) {
        return Response.ok().entity(cs.get(id)).build();
    }

    @GET
    @Path("customers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomer() {
        return Response.ok().entity(cs.getAllCustomers()).build();
    }

    @GET
    @Path("merchant/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMerchant(@PathParam("id") String id) {
        return Response.ok().entity(ms.get(id)).build();
    }

    @GET
    @Path("merchants")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMerchant() {
        return Response.ok().entity(ms.getAllMerchant()).build();
    }

}

