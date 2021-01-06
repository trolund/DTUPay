package services;

import dao.Account;
import repositories.AccountRepository;
import repositories.Data;

import javax.ws.rs.NotFoundException;
import java.util.List;

public class AccountService {

    AccountRepository repo = new AccountRepository();

    public Account get(Integer id) {
        Account a = repo.get(id);

        return a;
    }

    public List<Account> getByCpr(String cpr) {
        return repo.getByCpr(cpr);
    }

    public void add(Account a){
        repo.add(a);
    }

    public void delete(Integer id){
        repo.delete(id);
    }

    public void update(Account a){
        repo.update(a);
    }


}
