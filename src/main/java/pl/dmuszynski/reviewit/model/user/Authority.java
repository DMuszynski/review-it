package pl.dmuszynski.reviewit.model.user;

import org.springframework.security.core.GrantedAuthority;
import pl.dmuszynski.reviewit.model.AbstractEntity;

import javax.persistence.*;

@Table(name = "authority")
@Entity
public class Authority extends AbstractEntity implements GrantedAuthority {
    @Enumerated(EnumType.STRING)
    @Column(name = "authority_type")
    private AuthorityType authorityType;

    public Authority(long id, AuthorityType authorityType) {
        super(id);
        this.authorityType = authorityType;
    }

    public Authority(AuthorityType authorityType) {
        this(0L, authorityType);
    }

    protected Authority() { }

    @Override
    public String getAuthority() {
        return this.authorityType.name();
    }
}
