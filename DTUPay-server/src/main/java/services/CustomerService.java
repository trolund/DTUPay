package services;

import models.Customer;
import repositories.CustomerRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class CustomerService {

    @Inject
    CustomerRepository cr;

    public List<Customer> getAllCustomers(){
        return cr.getAll();
    }

    public Customer get(String id){
        return cr.get(id);
    }

    public void add(Customer c){
        cr.add(c);
    }

    public void remove(String id){
        cr.delete(id);
    }

    public void update(Customer c){
        cr.update(c);
    }

}
