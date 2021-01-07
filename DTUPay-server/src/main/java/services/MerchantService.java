package services;

import models.Merchant;
import repositories.MerchantRepository;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class MerchantService {

    @Inject
    MerchantRepository cr;

    public List<Merchant> getAllMerchant(){
        return cr.getAll();
    }

    public Merchant get(String id){
        return cr.get(id);
    }

    public void add(Merchant c){
        cr.add(c);
    }

    public void remove(String id){
        cr.delete(id);
    }

    public void update(Merchant c){
        cr.update(c);
    }
}
