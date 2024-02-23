package insper.store.account;

public class AccountParser {
    public static Account to(AccountIn in){
        return new Account()
            .email(in.email())
            .name(in.name())
            .password(in.password());
    }

    public static AccountOut to(Account acc){
        return AccountOut.builder()
            .id(acc.id())
            .email(acc.email())
            .name(acc.name())
            .build();
    }
}
