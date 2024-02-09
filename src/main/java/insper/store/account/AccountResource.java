package insper.store.account;

import org.springframework.http.ResponseEntity;

public class AccountResource implements AccountController{
    @Override
    public ResponseEntity<AccountOut> create(AccountIn in) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public ResponseEntity<AccountOut> update(String id, AccountIn in) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
