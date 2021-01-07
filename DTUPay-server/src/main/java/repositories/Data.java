package repositories;

import fastmoney.BankServiceException_Exception;
import fastmoney.User;
import models.Customer;
import models.Merchant;
import models.PayUser;
import services.AccountService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Data {

    private List<PayUser> users;

    @Inject
    AccountService as = new AccountService();

    public List<PayUser> getUsers() {
        return users;
    }

    private static Data single_instance = null;

    private Data()
    {
        setData();
        try {
            createAccunts();
        } catch (BankServiceException_Exception e) {
            e.printStackTrace();
        }
    }

    // static method to create instance of Singleton class
    public static Data getInstance()
    {
        if (single_instance == null)
            single_instance = new Data();

        return single_instance;
    }

    private void setData() {
        users = new ArrayList<>();

        // String id, String cpr, String firstName, String lastName, int balance

        Customer u1 = new Customer("c1","061094xxxx", "Troels", "Lund", 200);
        Customer u2 = new Customer("c2","061095xxxx", "Emil", "Lund", 200);
        Merchant u3 = new Merchant("m1","0610980xxxx", "Erik", "Lund", 200);

        users.add(u1);
        users.add(u2);
        users.add(u3);
    }

    private void createAccunts() throws BankServiceException_Exception {
        for (PayUser c: users) {
            makeAccount(c.getCpr(), c.getFirstName(), c.getLastName(), c.getBalance());
        }
    }

    private void makeAccount(String cpr, String firstName, String lastName, int balance) throws BankServiceException_Exception {
        if(!as.accountExits(cpr)){
            User u = new User();
            u.setCprNumber(cpr);
            u.setFirstName(firstName);
            u.setLastName(lastName);

            as.add(u, balance);
        }
    }

}
