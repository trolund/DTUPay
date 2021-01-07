package models;

import java.io.Serializable;

public class Customer extends PayUser {

    public Customer() {
    }

    public Customer(String id, String cpr, String firstName, String lastName, int balance) {
        super(id, cpr, firstName, lastName, balance);
    }
}
