package helloservice.dto;

import helloservice.dao.User;

import java.io.Serializable;

public class CreateAccountData implements Serializable {
    public int balance;
    public User user;
}
