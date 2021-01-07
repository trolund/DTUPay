package repositories;

import models.Customer;
import models.Merchant;
import models.PayUser;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import repositories.Interfaces.BasicRepository;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class CustomerRepository implements BasicRepository<Customer, String> {

    public Customer get(String id) {
        Data d = Data.getInstance();

        return (Customer) d.getUsers().stream()
                .filter(customer -> customer instanceof Customer && customer.getId() == id)
                .findAny()
                .orElse(null);
    }

    public Customer getByCpr(String cpr) {
        Data d = Data.getInstance();

        return (Customer) d.getUsers().stream()
                .filter(customer -> customer instanceof Customer && customer.getCpr() == cpr)
                .findAny()
                .orElse(null);
    }

    public void add(Customer u){
        Data d = Data.getInstance();
        d.getUsers().add(u);
    }

    public void delete(String id){
        Data d = Data.getInstance();

        d.getUsers().remove(get(id));
    }

    public void update(Customer customer){
        delete(customer.getId());
        add(customer);
    }

    public List<Customer> getAll(){
        List<PayUser> users = Data.getInstance().getUsers().stream()
                .filter(customer -> customer instanceof Customer).collect(Collectors.toList());;

        return (List<Customer>)(List<?>) users;
    }

}
