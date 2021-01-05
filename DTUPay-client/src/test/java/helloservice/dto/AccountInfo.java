package helloservice.dto;

import helloservice.dao.User;

import java.io.Serializable;

public class AccountInfo implements Serializable {

    public String accountId;
    public User user;
}
