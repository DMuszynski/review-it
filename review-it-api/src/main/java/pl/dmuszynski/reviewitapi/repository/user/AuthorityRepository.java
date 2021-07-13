package pl.dmuszynski.reviewitapi.repository.user;

import org.springframework.data.repository.CrudRepository;
import pl.dmuszynski.reviewitapi.model.user.Authority;
import pl.dmuszynski.reviewitapi.model.user.AuthorityType;

import java.util.Optional;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {
    Optional<Authority> findByAuthorityType(AuthorityType authorityType);
}
