package helloservice;

import helloservice.dao.Transaction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleDTUPaySteps {
    int cid, mid;
    int amount;
    SimpleDTUPay dtuPay = new SimpleDTUPay();
    boolean successful;
    List<Transaction> transactions;

    @Given("a customer with id {int}")
    public void aCustomerWithId(int cid) {
        this.cid = cid;
    }
    @Given("a merchant with id {int}")
    public void aMerchantWithId(int mid) {
        this.mid = mid;
    }
    @When("the merchant initiates a payment for {int} kr by the customer")
    public void theMerchantInitiatesAPaymentForKrByTheCustomer(int amount) {
        successful = dtuPay.pay(amount, cid, mid);
    }
    @Then("the payment is successful")
    public void thePaymentIsSuccessful() {
        assertTrue(successful);
    }

    @Given("a successful payment of {int} kr from customer {int} to merchant {int}")
    public void givenTrans(int amount, int cid, int mid) {
        this.cid = cid;
        this.mid = mid;
        this.amount = amount;
    }

    @When("the manager asks for a list of transactions")
    public void asksForTransactionList() {
        this.transactions = dtuPay.getTransactionList();
    }

    @Then("the list contains a transaction where customer {int} paid {int} kr to merchant {int}")
    public void assertTansasctions(int cid, int amount, int mid) {
        assertTrue(!this.transactions.stream().filter(x -> x.amount == amount).findAny().isEmpty());
    }
}