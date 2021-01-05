package repositories;

import dao.Account;
import dao.Transaction;
import dao.User;
import repositories.Interfaces.BasicRepository;

public class TransactionRepository implements BasicRepository<Transaction, Integer> {

    public Transaction get(Integer id) {
        Data d = Data.getInstance();

        return d.transactions.stream()
                .filter(t -> t.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void add(Transaction a){
        Data d = Data.getInstance();

        d.transactions.add(a);
    }

    public void delete(Integer id){
        Data d = Data.getInstance();

        d.transactions.remove(get(id));
    }

    public void update(Transaction t){
        int id = t.getId();

        delete(id);
        add(t);
    }

}
