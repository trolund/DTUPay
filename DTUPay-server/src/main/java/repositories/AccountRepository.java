package repositories;

import dao.Account;
import repositories.Interfaces.BasicRepository;

public class AccountRepository implements BasicRepository<Account, Integer> {

    public Account get(Integer id) {
        Data d = Data.getInstance();

        return d.accounts.stream()
                .filter(account -> account.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void add(Account a){
        Data d = Data.getInstance();

        d.accounts.add(a);
    }

    public void delete(Integer id){
        Data d = Data.getInstance();

        d.accounts.remove(get(id));
    }

    public void update(Account a){
        int id = a.getId();

        delete(id);
        add(a);
    }

}
