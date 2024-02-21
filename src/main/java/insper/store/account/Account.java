package insper.store.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Builder
@Accessors(chain = true, fluent = true)
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Account {
    private String id;
    private String name;
    private String email;
    private String hash;
    private String password;
}
