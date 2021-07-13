package pl.dmuszynski.reviewitapi.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmuszynski.reviewitapi.model.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
