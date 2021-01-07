/*
package repositories;

import fastmoney.Account;
import repositories.Interfaces.BasicRepository;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class AccountRepository implements BasicRepository<Account, Integer> {

    public Account get(Integer id) {
        Data d = Data.getInstance();

       */
/* Account a = d.accounts.stream()
                .filter(account -> account.getId() == id)
                .findAny()
                .orElse(null);*//*


        return a;
    }

    public void add(Account a){
        Data d = Data.getInstance();

        d.accounts.add(a);
    }

    public List<Account> getByCpr(String cpr) {
        Data d = Data.getInstance();

        List<Account> a = d.accounts.stream()
                .filter(account -> account.getUserId().equals(cpr)).collect(Collectors.toList());

        if (a != null){
            return a;
        }

        throw new NotFoundException("Account not found");
    }

    public void delete(Integer id){
        Data d = Data.getInstance();

        Account a = get(id);

        if(a != null){
            d.accounts.remove(a);
        }

        throw new NotFoundException("Account not found");
    }

    public void update(Account a){
        int id = a.getId();

        delete(id);
        add(a);
    }

}
*/
