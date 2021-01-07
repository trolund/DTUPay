package services;

import fastmoney.*;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
public class AccountService {

    BankService bs = new BankServiceService().getBankServicePort();

    public List<AccountInfo> all() {
        return bs.getAccounts();
    }

    public Account get(String id) throws BankServiceException_Exception {
        return bs.getAccount(id);
    }

    public Account getByCpr(String cpr) throws BankServiceException_Exception {
        return bs.getAccountByCprNumber(cpr);
    }

    public void add(User user, int balance) throws BankServiceException_Exception {
        bs.createAccountWithBalance(user, BigDecimal.valueOf(balance));
    }

    public void delete(String id) throws BankServiceException_Exception {
        bs.retireAccount(id);
    }

    public boolean accountExits(String cpr) {
        try {
            return bs.getAccountByCprNumber(cpr) != null;
        } catch (BankServiceException_Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isConnected() {
        if(bs == null){
            bs = new BankServiceService().getBankServicePort();
        }

        return bs.getAccounts() != null;
    }

}

