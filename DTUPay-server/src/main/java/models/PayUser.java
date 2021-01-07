package models;

import java.io.Serializable;

public class PayUser implements Serializable {

    private String id;
    private String cpr;
    private String firstName;
    private String lastName;
    private int balance;

    public PayUser() {

    }

    public PayUser(String id, String cpr, String firstName, String lastName, int balance) {
        this.id = id;
        this.cpr = cpr;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
