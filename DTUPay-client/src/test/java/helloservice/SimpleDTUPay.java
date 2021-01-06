package helloservice;

import helloservice.dao.Transaction;
import helloservice.dto.ErrorType;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

public class SimpleDTUPay {

    WebTarget baseUrl;

    public SimpleDTUPay() {
        Client client = ClientBuilder.newClient();
        baseUrl = client.target("http://localhost:8080/");
    }

    public String pay(int amount, int cid, int mid) {
        Response r = baseUrl.path("payments").queryParam("cid", cid)
                                .queryParam("mid", mid)
                                .queryParam("amount", amount)
                                .request().post(null);

        if(r.getStatus() == 200) {
            return null;
        }else {
            return r.readEntity(new GenericType<ErrorType>() {}).errorMessage;
        }

    }

    public List<Transaction> getTransactionList() {
        Response r = baseUrl.path("payments/transactions").request().get();

        return r.readEntity(new GenericType<List<Transaction>>() {});
    }
}
