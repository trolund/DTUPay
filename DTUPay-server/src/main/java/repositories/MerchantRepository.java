package repositories;

import models.Customer;
import models.Merchant;
import models.PayUser;
import repositories.Interfaces.BasicRepository;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class MerchantRepository implements BasicRepository<Merchant, String> {

    public Merchant get(String id) {
        Data d = Data.getInstance();

        return (Merchant) d.getUsers().stream()
                .filter(customer -> customer instanceof Merchant && customer.getId() == id)
                .findAny()
                .orElse(null);
    }

    public Merchant getByCpr(String cpr) {
        Data d = Data.getInstance();

        return (Merchant) d.getUsers().stream()
                .filter(customer -> customer instanceof Merchant && customer.getCpr() == cpr)
                .findAny()
                .orElse(null);
    }

    public void add(Merchant u){
        Data d = Data.getInstance();
        d.getUsers().add(u);
    }

    public void delete(String id){
        Data d = Data.getInstance();

        d.getUsers().remove(get(id));
    }

    public void update(Merchant customer){
        delete(customer.getId());
        add(customer);
    }

    public List<Merchant> getAll(){
        Stream<PayUser> users = Data.getInstance().getUsers().stream()
                .filter(customer -> customer instanceof Merchant);

        return (List<Merchant>)(List<?>) users.collect(Collectors.toList());
    }

}
