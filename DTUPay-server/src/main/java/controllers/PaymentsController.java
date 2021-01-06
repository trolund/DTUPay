package controllers;

import dao.Transaction;
import dto.ErrorType;
import services.PaymentsService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/payments")
public class PaymentsController {

    PaymentsService service = new PaymentsService();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response CreateTransaction(@QueryParam("mid") int mid,
                                      @QueryParam("cid") int cid,
                                      @QueryParam("amount") int amount) {
        try {
            service.createTransaction(mid, cid, amount);
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
    @Path("/transactions")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransactions() {
        try {
            return Response
                    .status(Response.Status.OK)
                    .entity(service.getTransactions())
                    .build();
        } catch (Exception e){
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorType(e.getMessage()))
                    .build();
        }

    }

}
