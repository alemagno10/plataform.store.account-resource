package insper.store.account;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account in) throws NoSuchAlgorithmException{
        in.hash(calculateHash(in.password()));
        in.password(null);
        return accountRepository.save(new AccountModel(in)).to();
    }

    public Account read(String id){
        return accountRepository.findById(id).map(AccountModel::to).orElse(null);
    }

    public Account login(String email, String password){
        String hash = calculateHash(password);
        return accountRepository.findByEmailAndHash(email, hash).map(AccountModel::to).orElse(null);
    }

    public String calculateHash(String password){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            byte[] encoded = Base64.getEncoder().encode(hash);
            return new String(encoded);
        } catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }

}
