package pl.dmuszynski.reviewit.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmuszynski.reviewit.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
