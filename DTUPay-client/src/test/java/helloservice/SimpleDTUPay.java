package helloservice;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class SimpleDTUPay {

    WebTarget baseUrl;

    public SimpleDTUPay() {
        Client client = ClientBuilder.newClient();
        baseUrl = client.target("http://localhost:8080/");
    }

    public boolean pay(int amount, String cid, String mid) {
        baseUrl.path("pay").request().get(String.class);
        return true;
    }

}
