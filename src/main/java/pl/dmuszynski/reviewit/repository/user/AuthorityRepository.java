package pl.dmuszynski.reviewit.repository.user;

import org.springframework.data.repository.CrudRepository;
import pl.dmuszynski.reviewit.model.user.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {

}
