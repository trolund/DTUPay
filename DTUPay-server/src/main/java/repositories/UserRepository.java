package repositories;

import dao.Account;
import dao.Transaction;
import dao.User;
import repositories.Interfaces.BasicRepository;

import java.util.Comparator;

public class UserRepository implements BasicRepository<User, Integer> {

    public User get(Integer id) {
        Data d = Data.getInstance();

        return d.users.stream()
                .filter(user -> user.getUserId() == id)
                .findAny()
                .orElse(null);
    }

    public User getByCpr(String cpr) {
        Data d = Data.getInstance();

        return d.users.stream()
                .filter(user -> user.getCprNumber() == cpr)
                .findAny()
                .orElse(null);
    }

    public void add(User u){
        Data d = Data.getInstance();
        User user = u;
        user.userId = nextId();

        d.users.add(user);
    }

    public void delete(Integer id){
        Data d = Data.getInstance();

        d.users.remove(get(id));
    }

    public void update(User user){
        int id = user.getUserId();

        delete(id);
        add(user);
    }

    private int nextId(){
        Data d = Data.getInstance();
        User u = d.users.stream().max(Comparator.comparingInt(User::getUserId)).orElse(null);

        if(u == null) {
            return 0;
        };
        return u.getUserId() + 1;
    }

}
