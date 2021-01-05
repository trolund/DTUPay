package dto;

import dao.User;

import java.io.Serializable;

public class CreateAccountData implements Serializable {
    public int balance;
    public User user;
}
