package services;

import Exceptions.UserException;
import dao.*;
import repositories.AccountRepository;
import repositories.TransactionRepository;
import repositories.UserRepository;

import javax.ws.rs.QueryParam;
import java.util.Date;

public class PaymentsService {

    TransactionRepository tRepo = new TransactionRepository();
    AccountRepository aRepo = new AccountRepository();
    UserRepository uRepo = new UserRepository();

    public void createTransaction(int mid, int cid, int amount) throws UserException {
        Account m = aRepo.get(mid);
        Account c = aRepo.get(cid);

        User merchant = uRepo.get(m.getUserId());
        User customer = uRepo.get(c.getUserId());

        if(merchant instanceof Merchant && customer instanceof Customer){
            c.setBalance(c.getBalance() - amount);
            m.setBalance(m.getBalance() + amount);
            tRepo.add(new Transaction(amount,
                                    m.getBalance(),
                                    m.getUserId(),
                                    m.getUserId(),
                          "Transaction",
                                    new Date()));
        }else{
            throw new UserException("mid does not belong to merchant or cid does not belong to customer");
        }

    }

}
