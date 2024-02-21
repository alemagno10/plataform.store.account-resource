package insper.store.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void createAccount(Account in) {
        accountRepository.save(new AccountModel(in)).to();
    }
}
