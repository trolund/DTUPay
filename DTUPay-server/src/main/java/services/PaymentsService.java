package services;

import Exceptions.UserException;
import dao.*;
import repositories.AccountRepository;
import repositories.TransactionRepository;
import repositories.UserRepository;
import java.util.Date;
import java.util.List;

public class PaymentsService {

    TransactionRepository tRepo = new TransactionRepository();
    AccountRepository aRepo = new AccountRepository();
    UserRepository uRepo = new UserRepository();

    public void createTransaction(int mid, int cid, int amount) throws UserException {

        User merchant = uRepo.get(mid);
        User customer = uRepo.get(cid);

        Account m = aRepo.get(mid);
        Account c = aRepo.get(cid);

        if(merchant instanceof Merchant && customer instanceof Customer){
            c.setBalance(c.getBalance() - amount);
            m.setBalance(m.getBalance() + amount);
            tRepo.add(new Transaction(amount,
                                    m.getBalance(),
                                    m.getUserId(),
                                    c.getUserId(),
                          "Transaction",
                                    new Date()));
        }else{
            if(merchant instanceof Merchant){
                throw new UserException("customer with id " + cid + " is unknown");
            }else {
                throw new UserException("merchant with id " + mid + " is unknown");
            }
        }
    }

    public List<Transaction> getTransactions() {
        return tRepo.getAll();
    }

}
