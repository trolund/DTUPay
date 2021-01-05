package controllers;

import services.PaymentsService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/Payments")
public class PaymentsController {

    @Context
    HttpServletRequest request;
    @Context
    HttpServletResponse response;

    PaymentsService service = new PaymentsService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void CreateTransaction(@QueryParam("mid") int mid,
                                  @QueryParam("mid") int cid,
                                  @QueryParam("amount") int amount) {
        try {
            service.createTransaction(mid, cid, amount);
            response.setStatus(203);
        } catch (Exception e){
            response.setStatus(500);
        }

    }



}
