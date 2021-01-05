package repositories;

import dao.Account;
import dao.Transaction;
import dao.User;
import repositories.Interfaces.BasicRepository;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class TransactionRepository implements BasicRepository<Transaction, Integer> {

    public Transaction get(Integer id) {
        Data d = Data.getInstance();

        return d.transactions.stream()
                .filter(t -> t.getId() == id)
                .findAny()
                .orElse(null);
    }

    public List<Transaction> getAll() {
        Data d = Data.getInstance();
        return d.transactions;
    }

    public void add(Transaction a){
        Data d = Data.getInstance();

        Transaction toAdd = a;
        toAdd.setId(nextId());

        d.transactions.add(toAdd);
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

    private int nextId(){
        Data d = Data.getInstance();
        Transaction t = d.transactions.stream()
                .max( Comparator.comparing( Transaction::getId ) ).orElse(null);

        if(t == null) {
            return 0;
        }

        return t.getId() + 1;
    }

}
