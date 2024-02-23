package insper.store.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class AccountResource implements AccountController{

    @Autowired
    AccountService accountService;

    @Override
    public ResponseEntity<AccountOut> create(AccountIn in) {
        Account acc = AccountParser.to(in);
        return ResponseEntity.created(
            ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(acc.id())
                .toUri())
            .body(AccountParser.to(acc));
    }

    @Override
    public ResponseEntity<AccountOut> update(String id, AccountIn in) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public ResponseEntity<AccountOut> login(Login in) {
        Account acc = accountService.login(in.email(), in.password());
        return acc == null ? ResponseEntity.status(HttpStatus.FORBIDDEN).build() : ResponseEntity.ok(AccountParser.to(acc));
    }
}
