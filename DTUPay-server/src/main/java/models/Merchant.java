package models;

import java.io.Serializable;

public class Merchant extends PayUser  {

    public Merchant() {
    }

    public Merchant(String id, String cpr, String firstName, String lastName, int balance) {
        super(id, cpr, firstName, lastName, balance);
    }
}