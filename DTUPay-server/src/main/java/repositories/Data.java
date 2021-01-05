package repositories;

import dao.Account;
import dao.Transaction;
import dao.User;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public List<User> users;
    public List<Transaction> transactions;
    public List<Account> accounts;

    private static Data single_instance = null;

    // private constructor restricted to this class itself
    private Data()
    {
        setData();
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

        User u1 = new User("061094xxxx", "Troels", "Lund");
        User u2 = new User("061095xxxx", "Emil", "Lund");
        User u3 = new User("061096xxxx", "Lars", "Karlson");

        users.add(u1);
        users.add(u2);
        users.add(u3);

        accounts = new ArrayList<>();

        accounts.add(new Account(0, 200, u1.cprNumber));
        accounts.add(new Account(1, 250, u2.cprNumber));
        accounts.add(new Account(2, 2000, u2.cprNumber));
        accounts.add(new Account(3, 400, u3.cprNumber));
        accounts.add(new Account(4, 100, u3.cprNumber));

        transactions = new ArrayList<>();
    }

}
