package insper.store.account;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "account")
@EqualsAndHashCode(of = "id")
@Builder @Getter @Setter @Accessors(chain = true, fluent = true)
@NoArgsConstructor @AllArgsConstructor
public class AccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_account")
    private String id;

    private String name;
    private String email;
    private String hash;

    public AccountModel(Account o){
        this.id = o.id();
        this.name = o.name();
        this.email = o.email();
        this.hash = o.hash();
    }

    public Account to(){
        return new Account()
            .id(this.id)
            .name(this.name)
            .email(this.email)
            .hash(this.hash);
    }
}
