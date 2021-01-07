package services;

import exceptions.TransactionException;
import exceptions.UserException;
import fastmoney.Account;
import fastmoney.BankService;
import fastmoney.BankServiceService;
import fastmoney.Transaction;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.NotFoundException;
import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
public class PaymentsService {

  //  TransactionRepository tRepo = new TransactionRepository();
/*    AccountRepository aRepo = new AccountRepository();
    UserRepository uRepo = new UserRepository();*/
    BankService bs = new BankServiceService().getBankServicePort();

    public void createTransaction(String mid, String cid, int amount) throws UserException, TransactionException {

        try{
            Account m = bs.getAccount(mid);
            Account c = bs.getAccount(cid);

            if(c == null){
                throw new UserException("customer with id " + cid + " is unknown");
            }
            if(m == null) {
                throw new UserException("merchant with id " + mid + " is unknown");
            }

            bs.transferMoneyFromTo(
                    m.getId(),
                    c.getId(),
                    BigDecimal.valueOf(amount),
                    "Transaction");

            Transaction t = new Transaction();
            t.setBalance(c.getBalance());
            t.setAmount(BigDecimal.valueOf(amount));
            t.setDebtor(c.getId());
            t.setCreditor(m.getId());
            t.setDescription("Transaction from " + c.getId() + " to " + m.getId());

        }catch (Exception e) {
                throw new TransactionException("Transaction was not completed. " + e.getMessage(), e);
        }

    }

    public List<Transaction> getTransactions(String cpr) {
        try {
            return bs.getAccountByCprNumber(cpr).getTransactions();
        }catch (Exception e){
            throw new NotFoundException("Account not found");
        }

    }

}
