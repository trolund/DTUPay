package helloservice;

import helloservice.dao.Transaction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleDTUPaySteps {
    String cid, mid;
    int amount;
    SimpleDTUPay dtuPay = new SimpleDTUPay();
    boolean successful;
    List<Transaction> transactions;
    String errorMsg;

    @Given("a customer with id {int}")
    public void aCustomerWithId(String cid) {
        this.cid = cid;
    }
    @Given("a merchant with id {int}")
    public void aMerchantWithId(String mid) {
        this.mid = mid;
    }
    @When("the merchant initiates a payment for {int} kr by the customer")
    public void theMerchantInitiatesAPaymentForKrByTheCustomer(int amount) {
        String msg = dtuPay.pay(amount, cid, mid);
        if(msg == null){
            successful = true;
        }else {
            successful = false;
            errorMsg = msg;
        }
    }

    @Then("the payment is successful")
    public void thePaymentIsSuccessful() {
        assertTrue(successful);
    }

    @Given("a successful payment of {int} kr from customer {string} to merchant {string}")
    public void givenTrans(int amount, String cid, String mid) {
        this.cid = cid;
        this.mid = mid;
        this.amount = amount;
    }

    @When("the manager asks for a list of transactions")
    public void asksForTransactionList() {
        this.transactions = dtuPay.getTransactionList(this.cid);
    }

    @Then("the list contains a transaction where customer {int} paid {int} kr to merchant {int}")
    public void assertTansasctions(int cid, int amount, int mid) {
        assertTrue(!this.transactions.stream().filter(x -> x.amount == amount).findAny().isEmpty());
    }

    @Then("the payment is not successful")
    public void faildPayment (){
        assertFalse(successful);
    }

    @And("an error message is returned saying {string}")
    public void checkErrorMsg(String msg) {
        assertEquals(msg, errorMsg);
    }
}