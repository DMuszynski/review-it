package pl.dmuszynski.reviewit.model.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.dmuszynski.reviewit.model.AbstractEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Table(name = "user")
@Entity
public class User extends AbstractEntity implements UserDetails {
    @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "is_locked")
    private boolean isLocked;
    @Column(name = "is_enabled")
    private boolean isEnabled;
    @Column(name = "is_account_expired")
    private boolean isAccountExpired;
    @Column(name = "is_credentials_expired")
    private boolean isCredentialsExpired;
    @ManyToMany
    @JoinTable(name = "user_authority",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private Set<Authority> authorities = new HashSet<>();

    public static class Builder extends AbstractEntity.Builder<Builder> {
        private final String email;
        private final String username;
        private final String password;
        private final Set<Authority> authorities;

        private boolean isLocked = false;
        private boolean isEnabled = false;
        private boolean isAccountExpired = false;
        private boolean isCredentialsExpired = false;

        public Builder isLocked(boolean isLocked) {
            this.isLocked = isLocked;
            return this;
        }

        public Builder isEnabled(boolean isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public Builder isAccountExpired(boolean isAccountExpired) {
            this.isAccountExpired = isAccountExpired;
            return this;
        }

        public Builder isCredentialsExpired(boolean isCredentialsExpired) {
            this.isCredentialsExpired = isCredentialsExpired;
            return this;
        }

        public Builder(String email, String username, String password, Set<Authority> authorities) {
            this.email = email;
            this.username = username;
            this.password = password;
            this.authorities = authorities;
        }

        @Override
        public User build() {
            return new User(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public User(Builder builder) {
        super(builder);
        this.email = builder.email;
        this.username = builder.username;
        this.password = builder.password;
        this.isLocked = builder.isLocked;
        this.isEnabled = builder.isEnabled;
        this.authorities = builder.authorities;
        this.isAccountExpired = builder.isAccountExpired;
        this.isCredentialsExpired = builder.isCredentialsExpired;
    }

    protected User() {
        super();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.isAccountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.isCredentialsExpired;
    }
}
