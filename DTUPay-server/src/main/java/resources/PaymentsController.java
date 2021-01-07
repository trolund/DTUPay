package controllers;

import dto.ErrorType;
import dtu.ws.fastmoney.Account;
import services.PaymentsService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("/payments")
public class PaymentsController {

    @Inject
    PaymentsService ps;

    private final static Logger LOGGER = Logger.getLogger(PaymentsController.class.getName());

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response CreateTransaction(@QueryParam("mid") String mid,
                                      @QueryParam("cid") String cid,
                                      @QueryParam("amount") int amount) {
        try {
            ps.createTransaction(mid, cid, amount);

            return Response
                    .status(Response.Status.OK)
                    .build();
        } catch (Exception e){
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorType(e.getMessage()))
                    .build();
        }
    }

    @GET
    @Path("/transactions/{cpr}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransactions(@PathParam("cpr") String cpr) {
        try {
            return Response
                    .status(Response.Status.OK)
                    .entity(ps.getTransactions(cpr))
                    .build();
        } catch (Exception e){
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorType(e.getMessage()))
                    .build();
        }

    }

}
