package pl.dmuszynski.reviewitapi.model.user;

import org.springframework.security.core.GrantedAuthority;
import pl.dmuszynski.reviewitapi.model.AbstractEntity;

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
