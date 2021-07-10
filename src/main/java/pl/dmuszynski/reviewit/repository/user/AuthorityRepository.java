package pl.dmuszynski.reviewit.repository.user;

import org.springframework.data.repository.CrudRepository;
import pl.dmuszynski.reviewit.model.user.Authority;
import pl.dmuszynski.reviewit.model.user.AuthorityType;

import java.util.Optional;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {
    Optional<Authority> findByAuthorityType(AuthorityType authorityType);
}
