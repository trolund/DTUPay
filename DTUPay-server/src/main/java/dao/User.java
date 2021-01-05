package dao;

public class User {

    public String cprNumber;
    public String firstName;
    public String lastName;

    public User(String cprNumber, String firstName, String lastName) {
        this.cprNumber = cprNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getCprNumber() {
        return cprNumber;
    }

    public void setCprNumber(String cprNumber) {
        this.cprNumber = cprNumber;
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
}
