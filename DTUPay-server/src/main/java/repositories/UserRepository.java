package repositories;

import dao.Account;
import dao.Transaction;
import dao.User;
import repositories.Interfaces.BasicRepository;

public class UserRepository implements BasicRepository<User, String> {

    public User get(String cpr) {
        Data d = Data.getInstance();

        return d.users.stream()
                .filter(user -> user.getCprNumber() == cpr)
                .findAny()
                .orElse(null);
    }

    public void add(User a){
        Data d = Data.getInstance();

        d.users.add(a);
    }

    public void delete(String cpr){
        Data d = Data.getInstance();

        d.users.remove(get(cpr));
    }

    public void update(User user){
        String cpr = user.getCprNumber();

        delete(cpr);
        add(user);
    }

}
